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
                     trust_score: Int,
                     trust_score_rank: Int,
                     trade_volume_24h_btc: Double,
                     trade_volume_24h_btc_normalized: Double,
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
                     tickers: Option[List[Tickers]] = None
                   )
  name: String,
  year_established: Int,
  country: String,
  description: String,
  url: String,
  image: String,
  facebook_url: String,
  reddit_url: String,
  telegram_url: String,
  slack_url: String,
  other_url_1: String,
  other_url_2: String,
  twitter_handle: String,
  has_trading_incentive: Boolean,
  centralized: Boolean,
  public_notice: String,
  alert_notice: String,
  trust_score: Int,
  trust_score_rank: Int,
  trade_volume_24h_btc: Double,
  trade_volume_24h_btc_normalized: Double,
  tickers: Seq[Tickers],
  status_updates: Seq[StatusUpdates]

object Exchange {
  implicit val readExchange: Reader[Exchange] = macroRW[Exchange]
}

