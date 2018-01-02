package frazao.felipe.mymoney.mpv

import android.util.Log
import frazao.felipe.mymoney.model.Tipo
import frazao.felipe.mymoney.model.Transacao
import frazao.felipe.mymoney.services.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.math.BigDecimal

/**
 * Created by felipefrazao on 21/12/2017.
 */
class TransacaoDAO {


    var transacoesList: List<Transacao> = Companion.transacoesList

    // Lista de transacoes
    companion object {
        private val transacoesList: MutableList<Transacao> = mutableListOf(
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
                )
        ).toMutableList()
    }

    fun getTransacoes() {
        val call = RetrofitInitializer().transacaoService.listTransacoes()


        call.enqueue(object : Callback<List<Transacao>> {
            override fun onResponse(call: Call<List<Transacao>>?, response: Response<List<Transacao>>?) {
                response?.let {
                    transacoesList = it.body()!!
                    Log.e("DEUCERTO", "Tamanho ${transacoesList.size}")

                }
            }

            override fun onFailure(call: Call<List<Transacao>>?, t: Throwable?) {
                Log.e("Faiô", t?.message)
            }

        } )
    }
    fun addTransacao (transacao: Transacao) {

        Companion.transacoesList.add(transacao)
    }

    fun updateTransacao (transacao: Transacao, indexOf: Int) {

        Companion.transacoesList.set(indexOf, transacao)
    }

    fun removeTransacao (indexOf: Int) {

        Companion.transacoesList.removeAt(indexOf)
    }
}