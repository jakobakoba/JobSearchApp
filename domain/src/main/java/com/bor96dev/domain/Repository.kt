package com.bor96dev.domain

interface Repository {

    suspend fun loadVacancies(): Pair<Boolean,List<Vacancy>>
}