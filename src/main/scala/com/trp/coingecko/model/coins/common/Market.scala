package com.trp.coingecko.model.coins.common

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class Market(
                   name: String,
                   identifier: String,
                   has_trading_incentive: Boolean
                 )

object Market {
  implicit val readsMarket: ReadWriter[Market] = macroRW[Market]
}