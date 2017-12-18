package frazao.felipe.mymoney.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import frazao.felipe.mymoney.ui.ResumoView
import frazao.felipe.mymoney.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.math.BigDecimal
import java.util.*

/**
 * Created by felipefrazao on 13/12/2017.
 */
class ListaTransacoesActivity : AppCompatActivity() {

    // Inserindo itens na lista
    val transacoesList = listOf(
            Transacao(titulo = "Fone Xiaomi",
                    valor =  BigDecimal(73.5),
                    categoria = "Compra",
                    tipo = Tipo.DESPESA
            ),
            Transacao("CMS do Danilo",
                    BigDecimal(800.00),
                    Tipo.RECEITA,
                    "Pagamento"
            ),
            Transacao("Holly Chuck Burger",
                    BigDecimal(130.00),
                    Tipo.DESPESA,
                    "Comida"
            ),
            Transacao("Holly Chuck Burger",
                    BigDecimal(46.50),
                    Tipo.DESPESA,
                    "Comida"
            ),
            Transacao(titulo = "Celular",
                    valor = BigDecimal(550.00),
                    tipo = Tipo.DESPESA
            ))

    private fun configuraLista() {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoesList, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val view: View = window.decorView
        val resumoView = ResumoView(view, transacoesList, this)
        resumoView.adicionaReceitaNoResumo()
        resumoView.adicionarDespesaNoResumo()
        resumoView.totalFinancas()

        // configurando o adapter
        configuraLista()
    }

}