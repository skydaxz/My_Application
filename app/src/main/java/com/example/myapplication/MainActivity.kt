package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.DataSource
import com.example.myapplication.model.Topic
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Grid(
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Grid(modifier: Modifier = Modifier){
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ){
        items(DataSource.topics){
                topic -> Card(topic)
        }
    }
}
@Composable
fun Card(topic: Topic, modifier: Modifier = Modifier){
    Row (
        modifier = modifier
            .background(color = Color.Gray)
        ) {
        Box {
            Image(painter = painterResource(id = topic.imageRes), contentDescription = null)
        }
        Column {
            Text(
                text = stringResource(id = topic.name),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(
                    start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp
                )
            )
            Row {
                Icon(painter = painterResource(id = R.drawable.ic_grain), contentDescription = null,
                    modifier = Modifier.padding(start = 16.dp)
                    )
                Text(text = topic.availableCourses.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier.padding(start = 8.dp)
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        val topic = Topic(R.string.photography,321, R.drawable.photography)
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(topic = topic)
        }
    }
}