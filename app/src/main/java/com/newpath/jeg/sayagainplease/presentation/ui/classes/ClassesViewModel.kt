package com.newpath.jeg.sayagainplease.presentation.ui.classes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.newpath.jeg.core.data.LessonTopic
import com.newpath.jeg.sayagainplease.framework.di.ApplicationModule
import com.newpath.jeg.sayagainplease.framework.di.DaggerViewModelComponent
import com.newpath.jeg.sayagainplease.framework.repository.LessonTopicsDataSource
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClassesViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var dataSource: LessonTopicsDataSource
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val _topics = MutableLiveData<ArrayList<LessonTopic>>()
    val topics: LiveData<ArrayList<LessonTopic>> = _topics

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)

        coroutineScope.launch {
            val listTopics: ArrayList<LessonTopic> = dataSource.getAll() as ArrayList<LessonTopic>
            _topics.postValue(listTopics)
        }
    }
}
