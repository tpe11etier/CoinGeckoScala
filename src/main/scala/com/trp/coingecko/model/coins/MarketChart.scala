package com.trp.coingecko.model.coins

import upickle.default._



case class MarketChart(
                        prices: List[List[Int]],
                        market_caps: List[List[Int]],
                        total_volumes: List[List[Int]]
                      )

object MarketChart {
  implicit val readsMarketChart: ReadWriter[MarketChart] = macroRW[MarketChart]
}
