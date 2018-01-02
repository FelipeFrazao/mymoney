package frazao.felipe.mymoney.model

import java.math.BigDecimal
import java.util.Calendar

/**
 * Created by felipefrazao on 14/12/2017.
 */
class Transacao(val titulo: String,
                val valor: BigDecimal,
                val tipo: Tipo,
                val categoria: String = "Indefinida",
                val data: Calendar =  Calendar.getInstance())
