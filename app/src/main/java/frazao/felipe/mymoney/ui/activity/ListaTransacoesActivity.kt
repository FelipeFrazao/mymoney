package frazao.felipe.mymoney.ui.activity

import android.app.DatePickerDialog
import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import frazao.felipe.mymoney.R
import frazao.felipe.mymoney.extension.formataParaBR
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import frazao.felipe.mymoney.ui.ResumoView
import frazao.felipe.mymoney.ui.adapter.ListaTransacoesAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by felipefrazao on 13/12/2017.
 */
class ListaTransacoesActivity : AppCompatActivity() {

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
        val dia = 18
        val mes = 11
        val ano = 2017
        val view: View = window.decorView
        val viewCriada = LayoutInflater.from(this).inflate(R.layout.form_transacao, view as ViewGroup, false)
        val hoje = Calendar.getInstance()
        with (viewCriada) {
            form_transacao_data.setText(hoje.formataParaBR())
            form_transacao_data.setOnClickListener{
                DatePickerDialog(this@ListaTransacoesActivity,
                        DatePickerDialog.OnDateSetListener { view, ano, mes, dia ->
                            val dataSelecionada = Calendar.getInstance()
                            dataSelecionada.set(ano, mes, dia)
                            form_transacao_data.setText(dataSelecionada.formataParaBR())
                        }, ano, mes, dia).show()
            }
            val adapter = ArrayAdapter.createFromResource(this@ListaTransacoesActivity, category, android.R.layout.simple_spinner_dropdown_item)

            form_transacao_categoria.adapter = adapter

            AlertDialog.Builder(this@ListaTransacoesActivity)
                    .setTitle(title)
                    .setView(viewCriada)
                    .setNegativeButton("Cancelar", null)
                    .setPositiveButton("Adicionar", { dialogInterface, i ->
                        with (viewCriada) {
                            val titulo = form_transacao_titulo.text.toString()
                            val Valor = form_transacao_valor.text.toString()
                            val dataTexto = form_transacao_data.text.toString()
                            val categoria = form_transacao_categoria.selectedItem.toString()

                            val simpleDateFormatBR = SimpleDateFormat("dd/MM/yyyy")
                            val dataBr = simpleDateFormatBR.parse(dataTexto)
                            val data = Calendar.getInstance()
                            data.time = dataBr

                            val transacao = Transacao(valor = BigDecimal(Valor), titulo = titulo, data = data, categoria = categoria, tipo = tipo)
                            transacoesList.add(transacao)
                            configuraLista()
                            configuraResumo()
                            var tipo = tipo.toString().toLowerCase()
                            lista_transacoes_adiciona_menu.close(true)
                            Toast.makeText(this@ListaTransacoesActivity,"A sua foi ${tipo} adicionada" ,Toast.LENGTH_LONG).show()
                        }
                    }
                    )
                    .show()
        }
    }

    private fun configuraResumo() {
        val view: View = window.decorView
        val resumoView = ResumoView(view, transacoesList, this@ListaTransacoesActivity)
        resumoView.atualiza()
    }
}