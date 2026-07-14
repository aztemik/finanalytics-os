package org.example.project.domain

import org.example.project.domain.model.CostoInfraestructura
import org.example.project.domain.strategy.ModeloProyeccion
import org.example.project.domain.strategy.ProyeccionNoLineal

/** Facade: punto único de entrada del motor de cálculo para el ViewModel. */
class CalculoFinancieroFacade(
    private var estrategia: ModeloProyeccion = ProyeccionNoLineal,
) {
    fun cambiarEstrategia(nuevaEstrategia: ModeloProyeccion) {
        estrategia = nuevaEstrategia
    }

    fun calcularCostoInfraestructura(mau: Int): CostoInfraestructura =
        estrategia.calcular(mau)
}
