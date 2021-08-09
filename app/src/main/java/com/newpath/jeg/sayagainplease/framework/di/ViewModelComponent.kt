package com.newpath.jeg.sayagainplease.framework.di

import com.newpath.jeg.sayagainplease.framework.viewmodels.home.HomeViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, DataSourceModule::class])
interface ViewModelComponent {
    fun inject(homeViewModel: HomeViewModel)
//    fun inject(listViewModel: ListViewModel
}
