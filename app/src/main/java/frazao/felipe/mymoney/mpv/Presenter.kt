package frazao.felipe.mymoney.mpv

import android.content.Context
import android.view.View
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao

/**
 * Created by felipefrazao on 21/12/2017.
 */
public class Presenter {
    var model: Model

    fun addTransact(context: Context, viewCriada: View?, tipo: Tipo, transacaoList: MutableList<Transacao>) {
        model.addTransacao(context, viewCriada, tipo, transacaoList)
    }

    init {
        model = Model(this)
    }

}