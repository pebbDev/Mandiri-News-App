package com.dicoding.newapp.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.dicoding.newapp.R
import com.dicoding.newapp.presentation.onboarding.Page
import com.dicoding.newapp.presentation.onboarding.components.Dimens.MediumPadding1
import com.dicoding.newapp.presentation.onboarding.components.Dimens.MediumPadding2
import com.dicoding.newapp.presentation.onboarding.pages
import com.dicoding.newapp.ui.theme.NewAppTheme

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    page: Page,
) {

    Column(modifier = Modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            text = page.description, 
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview
@Composable
fun OnBoardingPagePriview(){
    NewAppTheme {
        OnboardingPage(page =
        pages[0])
    }
}