package com.dicoding.newapp.presentation.home

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import com.dicoding.newapp.R
import com.dicoding.newapp.domain.model.Article
import com.dicoding.newapp.presentation.common.ArticlesList
import com.dicoding.newapp.presentation.common.ArticlesList2
import com.dicoding.newapp.presentation.common.SearchBar
import com.dicoding.newapp.presentation.home.components.NewsHeadingSection
import com.dicoding.newapp.presentation.onboarding.components.Dimens.MediumPadding1
import kotlinx.coroutines.delay


@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    state: HomeState,
    event: (HomeEvent) -> Unit,
    navigateToSearch: () -> Unit,
    navigateToDetails: (Article) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_mandiri),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        SearchBar(
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .fillMaxWidth(),
            text = "",
            readOnly = true,
            onValueChange = {},
            onSearch = {},
            onClick = navigateToSearch
        )

        Spacer(modifier = Modifier.height(MediumPadding1))
        NewsHeadingSection(
            title = stringResource(id = R.string.label_headline_news),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        val scrollState = rememberScrollState(initial = state.scrollValue)

        LaunchedEffect(key1 = scrollState.maxValue) {
            event(HomeEvent.UpdateMaxScrollingValue(scrollState.maxValue))
        }
        LaunchedEffect(key1 = scrollState.value) {
            event(HomeEvent.UpdateScrollValue(scrollState.value))
        }
        LaunchedEffect(key1 = state.maxScrollingValue) {
            delay(500)
            if (state.maxScrollingValue > 0) {
                scrollState.animateScrollTo(
                    value = state.maxScrollingValue,
                    animationSpec = infiniteRepeatable(
                        tween(
                            durationMillis = (state.maxScrollingValue - state.scrollValue) * 50_000 / state.maxScrollingValue,
                            easing = LinearEasing,
                            delayMillis = 1000
                        )
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(MediumPadding1))

        ArticlesList2(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            articles = articles,
            onClick = navigateToDetails
        )
    }
}