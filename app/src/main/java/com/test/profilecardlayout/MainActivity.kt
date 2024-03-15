package com.test.profilecardlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import com.test.profilecardlayout.ui.theme.MyTheme
import com.test.profilecardlayout.ui.theme.lightGreen200
import com.test.profilecardlayout.ui.theme.veryLightGray


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = veryLightGray
    ) {
        ProfileCard()
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = "Vipin tyagi", style = MaterialTheme.typography.bodyLarge)
        Text(
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.alpha(ContentAlpha.disabled),
            text = "Active Now"
        )
    }

}

@Composable
fun ProfilePicture() {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = lightGreen200),
        modifier = Modifier
            .padding(16.dp)
            .wrapContentSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Image(
            painterResource(id = R.drawable.profile),
            contentDescription = "Content Description",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .wrapContentHeight(align = Alignment.Top),
        colors = CardDefaults.cardColors(
            containerColor = Color.White, //Card background color
            contentColor = Color.Black  //Card content color,e.g.text
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture()
            ProfileContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyTheme {
        MainScreen()
    }

}