package frazao.felipe.mymoney.mpv

import frazao.felipe.mymoney.model.Transacao

/**
 * Created by felipefrazao on 21/12/2017.
 */
class Model (
        transacoes: MutableList<Transacao>) {

    private val transacoes = transacoes

    fun addTransacao (transacao: Transacao, transacaoList: MutableList<Transacao>) {

            transacaoList.add(transacao)
    }

    fun updateTransacao (transacao: Transacao, transacaoList: MutableList<Transacao>, indexOf: Int) {

            transacaoList.set(indexOf, transacao)
    }

    fun removeTransacao (indexOf: Int) {

        transacoes.removeAt(indexOf)
    }
}