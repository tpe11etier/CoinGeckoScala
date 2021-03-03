package com.trp.coingecko.model.exchanges

import upickle.default._

case class Exchange(
                     id: String,
                     name: String,
                     year_established: Int,
                     country: String,
                     description: String,
                     url: String,
                     image: String,
                     has_trading_incentive: Boolean,
                     trust_score: Option[Int],
                     trust_score_rank: Option[Int],
                     trade_volume_24h_btc: Double,
                     trade_volume_24h_btc_normalized: Option[Double]
                   )

object Exchange {
  implicit val readExchange: Reader[Exchange] = macroRW[Exchange]
}