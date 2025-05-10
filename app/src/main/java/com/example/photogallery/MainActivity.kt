package com.example.photogallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.photogallery.ui.theme.PhotoGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PhotoGalleryTheme {
                PhotoGallery()

            }
        }
    }
}

@Composable
fun PhotoGallery() {
    val pair1 = listOf(Pair(R.drawable.cat, "Cat"),Pair(R.drawable.neon,"Neon Sign"))
    val pair2 = listOf(Pair(R.drawable.goodboy, "Good Boy"), Pair(R.drawable.rose, "Rose"))
    val pair3 = listOf(Pair(R.drawable.dice, "Dice"), Pair(R.drawable.elephant_water, "Elephants?"))
    val pair4 = listOf(Pair(R.drawable.random_art, "Night Life"), Pair(R.drawable.buildings, "Cool Building"))

    val allPhotos = listOf(pair1,pair2,pair3,pair4)
    Column ( modifier = Modifier
        .padding(vertical = 20.dp)
        .fillMaxSize()
        .background(Color.Cyan)

    )
    {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Photo Gallery",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
            )
        }

        for (pair in allPhotos) {
            val firstColumn = pair[0]
            val secondColumn = pair[1]
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PhotowithDees(photo = firstColumn.first, des = firstColumn.second)
                Spacer(modifier = Modifier.width(8.dp))
                PhotowithDees(photo = secondColumn.first, des = secondColumn.second)
            }

            Spacer(modifier = Modifier.height(14.dp))


        }
    }
}

@Composable
fun PhotowithDees(photo: Int, des: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(150.dp)
    ) {

        Image(
            painter = painterResource(id = photo),
            contentDescription = des,
            modifier = Modifier.size(160.dp)
                .fillMaxWidth()
                .height(150.dp)
        )

        Text(
            text = des,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(3.dp)

                .align(Alignment.CenterHorizontally)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PhotoGalleryTheme {
        PhotoGallery()
    }
}