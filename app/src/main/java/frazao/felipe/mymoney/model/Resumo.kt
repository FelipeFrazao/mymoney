package frazao.felipe.mymoney.model

import java.math.BigDecimal

/**
 * Created by felipefrazao on 18/12/2017.
 */
class Resumo(private val transacoes: List<Transacao>) {

    private fun somaPor(tipo: Tipo): Double {
        var somaPeloTipo = transacoes.filter { it.tipo == tipo }
                .sumByDouble { it.valor.toDouble() }
        return somaPeloTipo
    }

    val receita get () : BigDecimal = BigDecimal(somaPor(Tipo.RECEITA))

    val despesa get () : BigDecimal =  BigDecimal(somaPor(Tipo.DESPESA))

    fun total() : BigDecimal = receita - despesa

}