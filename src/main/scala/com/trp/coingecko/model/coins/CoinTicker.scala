package com.trp.coingecko.model.coins

import com.trp.coingecko.model.coins.common.Tickers
//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class CoinTicker(
                       name: String,
                       tickers: List[Tickers]
                     )



object CoinTicker {
  implicit val readsCoinTicker: ReadWriter[CoinTicker] = macroRW[CoinTicker]
}