package com.trp.coingecko.model.coins

import upickle.default._

case class MarketChart(
                        prices: List[List[Long]],
                        market_caps: List[List[Long]],
                        total_volumes: List[List[Long]]
                      )

object MarketChart {
  implicit val readsMarketChart: ReadWriter[MarketChart] = macroRW[MarketChart]
}
