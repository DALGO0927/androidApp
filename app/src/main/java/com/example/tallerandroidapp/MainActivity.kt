package com.example.tallerandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tallerandroidapp.screens.FormScreen
import com.example.tallerandroidapp.screens.ViewScreen
import com.example.tallerandroidapp.screens.SettingsScreen
import com.example.tallerandroidapp.ui.theme.TallerAndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TallerAndroidAppTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "form",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("form") { FormScreen(navController) }
            composable(
                "view/{nombre}/{apellido}/{ficha}",
                arguments = listOf(
                    navArgument("nombre") { type = NavType.StringType },
                    navArgument("apellido") { type = NavType.StringType },
                    navArgument("ficha") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                ViewScreen(
                    nombre = backStackEntry.arguments?.getString("nombre") ?: "",
                    apellido = backStackEntry.arguments?.getString("apellido") ?: "",
                    ficha = backStackEntry.arguments?.getString("ficha") ?: ""
                )
            }
            composable("settings") { SettingsScreen() }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    NavigationBar {
        NavigationBarItem(
            label = { Text("Formulario") },
            icon = { androidx.compose.material3.Icon(Icons.Default.Edit, contentDescription = null) },
            selected = currentRoute == "form",
            onClick = { navController.navigate("form") }
        )
        NavigationBarItem(
            label = { Text("Ver Datos") },
            icon = { androidx.compose.material3.Icon(
                Icons.AutoMirrored.Filled.List,
                contentDescription = null
            ) },
            selected = currentRoute == "view",
            onClick = { navController.navigate("view") }
        )
        NavigationBarItem(
            label = { Text("Ajustes") },
            icon = { androidx.compose.material3.Icon(Icons.Default.Settings, contentDescription = null) },
            selected = currentRoute == "settings",
            onClick = { navController.navigate("settings") }
        )
    }
}



