package frazao.felipe.mymoney.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Resumo
import frazao.felipe.mymoney.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

/**
 * Created by felipefrazao on 18/12/2017.
 */

class ResumoView (private val view: View,
                  transacoes: List<Transacao>,
                  private val context: Context) {

    var totalReceita = BigDecimal.ZERO
    var totalDespesa = BigDecimal.ZERO
    private val resumo: Resumo = Resumo(transacoes)

    fun adicionaReceitaNoResumo() {
        totalReceita = resumo.receita()
        view.resumo_card_receita.text = totalReceita.formataParaBR()
        view.resumo_card_receita.setTextColor(ContextCompat.getColor(context, R.color.receita))

    }

    fun adicionarDespesaNoResumo() {
        totalDespesa = resumo.despesa()
        view.resumo_card_despesa.text = totalDespesa.formataParaBR()
        view.resumo_card_despesa.setTextColor(ContextCompat.getColor(context, R.color.despesa))

    }
    fun totalFinancas() {
        var cor : Int
        val total = resumo.total()

        when (total < BigDecimal.ZERO) {
            true -> cor = ContextCompat.getColor(context, R.color.despesa)
            false -> cor = ContextCompat.getColor(context, R.color.receita)
        }
//        if (total < BigDecimal.ZERO) {
//            cor = ContextCompat.getColor(context, R.color.despesa)
//        } else {
//            cor = ContextCompat.getColor(context, R.color.receita)
//        }

        view.resumo_card_total.setTextColor(cor)
        view.resumo_card_total.text = total.formataParaBR()
    }
}
