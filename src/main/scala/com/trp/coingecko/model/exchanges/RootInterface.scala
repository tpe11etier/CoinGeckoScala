package com.trp.coingecko.model.exchanges

import com.trp.coingecko.model.coins.common.Ticker
import upickle.default._

case class RootInterface (
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
  tickers: Seq[Ticker],
  status_updates: Seq[String]
)

object RootInterface {
  implicit val readsRootInterface: ReadWriter[RootInterface] = macroRW[RootInterface]
}