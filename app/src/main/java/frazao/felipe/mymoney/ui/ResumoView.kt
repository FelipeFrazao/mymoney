package frazao.felipe.mymoney.ui

import android.view.View
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

/**
 * Created by felipefrazao on 18/12/2017.
 */

class ResumoView (private val view: View,
                  private val transacoes: List<Transacao>) {

    var totalReceita = BigDecimal.ZERO
    var totalDespesa = BigDecimal.ZERO

    fun adicionaReceitaNoResumo() {
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor)
            }
        }
        view.resumo_card_receita.text = totalReceita.formataParaBR()
    }

    fun adicionarDespesaNoResumo() {
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.DESPESA) {
                totalDespesa = totalDespesa.plus(transacao.valor)
            }
        }
        view.resumo_card_despesa.text = totalDespesa.formataParaBR()
    }
    fun totalFinancas() {
        var total = totalReceita - totalDespesa
        view.resumo_card_total.text = total.formataParaBR()
    }
}