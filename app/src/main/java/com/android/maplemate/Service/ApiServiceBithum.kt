package com.android.maplemate.Service

import com.android.maplemate.Data.Ticker
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceBithum {
    @GET("public/ticker/{order_currency}_{payment_currency}")
    fun getCoinTicker(
        @Path("order_currency") orderCurrency: String,
        @Path("payment_currency") paymentCurrency: String

    ): Call<Ticker>
}