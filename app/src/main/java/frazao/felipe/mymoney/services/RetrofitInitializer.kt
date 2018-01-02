package frazao.felipe.mymoney.services

import frazao.felipe.mymoney.model.Transacao
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import  rx.Observable
import okhttp3.OkHttpClient

/**
 * Created by felipefrazao on 29/12/2017.
 */
class  RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://demo5858539.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val transacaoService get() = retrofit.create(TransacaoService::class.java)

}