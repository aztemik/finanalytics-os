package org.example.project.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.example.project.domain.CalculoFinancieroFacade
import org.example.project.domain.strategy.ProyeccionLineal
import org.example.project.domain.strategy.ProyeccionNoLineal

/** MVVM + Observer: la UI se suscribe a [uiState] (Compose State) y se redibuja sola. */
class InfraViewModel(
    private val facade: CalculoFinancieroFacade = CalculoFinancieroFacade(),
) {
    var uiState by mutableStateOf(InfraUiState())
        private set

    init {
        recalcular()
    }

    fun onMauChange(nuevoMau: Int) {
        uiState = uiState.copy(mau = nuevoMau)
        recalcular()
    }

    fun onModeloChange(lineal: Boolean) {
        facade.cambiarEstrategia(if (lineal) ProyeccionLineal else ProyeccionNoLineal)
        uiState = uiState.copy(modeloLineal = lineal)
        recalcular()
    }

    private fun recalcular() {
        uiState = uiState.copy(costo = facade.calcularCostoInfraestructura(uiState.mau))
    }
}
