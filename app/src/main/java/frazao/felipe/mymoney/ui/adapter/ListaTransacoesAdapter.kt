package frazao.felipe.mymoney.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

/**
 * Created by felipefrazao on 14/12/2017.
 */
class ListaTransacoesAdapter (private val transacoes: List<Transacao>,
                              private val context: Context) : BaseAdapter() {

    private fun addValorEIcone(transacao: Transacao, view: View) {
        var cor : Int
        var icone: Int
        // verifica o tipo de receita configura icone e a cor da transacao
        if (transacao.tipo == Tipo.RECEITA) {
            cor = ContextCompat.getColor(context, R.color.receita)
            icone = R.drawable.icone_transacao_item_receita

        } else {
            icone = R.drawable.icone_transacao_item_receita
            cor = ContextCompat.getColor(context, R.color.despesa)
        }

        view.transacao_icone
                .setBackgroundResource(icone)

        view.transacao_valor
                .setTextColor(cor)

        view.transacao_valor.text = transacao.valor.formataParaBR()
    }

    // pegando a view
    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        // passando a view que será inflada e setando a view group e a criacao da view
        val viewTransacoes : View = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        addValorEIcone(transacao, viewTransacoes)

        // Atribuindo valores dos campos
        viewTransacoes.transacao_titulo.text = transacao.titulo
        viewTransacoes.transacao_categoria.text = transacao.categoria
        viewTransacoes.transacao_data.text = transacao.data.formataParaBR()

        return viewTransacoes
    }

    override fun getItem(posicao: Int): Transacao {
        return transacoes[posicao]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return  transacoes.size
    }
}