package com.trp.coingecko.model.exchanges

import com.trp.coingecko.model.coins.common.Tickers
//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class Exchange(
                     id: Option[String] = None,
                     name: Option[String] = None,
                     year_established: Option[Int] = None,
                     country: Option[String] = None,
                     description: Option[String] = None,
                     url: Option[String] = None,
                     image: Option[String] = None,
                     has_trading_incentive: Option[Boolean] = None,
                     trade_volume_24h_btc: Option[Double] = None,
                     facebook_url: Option[String] = None,
                     reddit_url: Option[String] = None,
                     telegram_url: Option[String] = None,
                     slack_url: Option[String] = None,
                     other_url_1: Option[String] = None,
                     other_url_2: Option[String] = None,
                     twitter_handle: Option[String] = None,
                     centralized: Option[Boolean] = None,
                     public_notice: Option[String] = None,
                     alert_notice: Option[String] = None,
                     trust_score: Option[Int] = None,
                     trust_score_rank: Option[Int] = None,
                     trade_volume_24h_btc_normalized: Option[Double] = None,
                     tickers: List[Tickers] = List.empty
                   )


object Exchange {
  implicit val readExchange: ReadWriter[Exchange] = macroRW[Exchange]
}



