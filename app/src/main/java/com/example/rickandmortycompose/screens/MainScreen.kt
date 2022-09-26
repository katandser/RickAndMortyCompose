package com.example.rickandmortycompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortycompose.navigation.Router
import com.example.rickandmortycompose.navigation.Screen
import androidx.navigation.compose.composable
import com.example.rickandmortycompose.R
import com.example.rickandmortycompose.ui.theme.Shapes


@Composable
fun MainScreen(
    router: Router
) {
    // Stored in memory NavHostController
    // Live through recompose and configuration changed cycle by rememberSaveable
    val navController = rememberNavController()
    val bottomItems = listOf(Screen.Episodes, Screen.Characters, Screen.Locations)

    Scaffold(
        bottomBar = {
            BottomNavigation {
                bottomItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = false,
                        onClick = {
                            navController.navigate(screen.screenName) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo = navController.graph.startDestinationId

                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                            }
                        },
                        label = { Text(stringResource(id = screen.titleResourceId)) },
                        icon = {
                            Icon(
                                painter = painterResource(id = screen.iconResourceId),
                                contentDescription = "",
                                //modifier = Modifier.background(Color.Black, RectangleShape)
                            )
                        })
                }
            }
        }
    ) {
        NavHost(navController = navController, startDestination = Screen.Episodes.screenName) {
            composable(Screen.Episodes.screenName) { EpisodesScreen(navController) }
            composable(Screen.Locations.screenName) { LocationsScreen(navController) }
            composable(Screen.Characters.screenName) { CharactersScreen(navController) }
        }
    }
}