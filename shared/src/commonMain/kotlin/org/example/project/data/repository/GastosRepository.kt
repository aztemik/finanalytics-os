package org.example.project.data.repository

import org.example.project.domain.model.Gasto
import org.example.project.domain.model.TipoGasto.FIJO
import org.example.project.domain.model.TipoGasto.VARIABLE

/**
 * Gastos ficticios de Nébula Labs (Anexo C.3), fijos en memoria.
 * La partida de Infraestructura cloud NO está aquí: se toma en vivo
 * del Módulo 1 (CalculoFinancieroFacade), para reutilizar el mismo Observer.
 */
object GastosRepository {
    val GASTOS: List<Gasto> = listOf(
        Gasto("Nómina y honorarios", FIJO, "Desarrollador backend", 7_500.0),
        Gasto("Nómina y honorarios", FIJO, "Desarrollador frontend", 6_900.0),
        Gasto("Nómina y honorarios", FIJO, "Diseñador UX (medio tiempo)", 3_200.0),
        Gasto("Nómina y honorarios", FIJO, "Cargas patronales y prestaciones", 5_300.0),
        Gasto("Nómina y honorarios", VARIABLE, "Contratista QA (honorarios)", 3_200.0),
        Gasto("Costos fijos", FIJO, "Renta de oficina", 6_000.0),
        Gasto("Costos fijos", FIJO, "Licencias de software", 3_200.0),
        Gasto("Costos fijos", FIJO, "Servicios básicos (luz, internet)", 1_400.0),
        Gasto("Costos fijos", FIJO, "Contabilidad externa", 1_000.0),
        Gasto("Costos variables", VARIABLE, "Comisiones de pasarela de pago", 2_600.0),
        Gasto("Costos variables", VARIABLE, "Campañas de adquisición", 3_000.0),
        Gasto("Costos variables", VARIABLE, "Herramientas de soporte por uso", 860.0),
        Gasto("Costos variables", VARIABLE, "Correos transaccionales", 500.0),
        Gasto("Imprevistos", VARIABLE, "Reserva operativa", 2_900.0),
    )
}
