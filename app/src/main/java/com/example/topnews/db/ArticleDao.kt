package com.example.topnews.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.topnews.models.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Query("select COUNT(*) from articles where url = :artUrl")
    fun isArtAlreadySaved(artUrl:String) : Long

    @Delete
    suspend fun deleteArticle(article: Article)
}