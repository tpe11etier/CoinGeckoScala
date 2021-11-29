package com.trp.coingecko.model.coins

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class MarketIndex(
                        name: String,
                        id: String,
                        market: String,
                        last: Double,
                        is_multi_asset_composite: Boolean
                      )

object MarketIndex {
  implicit val readsMarketIndex: ReadWriter[MarketIndex] = macroRW[MarketIndex]
}