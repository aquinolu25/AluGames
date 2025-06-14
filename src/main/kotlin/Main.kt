package org.example

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    var meuJogo:Jogo? = null

    val sc = Scanner(System.`in`)
    println("Digite um código de jogo que deseja buscar: ")
    val busca = sc.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=146$busca"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build()
    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()
/*    println(json)*/

    val gson = Gson()
    
    val resultado = runCatching {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)
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
        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso.")
    }

}