package org.example.project.presentation

import org.example.project.domain.model.Gasto

data class GastosUiState(
    val mau: Int = 60_000,
    val gastos: List<Gasto> = emptyList(),
    val costoInfraestructura: Double = 0.0,
    val totalEgresos: Double = 0.0,
    val runwayMeses: Double = 0.0,
)
