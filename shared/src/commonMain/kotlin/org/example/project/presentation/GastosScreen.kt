package org.example.project.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Observer en acción: la fila de Infraestructura cloud llega en vivo del Módulo 1 (mismo Facade). */
@Composable
fun GastosScreen(viewModel: GastosViewModel = remember { GastosViewModel() }) {
    val estado = viewModel.uiState

    Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        Text("FinAnalytics OS · Nébula Labs", style = MaterialTheme.typography.titleLarge)
        Text("Estructura de gastos", style = MaterialTheme.typography.titleMedium)

        Text("Usuarios activos mensuales (MAU): ${estado.mau}")
        Slider(
            value = estado.mau.toFloat(),
            onValueChange = { viewModel.onMauChange(it.toInt()) },
            valueRange = 0f..100_000f,
        )

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(estado.gastos) { gasto ->
                Text("${gasto.categoria} · ${gasto.concepto} (${gasto.tipo}) ... $ ${gasto.monto}")
            }
            item {
                Text("Infraestructura cloud (Módulo 1, reactivo) ... $ ${estado.costoInfraestructura}")
            }
        }

        HorizontalDivider()
        Text(
            "TOTAL DE EGRESOS / MES ... $ ${estado.totalEgresos}",
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            "Runway (caja / egresos) ... ${estado.runwayMeses} meses",
            style = MaterialTheme.typography.titleMedium,
        )
    }
}
