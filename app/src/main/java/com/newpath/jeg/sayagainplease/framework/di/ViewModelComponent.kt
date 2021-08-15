package com.newpath.jeg.sayagainplease.framework.di

import com.newpath.jeg.sayagainplease.presentation.ui.classes.ClassesViewModel
import com.newpath.jeg.sayagainplease.presentation.ui.home.HomeViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, DataSourceModule::class])
interface ViewModelComponent {
    fun inject(homeViewModel: HomeViewModel)
    fun inject(classesViewModel: ClassesViewModel)
//    fun inject(listViewModel: ListViewModel
}
