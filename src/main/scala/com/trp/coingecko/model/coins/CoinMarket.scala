package com.trp.coingecko.model.coins

import java.util.Date
import upickle.default._
import com.trp.coingecko.model.coins.data.Roi

case class CoinMarket(
                       id: String,
                       symbol: String,
                       name: String,
                       image: String,
                       current_price: Double,
                       market_cap: Long,
                       market_cap_rank: Long,
                       fully_diluted_valuation: Long,
                       total_volume: Long,
                       high_24h: Double,
                       low_24h: Double,
                       price_change_24h: Double,
                       price_change_percentage_24h: Double,
                       market_cap_change_24h: Double,
                       market_cap_change_percentage_24h: Double,
                       circulating_supply: Long,
                       total_supply: Long,
                       max_supply: Long,
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
