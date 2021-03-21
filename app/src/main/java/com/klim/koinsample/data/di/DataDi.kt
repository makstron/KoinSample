package com.klim.koinsample.data.di

import com.klim.koinsample.data._retrofit.apis.feedback.PostApi
import com.klim.koinsample.data._retrofit.RetrofitProvider
import com.klim.koinsample.data.repository.post.PostDataSourceI
import com.klim.koinsample.data.repository.post.PostRepository
import com.klim.koinsample.data.repository.post.dataSources.remote.RemotePostDataSource
import com.klim.koinsample.domain.repositoryInterface.PostRepositoryI
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoriesModule = module {
    factory<PostRepositoryI> { PostRepository(get()) }
}

val dataSourcesModule = module {
    factory<PostDataSourceI> { RemotePostDataSource(get()) }
}

val dbModule = module {

}

val retrofitModule = module {
    single {
        RetrofitProvider().retrofit
    }

    single<PostApi> {
        get<Retrofit>().create<PostApi>(PostApi::class.java)
    }
}
