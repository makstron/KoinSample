package com.klim.koinsample.data.repository.post.dataSources.remote

import com.klim.koinsample.data._retrofit.apis.feedback.PostApi
import com.klim.koinsample.data.repository.post.PostDTO
import com.klim.koinsample.data.repository.post.PostDataSourceI
import kotlinx.coroutines.flow.flow

class RemotePostDataSource(val postApi: PostApi) : PostDataSourceI {
    override fun getAll() = flow<List<PostDTO>> {
        emit(postApi.getAll().mapToDTO())
    }

}