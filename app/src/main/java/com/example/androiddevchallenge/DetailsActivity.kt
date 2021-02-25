package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.theme.MyTheme

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Details(intent.getParcelableExtra("data")!!)
            }
        }
    }
}

@Composable
fun Details(petInfo: PetInfo) {
    val activity = LocalContext.current as AppCompatActivity
    Column {
        Box {
            Image(
                painterResource(id = R.drawable.a1), null,
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), contentScale = ContentScale.FillWidth
            )
            Button(
                onClick = { activity.finish() },
                colors = ButtonDefaults.buttonColors(
                    Color.Transparent, Color.Transparent,
                    Color.Transparent, Color.Transparent
                )
            ) {
                Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = null)
            }
        }
        Column(Modifier.padding(10.dp)) {
            Text(
                text = petInfo.name,
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
            )
            Text(text = petInfo.variety, color = Color.Black.copy(alpha = 0.75f))
            Text(text = petInfo.age, color = Color.Black.copy(alpha = 0.75f))
            Text(text = petInfo.address, color = Color.Black.copy(alpha = 0.75f))
            Text(
                text = petInfo.requirements,
                Modifier.padding(0.dp, 5.dp, 0.dp, 10.dp),
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
            )
            Button(onClick = {
                println("adopt it.$petInfo")
            }, Modifier.fillMaxWidth()) {
                Text(text = "adopt it")
            }
        }
    }
}