package com.example.listdemowithcard

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun AllPlayersScreen(playersList:List<Player>,navController: NavController)
{
    LazyColumn(contentPadding = PaddingValues(16.dp))
    {
        val playersCount = playersList.size
        items(playersCount)
        {
            CreatePlayCardNew(playerList=playersList,itemIndex=it,navController=navController)
        }
    }
}