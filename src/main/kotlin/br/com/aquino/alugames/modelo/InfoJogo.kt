package org.example.br.com.aquino.alugames.modelo

data class InfoJogo(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}