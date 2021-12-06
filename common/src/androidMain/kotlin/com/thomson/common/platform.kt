package com.thomson.common

actual fun getPlatformName(): String {
    return "Android"
}

actual fun currentTimeMillis(): Long {
    return System.currentTimeMillis()
}