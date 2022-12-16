package ch.lock.mobile.android.deviceinfo.utils

import android.content.Context

open class ResourceProviderImpl(
    private val applicationContext: Context
) : ResourceProvider {

    override fun getString(resId: Int): String = applicationContext.getString(resId)

}

interface ResourceProvider {

    fun getString(resId: Int): String

}