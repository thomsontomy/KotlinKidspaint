package com.thomson.common

actual fun getPlatformName(): String {
    return "Desktop"
}

actual fun currentTimeMillis(): Long {
    return System.currentTimeMillis()
}