import br.com.aquino.alugames.modelo.Gamer

fun main() {
    val gamer1 = Gamer("Ana Paula", "anapaulaa@hotmail.com")
    println(gamer1)

    val gamer2 = Gamer("Luiz", "luiz59@hotmail.com", "30/10/1997", "aquinolu")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "30/12/1985"
        it.usuario = "anaapaulaa"
    }.also {
        println(gamer1.idInterno)
    }

    println(gamer1)
}