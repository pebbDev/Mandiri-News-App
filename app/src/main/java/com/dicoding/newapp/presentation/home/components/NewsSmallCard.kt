package com.dicoding.newapp.presentation.home.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dicoding.newapp.R
import com.dicoding.newapp.domain.model.Article
import com.dicoding.newapp.domain.model.Source
import com.dicoding.newapp.presentation.onboarding.components.Dimens
import com.dicoding.newapp.presentation.onboarding.components.Dimens.ArticleCardSize
import com.dicoding.newapp.presentation.onboarding.components.Dimens.ArticleImageHeight
import com.dicoding.newapp.presentation.onboarding.components.Dimens.ExtraSmallPadding
import com.dicoding.newapp.presentation.onboarding.components.Dimens.ExtraSmallPadding2
import com.dicoding.newapp.presentation.onboarding.components.Dimens.SmallIconSize
import com.dicoding.newapp.ui.theme.NewAppTheme

@Composable
fun NewsSmallCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: (() -> Unit)? = null
) {

    val context = LocalContext.current

    Column(
        modifier = modifier.clickable { onClick?.invoke() },
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding2)
                .fillMaxWidth()
                .size(ArticleImageHeight)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(ExtraSmallPadding2))

        Column(
            modifier = Modifier.padding(horizontal = ExtraSmallPadding2)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium.copy(),
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = colorResource(id = R.color.body)
                )
                Spacer(modifier = Modifier.width(ExtraSmallPadding))
                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(id = R.color.body)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun NewsSmallCardPreview() {
    NewAppTheme(dynamicColor = false) {
        NewsSmallCard(
            article = Article(
                author = "",
                content = "",
                description = "",
                publishedAt = "2 hours",
                source = Source(id = "", name = "BBC"),
                title = "Her train broke down. Her phone died. And then she met her Saver in a",
                url = "",
                urlToImage = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg"
            )
        )
    }
}
