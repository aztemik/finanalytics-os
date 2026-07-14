package org.example.project.domain.model

data class CostoInfraestructura(
    val baseFija: Double,
    val baseDatos: Double,
    val computo: Double,
    val almacenamiento: Double,
) {
    val total: Double
        get() = baseFija + baseDatos + computo + almacenamiento
}
