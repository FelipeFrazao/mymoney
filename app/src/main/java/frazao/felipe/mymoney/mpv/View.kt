package frazao.felipe.mymoney.mpv

import android.app.DatePickerDialog
import android.content.Context
import android.view.View
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Tipo
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.util.*

/**
 * Created by felipefrazao on 22/12/2017.
 */
class View {

    val presenter : Presenter = Presenter()

    fun abreDialog(view: View, context: Context) {


        with(view) {
            configuraData(context)

        }
    }
    fun alteraDialog(view: View, context: Context) {

        with(view) {
            configuraData(context)
        }
    }

    fun View.configuraData(context: Context) {

        val hoje = Calendar.getInstance()
        val dia = hoje.get(Calendar.DAY_OF_MONTH)
        val mes = hoje.get(Calendar.MONTH)
        val ano = hoje.get(Calendar.YEAR)
        form_transacao_data.setText(hoje.formataParaBR())

        form_transacao_data.setOnClickListener {
            DatePickerDialog(context,
                    DatePickerDialog.OnDateSetListener { view, ano, mes, dia ->
                        val dataSelecionada = Calendar.getInstance()
                        dataSelecionada.set(ano, mes, dia)
                        form_transacao_data.setText(dataSelecionada.formataParaBR())
                    }, ano, mes, dia).show()
        }
    }
    fun categoriasPor(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) {
            return R.array.categorias_de_receita
        }
        return R.array.categorias_de_despesa
    }
}