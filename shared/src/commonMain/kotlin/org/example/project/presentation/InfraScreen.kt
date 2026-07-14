package org.example.project.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Observer en acción: cada cambio de [InfraViewModel.uiState] redibuja esta pantalla sola, sin recargar nada. */
@Composable
fun InfraScreen(viewModel: InfraViewModel = remember { InfraViewModel() }) {
    val estado = viewModel.uiState

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("FinAnalytics OS · Nébula Labs", style = MaterialTheme.typography.titleLarge)
        Text("Cálculo dinámico de infraestructura", style = MaterialTheme.typography.titleMedium)

        Text("Usuarios activos mensuales (MAU): ${estado.mau}")
        Slider(
            value = estado.mau.toFloat(),
            onValueChange = { viewModel.onMauChange(it.toInt()) },
            valueRange = 0f..100_000f,
        )

        Row {
            RadioButton(selected = !estado.modeloLineal, onClick = { viewModel.onModeloChange(false) })
            Text("No lineal")
            RadioButton(selected = estado.modeloLineal, onClick = { viewModel.onModeloChange(true) })
            Text("Lineal")
        }

        Text("Base fija ......... $ ${estado.costo.baseFija}")
        Text("Base de datos ..... $ ${estado.costo.baseDatos}")
        Text("Cómputo ........... $ ${estado.costo.computo}")
        Text("Almacenamiento .... $ ${estado.costo.almacenamiento}")
        Text(
            "COSTO DE INFRAESTRUCTURA / MES ... $ ${estado.costo.total}",
            style = MaterialTheme.typography.titleMedium,
        )
    }
}
