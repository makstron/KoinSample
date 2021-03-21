package com.klim.koinsample.data.repository.post

import kotlinx.coroutines.flow.Flow

interface PostDataSourceI {
    fun getAll(): Flow<List<PostDTO>>
}