package com.klim.koinsample.data.repository.mappers

import com.klim.koinsample.data.repository.post.PostDTO
import com.klim.koinsample.domain.entity.PostEntity

fun List<PostDTO>.mapToEntity(): List<PostEntity> {
    return this.map {
        it.map()
    }
}

fun PostDTO.map(): PostEntity {
    return PostEntity(
        id = this.id,
        userId = this.userId,
        title = this.title,
        body = this.body,
    )
}