package com.example.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class JetpackActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MyPuppiesContent()
        }
    }

    @Composable
    fun getRow(name :String, lifespan: String, compatibility: String, drawable : Int) {
        MaterialTheme {
            val typo = MaterialTheme.typography
            Row(modifier = Modifier.padding(top = 8.dp,
                    bottom = 4.dp).background(color = Color.White)) {
                Image(
                        imageResource(id = drawable),
                        modifier = Modifier
                                .preferredSize(80.dp),
                        contentScale = ContentScale.Inside
                )
                Spacer(Modifier.preferredHeight(16.dp))

                Column(modifier = Modifier.padding(start = 8.dp)) {
                    Text(name,
                            style = typo.h6.merge(TextStyle(color = Color.Black)))
                    Text(text = "Lifespan - $lifespan", style = TextStyle(color = Color.Gray))
                    Text(text = "Compatibilty with other pets - $compatibility", style = TextStyle(color = Color.Blue, fontSize = 14.sp))
                }
            }
        }
    }

    @Composable
    @Preview
    fun MyPuppiesContent(names: List<String> = listOf("Akita", "Alaskan Malamute","Beagle", "Bichon Frise", "Jack Russel", "Norwich Terrier", "Pomeranian", "Portuguese Water Dog"),
                         lifespan: List<String> = listOf("8 years", "10 years", "13 years", "16 years","14 years", "15 years", "10 TO 12 years", "14 years"),
                         compatibility: List<String> = listOf("Tends to show dominance over other dogs.",
                                 "The breed is known for showing aggression towards other dogs.",
                                 "Beagles are pack hounds and as such are definitely better off with some company during the day.",
                                 "The Bichon Frise adapts well to other pets if reared with them, or introduced to them gradually. It will cope with both cats and other dogs quite well.",
                                 "It is pretty Excellent and is a very friendly dog..",
                                 "Norwich Terriers are very adaptable little dogs and will get on well with other family pets.",
                                 "The Pomeranian has a friendly disposition but as with any new family pet, should be introduced carefully to any other resident companion animals.",
                                 "When brought up with other pets in the home, they will form a strong friendship and respect for each other. They generally get on very well with other dogs when outside their home environment."
                             ),
                         drawable: List<Int> = listOf(R.drawable.akita, R.drawable.alaskan, R.drawable.beagle, R.drawable.bichon, R.drawable.jack, R.drawable.norwich, R.drawable.pomeranian, R.drawable.portuguese)) {


        Column (
                modifier = Modifier
                        .padding(8.dp)
                        .background(Color.Transparent)
        ) {
            ScrollableColumn(modifier = Modifier.weight(1f)) {
                for((i, name) in names.withIndex()) {
                    getRow(name = name, lifespan = lifespan[i], compatibility[i], drawable[i])
                    Divider(color = Color.Black)
                }
            }
        }
    }
}