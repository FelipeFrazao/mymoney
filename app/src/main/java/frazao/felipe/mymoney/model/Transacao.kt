package frazao.felipe.mymoney.model

import java.math.BigDecimal
import java.util.Calendar

/**
 * Created by felipefrazao on 14/12/2017.
 */
class Transacao(titulo: String,
                valor: BigDecimal,
                categoria: String,
                data: Calendar) {
    private val titulo : String = titulo
    private val valor : BigDecimal = valor
    private val categoria : String = categoria
    private val data : Calendar = data

    fun getValor() : BigDecimal {
        return valor
    }
}