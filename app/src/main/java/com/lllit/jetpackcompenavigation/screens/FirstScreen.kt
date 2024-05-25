@file:OptIn(ExperimentalMaterial3Api::class)

package com.lllit.jetpackcompenavigation.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lllit.jetpackcompenavigation.R
import com.lllit.jetpackcompenavigation.navigation.AppScreens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@Composable
fun FirstScreen(navController: NavController) {
    Scaffold(
        content = { BodyContent(navController) },
        topBar = { ToolBar() },
        bottomBar = { BottomBar() },
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        CenterAlignedTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                //containerColor = Color.Green,
                //titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text(
                    "FirstScreen",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White
                )
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Icon Menu",
                    )
                }
            },
        )
    }
}

@Composable
fun BodyContent(navController: NavController) {
    //ImaGEN
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                //.height(100.dp),
                //.width(300.dp),
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Imagen Abstracta"
            )
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                //.height(3000.dp),
                //.width(3000.dp),
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Imagen Abstracta"
            )
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                //.height(3000.dp),
                //.width(3000.dp),
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Imagen Abstracta"
            )
        }
    }

    //Contenido

    var counter by rememberSaveable { mutableIntStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(
                text = "Abstracción Visual",
                fontSize = 33.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 76.dp),
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp, 3.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.compu),
                        contentDescription = "Icono PC"
                    )
                }
                Text(
                    text = "Generative art",
                    color = Color.White
                )
                Text(
                    text = "Music",
                    color = Color.White
                )
                Text(
                    text = "Programing",
                    color = Color.White
                )
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.compu),
                        contentDescription = "Icono PC"
                    )
                }

            }
            //Contador
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.compu),
                    contentDescription = "Icono",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }

    //Boton
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(11.dp),
        //.background(DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        //Text(text = "Siguiente", color = Color.White)
        Button(onClick = {
            navController.navigate(route = AppScreens.SecondScreen.route)
        }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Siguiente pagina"
            )
        }
    }
}

@Composable
fun BottomBar() {
    MaterialTheme(
        colorScheme = darkColorScheme()
    ) {
        BottomAppBar(
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Bottom Check"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Bottom Edit"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Bottom Person"
                    )
                }
            },
            floatingActionButton = { FAB() },
            //floatingActionButtonPosition = FabPosition.End
        )
    }
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Toask", Toast.LENGTH_SHORT).show()
    }) {
        Icon(Icons.Default.Add, contentDescription = "MORE")
    }
}




