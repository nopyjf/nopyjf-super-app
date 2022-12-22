package com.example.nopyjfmyandroidapp.home

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nopyjfmyandroidapp.theme.AppTheme
import com.example.nopyjfmyandroidapp.theme.DarkTheme


class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeScreen() {
    AppTheme {
        Scaffold(
            topBar = { HomeTopAppBar() }
        ) { padding ->
            HomeContent(padding)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopAppBar() {
    TopAppBar(
        title = {
            Text(text = "NopyJF App")
        },
    )
}

@Composable
private fun HomeContent(
    padding: PaddingValues,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(8.dp)
    ) {
        Column {
            // HomeItemList()
            HomeAddButton()
        }
    }
}

@Composable
private fun HomeAddButton() {
    Button(
        onClick = {
            updateValue()
        },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(text = "Add")
    }
}

private fun updateValue() {
    Log.d("TEST", "TEST_D")
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewScreen() {
    HomeScreen()
}