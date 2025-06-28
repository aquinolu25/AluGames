package br.com.aquino.alugames.modelo

import org.example.br.com.aquino.alugames.modelo.Jogo

data class InfoJogoJson( val titulo: String,
                         val capa: String,
                         val preco: Double,
                         val descricao: String)

    fun InfoJogoJson.criaJogo(): Jogo {
        return Jogo(this.titulo, this.capa, this.preco, this.descricao)
    }


