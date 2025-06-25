package br.com.aquino.alugames.utilitario

import br.com.aquino.alugames.modelo.Gamer
import br.com.aquino.alugames.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}