package br.com.aquino.alugames.modelo

import java.math.BigDecimal

class PlanoAvulso(
    tipo: String, id: Int = 0): Plano(tipo) {

    override fun obterValor(aluguel: Aluguel): BigDecimal {
        var valorOriginal = super.obterValor(aluguel)
        if (aluguel.gamer.media > 8) {
            valorOriginal -= valorOriginal.multiply(BigDecimal("0.1"))
        }
        return valorOriginal
    }
}
