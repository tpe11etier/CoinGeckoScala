package com.trp.coingecko.model.coins.common

import com.trp.coingecko.utils.JSONPickler._

case class Market(
                   name: String,
                   identifier: String,
                   has_trading_incentive: Boolean
                 )

object Market {
  implicit val readsMarket: ReadWriter[Market] = macroRW[Market]
}