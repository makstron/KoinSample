package com.klim.koinsample.domain.di

import com.klim.koinsample.domain.useCase.PostUseCase
import com.klim.koinsample.domain.useCaseInterface.PostUseCaseI
import org.koin.dsl.module

val useCasesModule = module {
    factory<PostUseCaseI> { PostUseCase(get()) }
}