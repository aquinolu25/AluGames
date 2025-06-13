package org.example

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.Scanner

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
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
    println(json)

    val gson = Gson()

    try {
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        println(meuInfoJogo)
    } catch (e: JsonSyntaxException) {
        val jogos: List<InfoJogo> = gson.fromJson(json, Array<InfoJogo>::class.java).toList()
        jogos.forEach { jogo -> println(jogo) }
    }



}