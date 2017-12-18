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

    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDepesa = ContextCompat.getColor(context, R.color.despesa)
    private var corTotal : Int = 0

    fun adicionaReceitaNoResumo() {

        with (view.resumo_card_receita) {
            totalReceita = resumo.receita
            text = totalReceita.formataParaBR()
            setTextColor(corReceita)
        }
    }

    fun adicionarDespesaNoResumo() {

        with (view.resumo_card_despesa) {
            totalDespesa = resumo.despesa
            text = totalDespesa.formataParaBR()
            setTextColor(corDepesa)
        }
    }
    fun totalFinancas() {
        val total = resumo.total()

        when (total.compareTo(BigDecimal.ZERO)) {
            -1 -> corTotal = corDepesa
            1 -> corTotal = corReceita
            else -> {
                corTotal = ContextCompat.getColor(context, R.color.neutra)
            }
        }
        with (view.resumo_card_total) {
            setTextColor(corTotal)
            text = total.formataParaBR()
        }
    }

    fun atualiza () {
        adicionaReceitaNoResumo()
        adicionarDespesaNoResumo()
        totalFinancas()
    }
}
