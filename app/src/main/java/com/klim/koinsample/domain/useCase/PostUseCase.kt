package com.klim.koinsample.domain.useCase

import com.klim.koinsample.domain.entity.PostEntity
import com.klim.koinsample.domain.repositoryInterface.PostRepositoryI
import com.klim.koinsample.domain.useCaseInterface.PostUseCaseI
import kotlinx.coroutines.flow.Flow

class PostUseCase(private val postRepository: PostRepositoryI) : PostUseCaseI {

    override fun getAll(): Flow<List<PostEntity>> {
        return postRepository.getAll()
    }

}