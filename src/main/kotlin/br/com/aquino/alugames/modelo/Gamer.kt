package br.com.aquino.alugames.modelo

import org.example.br.com.aquino.alugames.modelo.Jogo
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()) {
                criaIdInterno()
            }
        }
    var idInterno: String? = null
        private set

    var plano: Plano = PlanoAvulso("BRONZE")
    val jogosBuscados = mutableListOf<Jogo?>()
    val jogosAlugados = mutableListOf<Aluguel>()

    constructor(nome: String, email: String, dataNascimento: String, usuario: String): this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criaIdInterno()
    }

    init {
        if (nome.isNullOrBlank()) {
            throw IllegalArgumentException("Nome está em branco")
        }
       this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    fun criaIdInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)
        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
          throw IllegalArgumentException("Email inválido")
        }
    }

    fun alugaJogo(jogo: Jogo, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogo, periodo)
        jogosAlugados.add(aluguel)
        return aluguel
    }

    fun jogosDoMes(mes:Int): List<Jogo> {
        return jogosAlugados
            .filter { aluguel ->  aluguel.periodo.dataInicial.monthValue == mes}
            .map { aluguel ->  aluguel.jogo}
    }

    companion object {
        fun criarGamer(sc: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = sc.nextLine()
            println("Digite seu e-mail:")
            val email = sc.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = sc.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = sc.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = sc.nextLine()

                return Gamer(nome, email,nascimento, usuario)
            } else {
                return Gamer(nome, email)
            }
        }
    }

}
