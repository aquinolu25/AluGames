package br.com.aquino.alugames.principal

import br.com.aquino.alugames.dados.Banco
import org.example.br.com.aquino.alugames.modelo.Jogo

fun main() {

    val listaJogos: List<Jogo> = Banco.getJogos()
    println(listaJogos)

}