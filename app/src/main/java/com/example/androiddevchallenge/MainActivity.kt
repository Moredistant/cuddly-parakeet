/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
//                RowCard()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(), color = Color.Gray.copy(0.5f)
    ) {
        val str = "Adoption requirements\n" +
                "1. Adult.\n" +
                "2. Have a fixed source of income and can bear the cost of keeping a dog.\n" +
                "3. Make sure you don't abandon it.\n" +
                "4. Send a video photo or something to the former owner when you have time."
//        Text(text = "Ready... Set... GO!")
        val feedItems = mutableListOf<PetInfo>()
        feedItems.add(PetInfo("Sprouting", "Teddy", "1 year old", "China", str))
        feedItems.add(PetInfo("Mica", "Siberian husky", "2 year old", "China", str))
        feedItems.add(PetInfo("Poppy", "Akita", "3 year old", "China", str))
        feedItems.add(PetInfo("Conte", "Beagle", "4 year old", "China", str))
        feedItems.add(PetInfo("Max", "Siberian husky", "5 year old", "China", str))
        feedItems.add(PetInfo("Molly", "Basset Hound", "6 year old", "China", str))
        feedItems.add(PetInfo("Lucy", "Border Collie", "7 year old", "China", str))
        feedItems.add(PetInfo("Bailey", "Siberian husky", "8 year old", "China", str))
        LazyColumn {
            item {
                Text(
                    text = "Free adoption",
                    Modifier.padding(10.dp, 10.dp, 0.dp, 15.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
            }
            items(feedItems) {
                RowCard(petInfo = it)
            }
        }
    }
}

@Composable
fun RowCard(petInfo: PetInfo) {
    val context = LocalContext.current
    Column(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(10.dp, 0.dp, 10.dp, 10.dp)
    ) {
        Card(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable {
                    context.startActivity(
                        Intent(
                            context,
                            DetailsActivity::class.java
                        ).putExtra("data", petInfo)
                    )
                }, shape = RoundedCornerShape(10.dp)
        ) {
            Row {
                Image(
                    painterResource(R.drawable.a2),
                    null,
                    Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
                Column(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
                    Text(
                        text = petInfo.name,
                        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    )
                    Text(text = petInfo.variety, color = Color.Black.copy(alpha = 0.75f))
                    Text(text = petInfo.age, color = Color.Black.copy(alpha = 0.75f))
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
