package com.trp.coingecko.model.exchanges

import com.trp.coingecko.model.coins.common.Tickers
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
                     trade_volume_24h_btc: Double,
                     facebook_url: Option[String] = Some("None"),
                     reddit_url: Option[String] = None,
                     telegram_url: Option[String] = None,
                     slack_url: Option[String] = None,
                     other_url_1: Option[String] = None,
                     other_url_2: Option[String] = None,
                     twitter_handle: Option[String] = None,
                     centralized: Boolean = false,
                     public_notice: Option[String] = None,
                     alert_notice: Option[String] = None,
                     trust_score: Int,
                     trust_score_rank: Int,
                     trade_volume_24h_btc_normalized: Double,
                     tickers: List[Tickers] = List.empty
                   )


object Exchange {
  implicit val readExchange: ReadWriter[Exchange] = macroRW[Exchange]

}



