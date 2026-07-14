package org.example.project.presentation

import org.example.project.domain.model.CostoInfraestructura

data class InfraUiState(
    val mau: Int = 60_000,
    val modeloLineal: Boolean = false,
    val costo: CostoInfraestructura = CostoInfraestructura(0.0, 0.0, 0.0, 0.0),
)
