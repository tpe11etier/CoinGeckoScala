package com.trp.coingecko.model.coins

import cats.syntax.OptionOps

import java.util.Date
//import upickle.default._
import com.trp.coingecko.model.coins.data.Roi
import com.trp.coingecko.utils.OptionPickler._

case class CoinMarket(
                       id: String,
                       symbol: String,
                       name: String,
                       image: String,
                       current_price: Double,
                       market_cap: Option[Long] = Some(1),
                       market_cap_rank: Option[Long] = Some(1),
                       fully_diluted_valuation: Option[Long] = Some(1),
                       total_volume: Option[Long] = Some(1),
                       high_24h: Double,
                       low_24h: Double,
                       price_change_24h: Double,
                       price_change_percentage_24h: Double,
                       market_cap_change_24h: Double,
                       market_cap_change_percentage_24h: Double,
                       circulating_supply: Option[Long] = Some(1),
                       total_supply: Option[Long] = Some(1),
                       max_supply: Option[Long] = Some(1),
                       ath: Double,
                       ath_change_percentage: Double,
                       ath_date: String,
                       atl: Double,
                       atl_change_percentage: Double,
                       atl_date: String,
                       roi: Roi,
                       last_updated: String
                     )

object CoinMarket {
  implicit val coinMarketReads: ReadWriter[CoinMarket] = macroRW[CoinMarket]
}
