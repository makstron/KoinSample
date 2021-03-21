package com.klim.koinsample.domain.repositoryInterface

import com.klim.koinsample.domain.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostRepositoryI {
    fun getAll(): Flow<List<PostEntity>>
}