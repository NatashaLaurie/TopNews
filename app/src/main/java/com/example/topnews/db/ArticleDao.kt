package com.example.topnews.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.topnews.models.Result

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Result): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Result>>

    @Delete
    suspend fun deleteArticle(article: Result)
}