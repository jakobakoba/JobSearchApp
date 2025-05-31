package com.bor96dev.data

import android.content.Context
import com.bor96dev.domain.Recommendation
import com.bor96dev.domain.Vacancy
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MockDataSource @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private val gson = Gson()

    private val mockData by lazy {
        val inputStream = context.resources.openRawResource(
            context.resources.getIdentifier("mock", "raw", context.packageName)
        )
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        gson.fromJson(jsonString, ResponseDto::class.java)
    }

    fun getVacancies(): List<Vacancy> {
        return mockData.vacancies.map { it.toDomain() }
    }

    fun getRecommendations(): List<Recommendation> {
        return mockData.offers.map { it.toDomain() }
    }
}