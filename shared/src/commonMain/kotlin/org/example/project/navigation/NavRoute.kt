package org.example.project.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoute {

    @Serializable
    data object Login : NavRoute()

    @Serializable
    data object Movies : NavRoute()

    @Serializable
    data object Profile : NavRoute()



}