package com.example.rickandmortycompose.navigation

import com.example.rickandmortycompose.R


/**
 * This class described screen navigation objects
 * @param screenName - deeplink screen representation
 * @param titleResourceId - resource to name tabbar or appbar navigation title
 */
sealed class Screen(val screenName: String, val titleResourceId: Int, val iconResourceId: Int) {
    object Main: Screen("main", R.string.app_name, -1)
    object Episodes: Screen("DDDD", R.string.episodes, R.drawable.ic_list_episodes)
    object Locations: Screen("DDDD1", R.string.location, R.drawable.ic_locations)
    object Characters: Screen("DDDD2", R.string.characters, R.drawable.ic_characters)
//    object User: Screen("user", -1)
//    object List: Screen("list", R.string.title_list)
//    object Complex: Screen("complex", R.string.title_complex)
//    object Push: Screen("push", R.string.title_push)
//    object NewMessage: Screen("new_message", R.string.title_message)
}