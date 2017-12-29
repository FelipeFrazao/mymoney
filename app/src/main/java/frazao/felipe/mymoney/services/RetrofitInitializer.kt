package frazao.felipe.mymoney.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by felipefrazao on 29/12/2017.
 */
class  RetrofitInitializer {


    private val retrofit = Retrofit.Builder()
            .baseUrl("http://demo5858539.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun transacaoService (): TransacaoService = retrofit.create(TransacaoService::class.java)
}