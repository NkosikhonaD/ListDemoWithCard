package com.example.listdemowithcard

import android.graphics.fonts.FontFamily
import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OnePlayerScreen(modifier: Modifier = Modifier, playersList:List<Player>, itemIndex: Int?
)
{
    val name = playersList[itemIndex!!].name
    val image = playersList[itemIndex!!].imageIcon
    val age= playersList[itemIndex!!].age
    val nationality = playersList[itemIndex!!].nationality
    val goals = playersList[itemIndex!!].goals
    val height =playersList[itemIndex!!].height
    val team = playersList[itemIndex!!].team

    Column(modifier= modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = image),
            contentDescription ="Image player $name",
            modifier= modifier
                .size(300.dp)
                .clip(shape = RoundedCornerShape(6.dp))
                )

        Text(text = "Name: $name Age: $age Height: $height",fontSize=16.sp, fontWeight = FontWeight.Bold )
        Text(text = "Nationality: $nationality, Current Team:  $team",fontSize=16.sp,fontWeight=FontWeight.Light)
    }

}