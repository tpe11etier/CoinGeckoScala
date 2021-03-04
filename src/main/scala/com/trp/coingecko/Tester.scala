package com.trp.coingecko

import com.trp.coingecko.client.CoinGeckoClientImpl

object Tester extends App {
  val client = new CoinGeckoClientImpl(new CoinGeckoAPI())
  println(client.ping)
//  println(client.getPrice(List("bitcoin"), List("eth", "usd")))
//  println(client.getPrice(List("bitcoin"), List("usd"), includeMarketCap = true, include24hrVol = true, include24hrChange = true, includeLastUpdateAt = false))
//  println(client.getSupportedVsCurrencies)
//  println(client.getCoinMarkets("usd"))
//  println(client.getCoinsList(false))
//  println(client.getExchanges)
  println(client.getCoinStatusUpdates("cardano"))
}