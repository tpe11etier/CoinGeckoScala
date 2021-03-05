package com.trp.coingecko.model.coins

import com.trp.coingecko.model.coins.common.Ticker
import upickle.default._

case class CoinTicker(
                       name: String,
                       tickers: List[Ticker]
                     )



object CoinTicker {
  implicit val readsCoinTicker: ReadWriter[CoinTicker] = macroRW[CoinTicker]
}