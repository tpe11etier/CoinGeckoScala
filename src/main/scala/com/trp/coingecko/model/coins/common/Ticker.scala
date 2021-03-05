package com.trp.coingecko.model.coins.common

import upickle.default._

case class Ticker(
                   base: String,
                   target: String,
                   market: Market,
                   last: Double,
                   volume: Double,
                   converted_last: Map[String, Int],
                   converted_volume: Map[String, Int],
                   trust_score: String,
                   bid_ask_spread_percentage: Double,
                   timestamp: String,
                   last_traded_at: String,
                   last_fetch_at: String,
                   is_anomaly: Boolean,
                   is_stale: Boolean,
                   trade_url: String,
                   token_info_url: String,
                   coin_id: String
                 )

object Ticker {
  implicit val readsTicker: ReadWriter[Ticker] = macroRW[Ticker]
}