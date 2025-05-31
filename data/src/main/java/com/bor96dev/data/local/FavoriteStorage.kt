package com.bor96dev.data.local

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FavoriteStorage @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs = context.getSharedPreferences("favorites", Context.MODE_PRIVATE)

    fun getFavoriteIds(): Set<String> {
        return prefs.getStringSet("favorite_ids", emptySet()) ?: emptySet()
    }

    fun addToFavorites(vacancyId: String) {
        val favorites = getFavoriteIds().toMutableSet()
        favorites.add(vacancyId)
        prefs.edit { putStringSet("favorite_ids", favorites) }
    }

    fun removeFromFavorites(vacancyId: String) {
        val favorites = getFavoriteIds().toMutableSet()
        favorites.remove(vacancyId)
        prefs.edit { putStringSet("favorite_ids", favorites) }
    }

    fun getFavoritesCount(): Int {
        return getFavoriteIds().size
    }
}