package com.sha.laza.utils

import com.sha.laza.data.Movies

class Utility {
    companion object{
        fun dummyData(): List<Movies> {
            return arrayListOf<Movies>(
                Movies(
                    "Bob",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                ),
                Movies(
                    "Chop",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
                ),
                Movies(
                    "Shop",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
                ),
                Movies(
                    "Khoob",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
                ),
                Movies(
                    "Doodh",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
                ),
                Movies(
                    "Bob",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
                ),
                Movies(
                    "Chop",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
                ),
                Movies(
                    "Shop",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
                ),
                Movies(
                    "Khoob",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
                ),
                Movies(
                    "Doodh",
                    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
                )
            )
        }
    }
}