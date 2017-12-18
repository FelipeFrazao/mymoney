package frazao.felipe.mymoney.model

import java.math.BigDecimal

/**
 * Created by felipefrazao on 18/12/2017.
 */
class Resumo(private val transacoes: List<Transacao>) {
    var totalReceita = BigDecimal.ZERO
    var totalDespesa = BigDecimal.ZERO

    fun receita(): BigDecimal {
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor)
            }
        }
        return  totalReceita
    }

    fun despesa(): BigDecimal {

        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.DESPESA) {
                totalDespesa = totalDespesa.plus(transacao.valor)
            }
        }
        return  totalDespesa
    }

    fun total(): BigDecimal {
        return totalReceita - totalDespesa
    }
}