package com.codegarage.testcurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.SnackbarHostState
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.flow.collect
import androidx.navigation.compose.rememberNavController
import com.codegarage.testcurrency.presentation.currencyconverter.CurrencySelectorPage
import com.codegarage.testcurrency.presentation.currencyconverter.HomePage
import com.codegarage.testcurrency.presentation.currencyconverter.di.viewModel
import com.codegarage.testcurrency.presentation.theme.AppTheme
import com.codegarage.testcurrency.presentation.util.HOME_PAGE
import com.codegarage.testcurrency.presentation.util.SELECTOR_PAGE
import com.codegarage.testcurrency.application.currencyconverter.*
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {

    private lateinit var logic: CurrencyConverterLogic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val snackbarHostState = SnackbarHostState()

        val homePageState: HomePageState = viewModel
        val currencySelectorPageState: CurrencySelectorPageState = viewModel
        logic = viewModel


        setContent {
            AppTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = HOME_PAGE) {
                    composable(HOME_PAGE) {
                        HomePage(
                            state = homePageState,
                            logic = logic,
                            snackbarHostState = snackbarHostState,
                            navController = navController
                        )
                    }
                    composable(SELECTOR_PAGE) {
                        CurrencySelectorPage(
                            state = currencySelectorPageState,
                            logic = logic,
                            snackbarHostState = snackbarHostState,
                            navController = navController
                        )
                    }
                }

            }
        }

        lifecycleScope.launch {
            homePageState.effectStream.collect {
                when (it) {
                    is CurrencyConverterEffect.ShowToast -> snackbarHostState.showSnackbar(
                        it.message
                    )
                }
            }
        }
    }

    override fun onStop() {
        logic.onEvent(CurrencyConverterEvent.OnStop)
        super.onStop()
    }
}
