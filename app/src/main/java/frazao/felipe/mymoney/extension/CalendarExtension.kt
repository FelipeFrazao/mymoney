package frazao.felipe.mymoney.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipefrazao on 14/12/2017.
 */
    fun Calendar.formataParaBR() : String {
        val formatoData = "dd/MM/yyyy"
         return SimpleDateFormat(formatoData).format(this.time)
    }
