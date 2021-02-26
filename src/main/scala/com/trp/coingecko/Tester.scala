package com.trp.coingecko

object Tester extends App {
  val cg = new CoinGeckoAPI()
  println(cg.get("ping"))
}
