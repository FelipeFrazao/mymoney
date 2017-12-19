package frazao.felipe.mymoney.extension

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipefrazao on 19/12/2017.
 */

fun String.converteParaCalendar (): Calendar {
    val simpleDateFormatBR = SimpleDateFormat("dd/MM/yyyy")
    val dataBr = simpleDateFormatBR.parse(this)
    val data = Calendar.getInstance()
    data.time = dataBr
    return data
}