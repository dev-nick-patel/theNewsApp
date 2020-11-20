package com.techand.thenewsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.techand.thenewsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}