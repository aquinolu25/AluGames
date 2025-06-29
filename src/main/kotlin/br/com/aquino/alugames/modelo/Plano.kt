package br.com.aquino.alugames.modelo

open class Plano(val tipo: String) {

    fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.emDias
    }

}