package org.example.br.com.aquino.alugames.modelo

data class Jogo(val titulo:String, val capa:String) {
    var descricao: String? = null

    override fun toString(): String {
        return "Meu jogo:\n" +
                "Título: $titulo,\n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }

}