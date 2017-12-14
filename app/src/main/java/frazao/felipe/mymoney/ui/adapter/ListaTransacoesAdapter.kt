package frazao.felipe.mymoney.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import frazao.felipe.mymoney.R

/**
 * Created by felipefrazao on 14/12/2017.
 */
class ListaTransacoesAdapter (transacoes: List<String>,
                              context: Context) : BaseAdapter() {

    private val transacoes = transacoes
    private val context = context

    override fun getView(posicao: Int, view: View?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)

    }

    override fun getItem(posicao: Int): String {
        return transacoes[posicao]
        }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return  transacoes.size
    }
}