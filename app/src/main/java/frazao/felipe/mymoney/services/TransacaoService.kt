package frazao.felipe.mymoney.services

import frazao.felipe.mymoney.model.Transacao
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by felipefrazao on 29/12/2017.
 */
interface TransacaoService {
    @GET("transacoes")
    fun listTransacoes() : Call<List<Transacao>>
}