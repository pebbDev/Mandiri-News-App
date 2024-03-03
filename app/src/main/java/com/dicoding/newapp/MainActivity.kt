package com.dicoding.newapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.dicoding.newapp.domain.usecase.AppEntryUseCase
import com.dicoding.newapp.presentation.onboarding.OnBoardingScreen
import com.dicoding.newapp.presentation.onboarding.OnBoardingViewModel
import com.dicoding.newapp.ui.theme.NewAppTheme
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appEntryUseCases: AppEntryUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        lifecycleScope.launch {
            appEntryUseCases.readAppEntry().collect{
                Log.d("Test",it.toString())
            }
        }
        setContent {
            NewAppTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event= viewModel::onEvent
                )
                }
            }
        }
    }
}
