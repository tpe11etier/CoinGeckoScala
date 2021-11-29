package com.trp.coingecko.model.coins.data

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class MarketData(
                       current_price: Map[String, Double],
                       market_cap: Map[String, Double],
                       total_volume: Map[String, Double],
                     )

object MarketData {
  implicit val readsMarketData: ReadWriter[MarketData] = macroRW[MarketData]
}



