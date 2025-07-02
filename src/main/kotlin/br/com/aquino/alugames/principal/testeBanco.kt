package br.com.aquino.alugames.principal

import br.com.aquino.alugames.dados.Banco

fun main() {

    val conexao = Banco.obterConexao()
    println(conexao)

}