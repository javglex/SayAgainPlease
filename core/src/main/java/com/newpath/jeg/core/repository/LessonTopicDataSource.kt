package com.newpath.jeg.core.repository

import com.newpath.jeg.core.data.LessonTopic

interface LessonTopicDataSource {
    suspend fun getAll(): List<LessonTopic>
}