package frazao.felipe.mymoney.model

import java.math.BigDecimal

/**
 * Created by felipefrazao on 18/12/2017.
 */
class Resumo {
    var totalReceita = BigDecimal.ZERO
    var totalDespesa = BigDecimal.ZERO

    fun receita(transacoes: List<Transacao>): BigDecimal {
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor)
            }
        }
        return  totalReceita
    }

    fun despesa(transacoes: List<Transacao>): BigDecimal {

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