package org.example.project.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.data.repository.GastosRepository
import org.example.project.data.repository.ParametrosRepository
import org.example.project.domain.CalculoFinancieroFacade

/**
 * MVVM + Observer (RF-03, apoyo mínimo): reutiliza el mismo Facade del Módulo 1
 * para que la Infraestructura cloud llegue reactiva, sin duplicar el motor de cálculo.
 */
class GastosViewModel(
    private val facade: CalculoFinancieroFacade = CalculoFinancieroFacade(),
) {
    var uiState by mutableStateOf(GastosUiState(gastos = GastosRepository.GASTOS))
        private set

    init {
        recalcular()
    }

    fun onMauChange(nuevoMau: Int) {
        uiState = uiState.copy(mau = nuevoMau)
        recalcular()
    }

    private fun recalcular() {
        val costoInfra = facade.calcularCostoInfraestructura(uiState.mau).total
        val totalGastosBase = GastosRepository.GASTOS.sumOf { it.monto }
        val totalEgresos = totalGastosBase + costoInfra
        uiState = uiState.copy(
            costoInfraestructura = costoInfra,
            totalEgresos = totalEgresos,
            runwayMeses = ParametrosRepository.CAJA_INICIAL / totalEgresos,
        )
    }
}
