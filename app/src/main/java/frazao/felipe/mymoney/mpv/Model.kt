package frazao.felipe.mymoney.mpv

import android.content.Context
import android.view.View
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipefrazao on 21/12/2017.
 */
class Model(private var Presenter: Presenter) {

    init {

    }
    fun addTransacao (
            context: Context,
            viewCriada: View?,
            tipo: Tipo,
            transacaoList : MutableList<Transacao>) {
        with(viewCriada) {

            val titulo = this!!.form_transacao_titulo.text.toString()
            val Valor = form_transacao_valor.text.toString()
            val dataTexto = form_transacao_data.text.toString()
            val categoria = form_transacao_categoria.selectedItem.toString()

            val simpleDateFormatBR = SimpleDateFormat("dd/MM/yyyy")
            val dataBr = simpleDateFormatBR.parse(dataTexto)
            val data = Calendar.getInstance()
            data.time = dataBr
            val transact = Transacao(valor = BigDecimal(Valor), titulo = titulo, data = data, categoria = categoria, tipo = tipo)

            transacaoList.add(transact)

        }
    }
    fun updateTransacao(viewCriada: View?, transacao: Transacao) {
        with(viewCriada) {

        }
    }
}