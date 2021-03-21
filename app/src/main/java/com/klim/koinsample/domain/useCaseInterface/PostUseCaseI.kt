package com.klim.koinsample.domain.useCaseInterface

import com.klim.koinsample.domain.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface PostUseCaseI {
    fun getAll(): Flow<List<PostEntity>>
}