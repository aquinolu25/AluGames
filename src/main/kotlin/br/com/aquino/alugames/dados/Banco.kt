package br.com.aquino.alugames.dados

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object Banco {

    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/alugames", "root", "194150")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}