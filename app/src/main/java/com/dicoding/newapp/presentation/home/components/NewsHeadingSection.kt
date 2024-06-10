package com.dicoding.newapp.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.newapp.R
import com.dicoding.newapp.presentation.onboarding.components.Dimens
import com.dicoding.newapp.presentation.onboarding.components.Dimens.ExtraSmallPadding2
import com.dicoding.newapp.ui.theme.NewAppTheme

@Composable
fun NewsHeadingSection(
    modifier: Modifier = Modifier,
    title: String
) {
    val context = LocalContext.current
    val isDarkTheme = if (!LocalInspectionMode.current) {
        context.resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK == android.content.res.Configuration.UI_MODE_NIGHT_YES
    } else {
        false
    }

    val textColor = if (isDarkTheme) {
        Color.White
    } else {
        Color.Black
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = Dimens.ExtraSmallPadding3)
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            color = textColor,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewsHeadingSection() {
    NewAppTheme {
        NewsHeadingSection(
            title = stringResource(R.string.label_headline_news),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
