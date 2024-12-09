package com.example.tallerandroidapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ViewScreen(nombre: String, apellido: String, ficha: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Vista de Datos", style = MaterialTheme.typography.titleLarge)
        Text("Nombre: $nombre", style = MaterialTheme.typography.bodyLarge)
        Text("Apellido: $apellido", style = MaterialTheme.typography.bodyLarge)
        Text("Ficha: $ficha", style = MaterialTheme.typography.bodyLarge)
    }
}

