package frazao.felipe.mymoney.mpv

import android.app.DatePickerDialog
import android.content.Context
import android.view.View
import frazao.felipe.mymoney.extension.formataParaBR
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.util.*

/**
 * Created by felipefrazao on 22/12/2017.
 */
class View {
     fun abreDialog(view: View, context: Context) {

        val hoje = Calendar.getInstance()
        val dia = hoje.get(Calendar.DAY_OF_MONTH)
        val mes = hoje.get(Calendar.MONTH)
        val ano = hoje.get(Calendar.YEAR)

        with(view) {
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
    }
}