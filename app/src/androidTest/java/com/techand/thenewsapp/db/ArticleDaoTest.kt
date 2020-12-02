package com.techand.thenewsapp.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.techand.thenewsapp.getOrAwaitValue
import com.techand.thenewsapp.models.Article
import com.techand.thenewsapp.models.Source
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class ArticleDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: ArticleDatabase
    private lateinit var dao: ArticleDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            ArticleDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.getArticleDao()
    }

    @After
    fun tearDown(){
        database.close()
    }

    @Test
    fun insertArticle() = runBlockingTest {

        val article = Article(id = 1,
            "author",
            "content",
            "description",
            "publishedAt",
            null,
            "title",
            "url",
        "urlToImage")

        dao.upsert(article)

        val allArticles = dao.getAllArticles().getOrAwaitValue()

        assertThat(allArticles).contains(article)

    }


}