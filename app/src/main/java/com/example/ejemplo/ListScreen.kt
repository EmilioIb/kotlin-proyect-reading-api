package com.example.ejemplo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo.model.Perros
import com.example.ejemplo.ui.theme.EjemploTheme


@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
) {
    val perrosList by viewModel.getNews().observeAsState(initial = emptyList())
    ListScreen(navController, perrosList)
}



@Composable
fun ListScreen(
    navController: NavController,
    perros: List<Perros>
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Perros") }
            )
        }
    ) {
        LazyColumn {
            items(perros) { new ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    backgroundColor = Color.DarkGray,
                    contentColor = Color.White
                )
                {
                    Column() {
                        Text(
                            text = new.id.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(3.dp)
                        )
                        Text(
                            text = new.nombre, textAlign = TextAlign.Center, modifier = Modifier
                                .fillMaxWidth()
                                .padding(3.dp)
                        )
                        Text(
                            text = new.raza, textAlign = TextAlign.Center, modifier = Modifier
                                .fillMaxWidth()
                                .padding(3.dp)
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun Inicio(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate(Destinations.LISTADO) }) {
            Text(text = "Consultar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    EjemploTheme() {






    }
}

