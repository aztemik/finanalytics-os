package org.example.project.domain.strategy

import org.example.project.data.repository.ParametrosRepository
import org.example.project.domain.model.CostoInfraestructura
import kotlin.math.pow

/** Strategy: cada modelo de proyección sabe calcular el costo a partir del MAU. */
interface ModeloProyeccion {
    fun calcular(mau: Int): CostoInfraestructura
}

/** La base de datos escala peor que el cómputo: exponente > 1. */
object ProyeccionNoLineal : ModeloProyeccion {
    override fun calcular(mau: Int): CostoInfraestructura {
        val u = mau / 1000.0
        return CostoInfraestructura(
            baseFija = ParametrosRepository.COSTO_BASE_FIJO,
            baseDatos = ParametrosRepository.COEF_BASE_DATOS * u.pow(ParametrosRepository.EXP_BASE_DATOS),
            computo = ParametrosRepository.COEF_COMPUTO * u,
            almacenamiento = ParametrosRepository.COEF_ALMACEN * u,
        )
    }
}

/** Coincide con el modelo no lineal exactamente en 60k MAU (punto de calibración). */
object ProyeccionLineal : ModeloProyeccion {
    override fun calcular(mau: Int): CostoInfraestructura {
        val u = mau / 1000.0
        return CostoInfraestructura(
            baseFija = ParametrosRepository.COSTO_BASE_FIJO,
            baseDatos = ParametrosRepository.COEF_BD_LINEAL * u,
            computo = ParametrosRepository.COEF_COMPUTO * u,
            almacenamiento = ParametrosRepository.COEF_ALMACEN * u,
        )
    }
}
