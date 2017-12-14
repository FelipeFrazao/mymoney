package frazao.felipe.mymoney.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipefrazao on 14/12/2017.
 */
    fun Calendar.formatDataBR() : String {
        val formatoData = "dd/MM/yyyy"
        val dataFormatada = SimpleDateFormat(formatoData).format(this.time)
        return dataFormatada
    }
