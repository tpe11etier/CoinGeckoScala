package com.trp.coingecko

import com.trp.coingecko.client.CoinGeckoClientImpl

object Tester extends App {
  val client = new CoinGeckoClientImpl(new CoinGeckoAPI())
  //  println(client.ping)
  //  println(client.getPrice(List("bitcoin"), List("eth", "usd")))
  //  println(client.getPrice(List("bitcoin"), List("usd"), includeMarketCap = true, include24hrVol = true, include24hrChange = true, includeLastUpdateAt = false))
  //  println(client.getSupportedVsCurrencies)
  //  println(client.getCoinMarkets("usd"))
  //  println(client.getCoinsList(false))
//    println(client.getExchanges)
  //  println(client.getCoinStatusUpdates("cardano", Some(2), Some(2)))
  //  println(client.getCoinTickerById("bitcoin"))
  //  println(client.getCoinMarketChartById("bitcoin", "usd", 1))
  //  println(client.getCoinMarketChartByRange("bitcoin", "usd", 1615217740, 1615304140))
  //  println(client.getTokenPrice("ethereum", "0xa0b86991c6218b36c1d19d4a2e9eb0ce3606eb48", List("usd"),true,true,true,true))
  //  println(client.getCoinHistoryById("bitcoin", "15-03-2021"))
  //  println(client.getCoinOHLC("bitcoin", "usd", 1))
  //  println(client.getFinancePlatforms)
//    println(client.getExchangesList)
    println(client.getExchangeById("vitex"))
  //  println(client.getExchangeTickersById("vitex"))
  //  println(client.getExchangeStatusUpdatesById("binance"))
//  println(client.getExchangeVolumeChart("binance", 11))
//  println(client.getMarketIndexList)

}

