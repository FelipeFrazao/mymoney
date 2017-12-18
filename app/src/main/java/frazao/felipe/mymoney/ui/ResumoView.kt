package frazao.felipe.mymoney.ui

import android.view.View
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Resumo
import frazao.felipe.mymoney.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

/**
 * Created by felipefrazao on 18/12/2017.
 */

class ResumoView (private val view: View,
                  transacoes: List<Transacao>) {

    var totalReceita = BigDecimal.ZERO
    var totalDespesa = BigDecimal.ZERO

    private val resumo: Resumo = Resumo(transacoes)

    fun adicionaReceitaNoResumo() {

        totalReceita = resumo.receita()

        view.resumo_card_receita.text = totalReceita.formataParaBR()

    }

    fun adicionarDespesaNoResumo() {

        totalDespesa = resumo.despesa()
        view.resumo_card_despesa.text = totalDespesa.formataParaBR()
    }
    fun totalFinancas() {
        val total = resumo.total()
        view.resumo_card_total.text = total.formataParaBR()
    }
}