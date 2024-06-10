package com.dicoding.newapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.dicoding.newapp.domain.model.Article
import com.dicoding.newapp.presentation.home.components.NewsSmallCard
import com.dicoding.newapp.presentation.onboarding.components.Dimens

@Composable
fun ArticlesList2(
    modifier: Modifier = Modifier,
    articles: List<Article>,
    onClick: (Article) -> Unit
) {
    if (articles.isEmpty()){
        EmptyScreen()
    }
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
        contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)
    ) {
        items(
            count = articles.size,
        ) {
            articles[it]?.let { article ->
                NewsSmallCard(article = article, onClick = { onClick(article) })
            }
        }
    }

}

@Composable
fun ArticlesList2(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {

    val handlePagingResult = handlePagingResult2(articles)

    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding1),
            contentPadding = PaddingValues(all = Dimens.ExtraSmallPadding2)
        ) {
            items(
                count = articles.itemCount,
            ) {
                articles[it]?.let { article ->
                    NewsSmallCard(article = article, onClick = { onClick(article) })
                }
            }
        }
    }
}

@Composable
fun handlePagingResult2(articles: LazyPagingItems<Article>): Boolean {
    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen(error = error)
            false
        }

        else -> {
            true
        }
    }
}
