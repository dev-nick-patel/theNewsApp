package com.techand.thenewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.techand.thenewsapp.R
import com.techand.thenewsapp.ui.NewsActivity
import com.techand.thenewsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private lateinit var viewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { loadUrl(it) }
        }

        fab.setOnClickListener{
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
        }
    }
}