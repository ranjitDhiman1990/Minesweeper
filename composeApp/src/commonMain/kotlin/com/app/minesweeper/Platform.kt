package com.app.minesweeper

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform