package frazao.felipe.mymoney.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*

/**
 * Created by felipefrazao on 15/12/2017.
 */

fun BigDecimal.formataParaBR() : String {
    val formatMoedaBr = DecimalFormat
            .getCurrencyInstance(Locale("pt", "br"))
    return formatMoedaBr.format(this)
            .replace("R$", "R$ ")
            .replace("-R$ ", "R$ -")

}