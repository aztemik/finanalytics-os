package org.example.project.domain.model

enum class TipoGasto { FIJO, VARIABLE }

data class Gasto(
    val categoria: String,
    val tipo: TipoGasto,
    val concepto: String,
    val monto: Double,
)
