package frazao.felipe.mymoney.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.model.Transacao
import frazao.felipe.mymoney.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

/**
 * Created by felipefrazao on 13/12/2017.
 */
class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoesList = listOf(
                Transacao("Fone Xiaomi",
                        BigDecimal(73.5),
                        "Despesa",
                        Calendar.getInstance()
                ),
                Transacao("CMS do Danilo",
                        BigDecimal(800.00),
                        "Pagamento",
                        Calendar.getInstance()
                ),
                Transacao("Celular",
                        BigDecimal(550.00),
                        "Despesa",
                        Calendar.getInstance()
                ))

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoesList, this))
    }
}