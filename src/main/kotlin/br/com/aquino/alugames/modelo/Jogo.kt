package org.example.br.com.aquino.alugames.modelo

import br.com.aquino.alugames.modelo.Recomendavel


data class Jogo(val titulo:String, val capa:String): Recomendavel {
    var descricao: String? = null
    var preco = 0.0
    private val listaNotas = mutableListOf<Int>()

    constructor(titulo: String, capa: String, preco: Double, descricao: String):
            this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
    }

    override val media: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "Meu jogo:\n" +
                "Título: $titulo,\n" +
                "Capa: $capa \n" +
                "Preço: $preco\n" +
                "Descricao: $descricao"
    }

}