package com.example.feature_nutrients.activity

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.theme.AppTheme
import com.example.feature_nutrients.action.HomeAction
import com.example.feature_nutrients.viewmodel.HomeViewModel
import com.example.model.nutrient.display.NutrientItemDisplay
import com.example.model.nutrient.request.NutrientItemRequest
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
    viewModel: HomeViewModel = hiltViewModel()
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

                is HomeAction.AddItemFailed -> {
                    // Display Error
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

            val homeItems = viewModel.getItems()

            items(homeItems.size) { index ->
                HomeItem(homeItems[index])
            }

            item {
                HomeAddButton { request ->
                    viewModel.addItem(request)
                }
            }
        }
    }
}

@Composable
private fun HomeItem(
    data: NutrientItemDisplay,
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
private fun HomeAddButton(
    addItem: (NutrientItemRequest) -> Unit,
) {
    Button(
        onClick = {
            val request = NutrientItemRequest(
                title = "Rice",
                proteinWeight = 0.0,
            )
            addItem(request)
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        Text(text = "Add")
    }
}