package org.example.project.signin.presentation.screen
import androidx.navigation.NavHostController
import org.example.project.navigation.NavRoute
import org.example.project.signin.presentation.state.LoginViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.project.signin.presentation.composable.LoginButton
import org.example.project.signin.presentation.composable.LoginTextField
import org.example.project.signin.presentation.composable.PasswordTextField
import org.example.project.signin.presentation.state.LoginEffect
import org.example.project.signin.presentation.state.LoginEvent
import androidx.compose.material3.Button
@Composable
fun LoginScreen(
    navController: NavHostController
) {
    val viewModel = remember {
        LoginViewModel()
    }

    val state = viewModel.state
    val effect = viewModel.effect

    val snackbarHostState = remember {
        SnackbarHostState()
    }

    LaunchedEffect(effect) {

        when (val currentEffect = effect) {

            is LoginEffect.ShowError -> {
                snackbarHostState.showSnackbar(
                    message = currentEffect.message
                )
            }

            LoginEffect.NavigateToMovies -> {
                navController.navigate(NavRoute.Movies)
            }

            LoginEffect.NavigateToProfile -> {
                navController.navigate(NavRoute.Profile)
            }

            null -> {}
        }
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "LOG IN"
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            LoginTextField(
                value = state.username,
                onValueChange = { username ->
                    viewModel.onEvent(
                        LoginEvent.UsernameChanged(username)
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            PasswordTextField(
                value = state.password,
                onValueChange = { password ->
                    viewModel.onEvent(
                        LoginEvent.PasswordChanged(password)
                    )
                }
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            if (state.isLoading) {

                CircularProgressIndicator()

            } else {

                LoginButton(
                    onClick = {
                        viewModel.onEvent(
                            LoginEvent.LoginClicked
                        )
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(
                onClick = {
                    viewModel.onEvent(
                        LoginEvent.ProfileClicked
                    )
                }
            ) {
                Text("IR A PERFIL")
            }
        }
    }
}