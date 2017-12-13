package frazao.felipe.mymoney.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import frazao.felipe.mymoney.R
import kotlinx.android.synthetic.main.activity_lista_transacoes.*

/**
 * Created by felipefrazao on 13/12/2017.
 */
class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoesList = listOf("Comida - R$ 34,49", "Economia - R$ 300,00")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, transacoesList)

        lista_transacoes_listview.setAdapter(arrayAdapter)
    }

}