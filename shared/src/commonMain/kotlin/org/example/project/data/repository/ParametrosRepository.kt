package org.example.project.data.repository

/**
 * Datos ficticios de Nébula Labs, precargados en memoria.
 * No hay backend ni base de datos: el objetivo del entregable es
 * evidenciar el control de versiones, no la persistencia.
 */
object ParametrosRepository {
    const val COSTO_BASE_FIJO = 250.0 // línea del conflicto controlado (Fase 5)
    const val COEF_BASE_DATOS = 23.0
    const val EXP_BASE_DATOS = 1.30
    const val COEF_COMPUTO = 60.0
    const val COEF_ALMACEN = 33.0
    const val COEF_BD_LINEAL = 78.5
    const val CAJA_INICIAL = 600_000.0
    const val MAU_INICIAL = 60_000
}
