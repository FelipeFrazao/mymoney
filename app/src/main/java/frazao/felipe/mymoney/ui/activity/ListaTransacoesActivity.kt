package frazao.felipe.mymoney.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import frazao.felipe.mymoney.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.resumo_card.*
import java.math.BigDecimal

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
            Transacao(titulo = "Celular",
                    valor = BigDecimal(550.00),
                    tipo = Tipo.DESPESA
            ))


    var totalReceita = BigDecimal.ZERO
    var totalDespesa = BigDecimal.ZERO

    private fun adicionaReceita() {
        for (transacao in transacoesList) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor)
            }
        }
        resumo_card_receita.text = totalReceita.formataParaBR()
    }
    private fun adicionarDespesa() {
        for (transacao in transacoesList) {
            if (transacao.tipo == Tipo.DESPESA) {
                totalDespesa = totalDespesa.plus(transacao.valor)
            }
        }
        resumo_card_despesa.text = totalDespesa.formataParaBR()
    }
    private fun totalFinancas() {
        var total = totalReceita - totalDespesa
        resumo_card_total.text = total.formataParaBR()
    }
    private fun configuraLista() {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoesList, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        adicionaReceita()
        adicionarDespesa()
        totalFinancas()

        // configurando o adapter
        configuraLista()
    }

}