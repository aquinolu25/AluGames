package org.example.br.com.aquino.alugames.principal

import br.com.aquino.alugames.modelo.Gamer
import br.com.aquino.alugames.servicos.ConsumoApi
import org.example.br.com.aquino.alugames.modelo.Jogo
import transformarEmIdade
import java.util.*

fun main() {

    val sc = Scanner(System.`in`)
    val gamer = Gamer.criarGamer(sc)
    println("Cadastro concluído com sucesso!!! Dados do gamer:")
    println(gamer)
    println("Idade do gamer: " + gamer.dataNascimento?.transformarEmIdade())

    do {
        println("Digite um código de jogo que deseja buscar: ")

        val busca = sc.nextLine()
        val buscaApi = ConsumoApi()
        val informacaoJogo = buscaApi.buscaJogo(busca)
        var meuJogo: Jogo? = null

        val resultado = runCatching {
            val informacaoJogo = buscaApi.buscaJogo(busca)
            meuJogo = Jogo(informacaoJogo.info.title, informacaoJogo.info.thumb)
        }

        resultado.onFailure {
            println("Jogo não existe, tente outro id.")
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição personalizada para o jogo? S/N")
            val opcao = sc.nextLine()
            if (opcao.equals("S", true)) {
                println("Insira a descrição personalizada para o jogo: ")
                val descricaoPersonalizada = sc.nextLine()
                meuJogo?.descricao = descricaoPersonalizada
            } else {
                meuJogo?.descricao = meuJogo?.titulo
            }
           gamer.jogosBuscados.add(meuJogo)
        }

        println("Deseja buscar um novo jogo? S/N")
        val resposta = sc.nextLine()

    } while (resposta.equals("s", true))

    println("Jogos buscados:")
    println(gamer.jogosBuscados)

    println("\n Jogos ordenados por titulo: ")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Título: " + it?.titulo)
    }

    val jogosFiltados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("Jogos filtrados: ")
    println(jogosFiltados)

    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = sc.nextLine()
    if (opcao.equals("s", true)) {
        println(gamer.jogosBuscados)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val posicao = sc.nextInt()
        gamer.jogosBuscados.removeAt(posicao)
    }

    println("\nLista atualizada")
    println(gamer.jogosBuscados)

    println("Busca finalizada com sucesso.")

}