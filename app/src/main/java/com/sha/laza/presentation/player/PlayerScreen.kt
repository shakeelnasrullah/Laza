package com.sha.laza.presentation.player

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.database.StandaloneDatabaseProvider
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.datasource.DefaultHttpDataSource
import androidx.media3.datasource.FileDataSource
import androidx.media3.datasource.cache.CacheDataSink
import androidx.media3.datasource.cache.CacheDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory
import androidx.media3.ui.PlayerView
import com.sha.laza.data.Movies
import com.sha.laza.utils.Utility
import java.io.File

@androidx.annotation.OptIn(UnstableApi::class)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlayerScreen(modifier: Modifier) {

    val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()

    // Screen Content
    Box(modifier = Modifier.fillMaxSize()) {

        val pagerState = rememberPagerState(pageCount = {
            10
        })
        val videoList = Utility.dummyData()
        VerticalPager(state = pagerState) { page ->
            // Our page content
            createPlayer(modifier = Modifier.fillMaxSize(), videoList, page)

        }

    }


}

@androidx.annotation.OptIn(UnstableApi::class)
@Composable
fun createPlayer(modifier: Modifier, videoList: List<Movies>, page: Int) {

    val context = LocalContext.current

    val playerListener = object : Player.Listener {
        override fun onPlaybackStateChanged(playbackState: Int) {
            val stateString: String = when (playbackState) {
                ExoPlayer.STATE_IDLE -> "ExoPlayer.STATE_IDLE      -"
                ExoPlayer.STATE_BUFFERING -> "ExoPlayer.STATE_BUFFERING -"
                ExoPlayer.STATE_READY -> "ExoPlayer.STATE_READY     -"
                ExoPlayer.STATE_ENDED -> "ExoPlayer.STATE_ENDED     -"
                else -> "UNKNOWN_STATE             -"
            }
            //Log.d(TAG, "changed state to $stateString")
        }
    }

    var cacheDataSource : CacheDataSource.Factory
    val exoPlayer = ExoPlayer.Builder(context).build().apply {
        val mediaItem = MediaItem.fromUri(videoList[page].url)
        cacheDataSource = createCache(context)
        val mediaSource = DefaultMediaSourceFactory(cacheDataSource).createMediaSource(mediaItem)
        //val factory = DefaultMediaSourceFactory(context).createMediaSource(mediaItem)

        //setMediaSource(factory)
        setMediaSource(mediaSource)
        prepare()
        addListener(playerListener)
        playWhenReady = true
        //play()

    }
    Box(modifier = modifier){
        DisposableEffect(key1 = Unit){
            onDispose {
                exoPlayer.release()
            }
        }
        AndroidView(factory = {
            PlayerView(context).apply {
                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        })
    }



    // PlayerView


}


@androidx.annotation.OptIn(UnstableApi::class)
fun createCache(context: Context): CacheDataSource.Factory {
    val DOWNLOAD_CONTENT_DIRECTORY = "downloads"
    val downloadContentDirectory =
        File(context.getExternalFilesDir(null),DOWNLOAD_CONTENT_DIRECTORY)
   /* val downloadCache =
        SimpleCache(downloadContentDirectory, NoOpCacheEvictor(), StandaloneDatabaseProvider(context))*/

    val downloadCache =
        VideoCache.getInstance(downloadContentDirectory, StandaloneDatabaseProvider(context))
    val cacheSink = CacheDataSink.Factory()
        .setCache(downloadCache)
    val upstreamFactory = DefaultDataSource.Factory(context, DefaultHttpDataSource.Factory())
    val downStreamFactory = FileDataSource.Factory()
    val cacheDataSourceFactory  =
        CacheDataSource.Factory()
            .setCache(downloadCache)
            .setCacheWriteDataSinkFactory(cacheSink)
            .setCacheReadDataSourceFactory(downStreamFactory)
            .setUpstreamDataSourceFactory(upstreamFactory)
            .setFlags(CacheDataSource.FLAG_IGNORE_CACHE_ON_ERROR)
    return cacheDataSourceFactory
}

