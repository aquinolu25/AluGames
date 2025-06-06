package org.example

data class Jogo(val titulo:String, val capa:String) {
    val descricao = ""

    override fun toString(): String {
        return "Meu jogo:\n" +
                "Título: $titulo,\n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }

}