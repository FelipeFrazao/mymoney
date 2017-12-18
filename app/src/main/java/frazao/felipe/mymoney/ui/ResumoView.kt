package frazao.felipe.mymoney.ui

import android.view.View
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Resumo
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

        totalReceita = Resumo().receita(transacoes)

        view.resumo_card_receita.text = totalReceita.formataParaBR()

    }

    fun adicionarDespesaNoResumo() {

        totalDespesa = Resumo().despesa(transacoes)
        view.resumo_card_despesa.text = totalDespesa.formataParaBR()
    }
    fun totalFinancas() {
        val total = Resumo().total()
        view.resumo_card_total.text = total.formataParaBR()
    }
}