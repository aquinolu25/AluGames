package br.com.aquino.alugames.principal

import br.com.aquino.alugames.modelo.Periodo
import br.com.aquino.alugames.servicos.ConsumoApi
import java.time.LocalDate

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

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(7))

    val aluguel = gamerCaroline.alugaJogo(jogoResidentVillage, periodo)
    println(aluguel)
}