package com.example.nopyjfmyandroidapp.home

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nopyjfmyandroidapp.action.HomeAction
import com.example.nopyjfmyandroidapp.model.HomeItemDisplay
import com.example.nopyjfmyandroidapp.theme.AppTheme
import com.example.nopyjfmyandroidapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
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
private fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    val action = viewModel.state.collectAsState()

    AppTheme {
        Scaffold(
            topBar = { HomeTopAppBar() }
        ) { padding ->
            when (action.value) {
                is HomeAction.Success,
                is HomeAction.AddItemSuccess -> {
                    HomeContent(padding, viewModel)
                }
                is HomeAction.Idle -> {
                    CircularProgressIndicator()
                }
            }
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
    viewModel: HomeViewModel,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(8.dp)
    ) {
        LazyColumn {

            val items = viewModel.state.value.getItems()

            items(items.size) { index ->
                HomeItem(items[index])
            }

            item {
                HomeAddButton(viewModel)
            }
        }
    }
}

@Composable
private fun HomeItem(
    data: HomeItemDisplay,
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = data.title)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = data.proteinWeight.toString())
    }
}

@Composable
private fun HomeAddButton(viewModel: HomeViewModel) {
    Button(
        onClick = {
            viewModel.addItem(
                HomeItemDisplay(title = "Rice", proteinWeight = 0.0)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(text = "Add")
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewScreen() {
    HomeScreen()
}