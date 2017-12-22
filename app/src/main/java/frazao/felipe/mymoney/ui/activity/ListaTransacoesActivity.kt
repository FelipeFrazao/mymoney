package frazao.felipe.mymoney.ui.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import frazao.felipe.mymoney.mpv.*
import frazao.felipe.mymoney.ui.ResumoView
import frazao.felipe.mymoney.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal

/**
 * Created by felipefrazao on 13/12/2017.
 */
class ListaTransacoesActivity : AppCompatActivity() {

    private val presenter = Presenter()
    private val view = View()

    // Inserindo itens na lista
    var transacoesList: MutableList<Transacao> = mutableListOf(
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
            )
    ).toMutableList()

    private fun configuraLista() {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoesList, this)
        ListaTransacoesAdapter(transacoesList, this).notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        configuraResumo()
        // configurando o adapter
        configuraLista()

        lista_transacoes_adiciona_receita.setOnClickListener {
            abreDialog(R.string.adiciona_receita, R.array.categorias_de_receita, Tipo.RECEITA)
        }
        lista_transacoes_adiciona_despesa.setOnClickListener {
            abreDialog(R.string.adiciona_despesa, R.array.categorias_de_despesa, Tipo.DESPESA)
        }
    }

    private fun abreDialog(title: Int, category: Int, tipo: Tipo) {
        val viewDecorada: View = window.decorView
        val viewCriada = LayoutInflater.from(this).inflate(R.layout.form_transacao, viewDecorada as ViewGroup, false)
        view.abreDialog(viewCriada, this)

        with (viewCriada) {

            val adapter = ArrayAdapter.createFromResource(this@ListaTransacoesActivity, category, android.R.layout.simple_spinner_dropdown_item)

            form_transacao_categoria.adapter = adapter

            AlertDialog.Builder(this@ListaTransacoesActivity)
                    .setTitle(title)
                    .setView(viewCriada)
                    .setNegativeButton("Cancelar", null)
                    .setPositiveButton("Adicionar", { dialogInterface, i ->
                        addtransacoes(viewCriada, tipo)
                    }
                    )
                    .show()
        }
    }

    private fun addtransacoes(viewCriada: View?, type: Tipo) {

        with(viewCriada) {
            try {
                var tipo = type.toString().toLowerCase()

                presenter.addTransact(this@ListaTransacoesActivity, viewCriada, type, transacoesList)
                lista_transacoes_adiciona_menu.close(true)
                configuraLista()
                configuraResumo()
                Toast.makeText(this@ListaTransacoesActivity, "A sua foi ${tipo} adicionada", Toast.LENGTH_LONG).show()
            } catch (ex: Exception) {
                Toast.makeText(this@ListaTransacoesActivity, "Por favor insira valores validos", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun configuraResumo() {
        val view: View = window.decorView
        val resumoView = ResumoView(view, transacoesList, this)
        resumoView.atualiza()
    }
}