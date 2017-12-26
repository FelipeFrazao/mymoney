package frazao.felipe.mymoney.mpv

import frazao.felipe.mymoney.model.Transacao

/**
 * Created by felipefrazao on 21/12/2017.
 */
class Model {

    fun addTransacao (transacao: Transacao, transacaoList: MutableList<Transacao>) {

            transacaoList.add(transacao)
    }

    fun updateTransacao (transacao: Transacao, transacaoList: MutableList<Transacao>, indexOf: Int) {

            transacaoList.set(indexOf, transacao)
    }

    fun removeTransacao (transacaoList: MutableList<Transacao>, indexOf: Int) {

        transacaoList.removeAt(indexOf)
    }
}