package com.klim.koinsample.data.repository.post

import com.klim.koinsample.data.repository.mappers.mapToEntity
import com.klim.koinsample.domain.entity.PostEntity
import com.klim.koinsample.domain.repositoryInterface.PostRepositoryI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostRepository(private val remote: PostDataSourceI): PostRepositoryI {

    override fun getAll(): Flow<List<PostEntity>> {
        return remote.getAll().map { it.mapToEntity() }
    }

}