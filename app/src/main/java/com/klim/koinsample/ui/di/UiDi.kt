package com.klim.koinsample.ui.di

import com.klim.koinsample.ui.gallery.GalleryViewModel
import com.klim.koinsample.ui.home.HomeViewModel
import com.klim.koinsample.ui.slideshow.SlideshowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        GalleryViewModel()
    }

    viewModel {
        //android context will be get automatically (without provider)
        HomeViewModel(get(), get())
    }

    viewModel {
        SlideshowViewModel()
    }

//    scope(named<FeedbackFragment>()) {
//        scoped {Test()}
//    }
}