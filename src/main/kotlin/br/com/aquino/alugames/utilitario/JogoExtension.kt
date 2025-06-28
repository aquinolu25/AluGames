package br.com.aquino.alugames.utilitario

import br.com.aquino.alugames.modelo.InfoJogoJson
import org.example.br.com.aquino.alugames.modelo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}