package com.kirilovskikh.labs.data

import java.io.Serializable

/**
 * Created by kirilovskikh on 12.05.17.
 */

data class SimpleListModel(val id: Long,
                           val text: String) : Serializable

data class NewsModel(val id: Long,
                     var image: String? = null,
                     val text: String? = null,
                     var isAdvertising: Boolean = false)