package com.newpath.jeg.sayagainplease.framework.di

import android.app.Application
import com.newpath.jeg.sayagainplease.framework.repository.LessonTopicsDataSource
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {
    @Provides
    fun provideDataSource(app: Application) = LessonTopicsDataSource()
}
