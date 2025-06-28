package br.com.aquino.alugames.principal

import br.com.aquino.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogoJson = consumo.buscaJogosJson()

//    println(listaGamers)
//    println(jogoApi)

    val gamerCaroline = listaGamers.get(3)
    val jogoResidentVillage = listaJogoJson.get(10)

    println(gamerCaroline)
    println(jogoResidentVillage)

    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage)
    println(aluguel)
}