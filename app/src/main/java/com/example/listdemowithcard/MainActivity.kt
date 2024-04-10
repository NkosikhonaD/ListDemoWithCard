package com.example.listdemowithcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.listdemowithcard.ui.theme.ListDemoWithCardTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class MainActivity : ComponentActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListDemoWithCardTheme {

                    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {

                        val playerList = createPlayerObjectsList()

                        val navController = rememberNavController()

                        /**
                         * Nav Host : contains all the screens you want to navigate to
                         *
                         * a nav graph created by "composable(route= " ")"
                         *  each of the screens is placed in the nav graph via :
                         *  "composable(route="Screen1")
                         *  {
                         *      Screen1()   // Screen1 must be created already in  your app.
                         *  }
                         *  "composable(route="Screen2")
                         *   {
                         *       Screen2() // Screen2 must be created already in  your app.
                         *   }
                         *  "
                         *
                         * Nav Host Here you put all the different screens you would like to host in
                         */

                        NavHost(navController =navController , startDestination = "AllPlayersScreen")
                        {
                            composable(route="AllPlayersScreen")
                            {
                                AllPlayersScreen(playersList = playerList,navController=navController)
                            }
                            // Note place holder /{index} // will be a value received from AllPlayersScreen
                            composable(route="OnePlayerScreen/{index}", arguments = listOf(
                                navArgument(name="index")
                                {
                                    type = NavType.IntType
                                }
                            ))
                            {

                              index->
                                OnePlayerScreen(playersList = playerList, itemIndex =index.arguments?.getInt("index") )
                            }

                        }

                    }
            }
        }
    }
}

/**
 * Function that creates and  returns a list of players.
 */
fun createPlayerObjectsList(): List<Player>
{
    // create players
    val player1 = Player(
        name = "Trent",
        position = "Defender",
        imageIcon = R.drawable.trent,
        jerseyNumber = "66"
    )
    val player2 = Player(
        name = "Allison",
        position = "GoalKeeper",
        imageIcon = R.drawable.alison,
        jerseyNumber = "1"
    )
    val player3 = Player(
        name = "Nunez",
        position = "Striker",
        imageIcon = R.drawable.nunez,
        jerseyNumber = "9"
    )
    val player4 = Player(
        name = "Rob",
        position = "Middlefield",
        imageIcon = R.drawable.rob,
        jerseyNumber = "23"
    )
    val player5 = Player(
        name = "Salah",
        position = "Striker",
        imageIcon = R.drawable.salah,
        jerseyNumber = "11"
    )
    val player6 = Player(
        name = "Tiago",
        position = "Middlefield",
        imageIcon = R.drawable.tiago,
        jerseyNumber = "8"
    )
    val player7 = Player(
        name = "Van Diyk",
        position = "Defender",
        imageIcon = R.drawable.vandijk,
        jerseyNumber = "4"
    )
    val player8 = Player(
        name = "Waturu",
        position = "Middlefield",
        imageIcon = R.drawable.wataru,
        jerseyNumber = "3"
    )
    val player9 = Player(
        name = "Diaz",
        position = "Middlefield",
        imageIcon = R.drawable.diaz,
        jerseyNumber = "7"
    )
    val player10 = Player(
        name = "Dominik",
        position = "Middlefield",
        imageIcon = R.drawable.dominik,
        jerseyNumber = "8"
    )
    val player11 = Player(
        name = "Jota",
        position = "Middlefield",
        imageIcon = R.drawable.jota,
        jerseyNumber = "20"
    )

    var playerList = listOf<Player>(player1,
        player2,
        player3,
        player4,
        player5,
        player6,
        player7,
        player8,
        player9,
        player10,
        player11
            )
    return playerList
}
@Composable
fun CreatePlayCardNew(playerList:List<Player>,modifier: Modifier= Modifier,itemIndex:Int,navController: NavController) {
    // Create How one item in the list looks like.
    // Notice : .clickable { navController.navigate("OnePlayerScreen/$itemIndex") }
    //           click event that starts the navigation, also passes the data/ value itemIndex  on the route
    //
    Card(modifier= modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clickable { navController.navigate("OnePlayerScreen/$itemIndex") }
        , shape = CardDefaults.elevatedShape) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly)
        {

            Column(modifier= modifier.padding(5.dp))
            {

                Image(
                    painter = painterResource(id = playerList[itemIndex].imageIcon),
                    contentDescription = "player pic",
                    contentScale = ContentScale.Crop,
                    modifier= modifier
                        .size(50.dp)
                        .clip(shape = CircleShape)
                        .border(width = 1.dp, color = Color.Gray, shape = CircleShape)
                )
                Text(text = playerList[itemIndex].name, fontSize = 10.sp)

            }

            Text(text = playerList[itemIndex].position, fontSize = 15.sp)
            Spacer(modifier =modifier.width(2.dp))
            Text(text = playerList[itemIndex].jerseyNumber,fontStyle = FontStyle.Italic, fontSize = 8.sp)
        }
    }
}
