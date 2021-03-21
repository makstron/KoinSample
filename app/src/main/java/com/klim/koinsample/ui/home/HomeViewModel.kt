package com.klim.koinsample.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.klim.koinsample.domain.useCaseInterface.PostUseCaseI
import com.klim.koinsample.ui.home.mappers.mapToPostView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HomeViewModel(application: Application, val postUseCase: PostUseCaseI) :
    AndroidViewModel(application) {

    private val _posts = MutableLiveData<ArrayList<PostView>>().apply {
        value = ArrayList<PostView>()
    }
    val posts: LiveData<ArrayList<PostView>> = _posts

    fun updatePosts() {
        viewModelScope.launch(Dispatchers.Main) {
            postUseCase.getAll()
                .flowOn(Dispatchers.IO)
                .collect { list ->
                    _posts.value?.apply {
                        clear()
                        addAll(list.mapToPostView())
                    }
                    _posts.value = _posts.value
                }
        }
    }
}