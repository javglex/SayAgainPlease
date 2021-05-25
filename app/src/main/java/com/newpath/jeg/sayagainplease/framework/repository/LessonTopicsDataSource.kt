package com.newpath.jeg.sayagainplease.framework.repository

import com.newpath.jeg.core.data.LessonTopic
import com.newpath.jeg.core.repository.LessonTopicDataSource

class LessonTopicsDataSource: LessonTopicDataSource {
    override suspend fun getAll(): List<LessonTopic> {

        return arrayListOf(
            LessonTopic(0, "Ground Ops", "Learn to taxi n shit"),
            LessonTopic(1, "Flight Following", "Voluntarily get spied on by ATC"),
            LessonTopic(2, "Flight plan", "Open or close flight plans"),
            LessonTopic(3, "Untowered airports", "Talk to other pylots"),
            LessonTopic(4, "Towered airports", "Argue with some guy without radar")
        );
    }
}