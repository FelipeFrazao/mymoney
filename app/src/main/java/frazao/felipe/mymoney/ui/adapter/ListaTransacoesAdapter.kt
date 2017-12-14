package frazao.felipe.mymoney.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.extension.formatDataBR
import frazao.felipe.mymoney.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

/**
 * Created by felipefrazao on 14/12/2017.
 */
class ListaTransacoesAdapter (transacoes: List<Transacao>,
                              context: Context) : BaseAdapter() {

    private val transacoes = transacoes
    private val context = context

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        val viewTransacoes : View = LayoutInflater.from(context)
                .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[posicao]

        viewTransacoes.transacao_titulo.text = transacao.titulo
        viewTransacoes.transacao_valor.text = transacao.valor.toString()
        viewTransacoes.transacao_categoria.text = transacao.categoria
        viewTransacoes.transacao_data.text = transacao.data.formatDataBR()

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