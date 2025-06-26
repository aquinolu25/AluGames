package br.com.aquino.alugames.principal

import br.com.aquino.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val jogoApi = consumo.buscaJogo("174")

    println(listaGamers)
    println(jogoApi)
}