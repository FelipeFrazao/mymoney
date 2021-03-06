package frazao.felipe.mymoney.mpv

import android.content.Context
import android.view.View
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao

/**
 * Created by felipefrazao on 21/12/2017.
 */
interface MVP {
    interface ModelImpl {

        fun  addTransacao(
                context: Context,
                viewCriada: View?,
                tipo: Tipo,
                transacaoList : MutableList<Transacao>,
                transacao: Transacao
        )
    }
    interface PresenterImpl {

        fun  addTransacao(
                context: Context,
                viewCriada: View?,
                tipo: Tipo,
                transacaoList : MutableList<Transacao>,
                transacao: Transacao
        )
    }
}