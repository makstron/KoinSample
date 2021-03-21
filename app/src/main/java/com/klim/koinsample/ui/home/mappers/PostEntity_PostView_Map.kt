package com.klim.koinsample.ui.home.mappers

import com.klim.koinsample.domain.entity.PostEntity
import com.klim.koinsample.ui.home.PostView

fun List<PostEntity>.mapToPostView(): List<PostView> {
    return this.map { it.map() }
}

fun PostEntity.map(): PostView {
    return PostView(
        id = this.id,
        title = this.title,
        body = this.body,
    )
}