package com.trp.coingecko.model.coins

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._
import com.trp.coingecko.model.coins.common.Image
import com.trp.coingecko.model.coins.data.{CommunityData, DeveloperData, MarketData, PublicInterestStats}

case class CoinHistory(
  id: String,
  symbol: String,
  name: String,
  localization: Map[String, String],
  image: Image,
  market_data: MarketData,
  community_data: CommunityData,
  developer_data: DeveloperData,
  public_interest_stats: PublicInterestStats
)

object CoinHistory {
  implicit val readsCoinHistory: ReadWriter[CoinHistory] = macroRW[CoinHistory]
}