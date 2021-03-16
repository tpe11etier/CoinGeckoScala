package com.trp.coingecko

import com.trp.coingecko.model.coins.{BaseCoin, CoinHistory, CoinMarket, CoinTicker, MarketChart}
import com.trp.coingecko.model.coins.CoinPrice.CoinWithCurrencies
import com.trp.coingecko.model.coins.status.{Status, StatusUpdates}
import com.trp.coingecko.model.exchanges.Exchange
import com.trp.coingecko.model.response.PingResponse
import requests.Response
import sun.security.krb5.internal.Ticket

trait CoinGeckoClient {
  def ping: PingResponse

  def getPrice(
                ids: List[String],
                vsCurrencies: List[String],
              ): CoinWithCurrencies

  def getPrice(
                ids: List[String],
                vsCurrencies: List[String],
                includeMarketCap: Boolean,
                include24hrVol: Boolean,
                include24hrChange: Boolean,
                includeLastUpdateAt: Boolean
              ): CoinWithCurrencies

  def getTokenPrice(
                     id: String,
                     contractAddress: String,
                     vsCurrencies: List[String],
                   ): CoinWithCurrencies

  def getTokenPrice(
                     id: String,
                     contractAddress: String,
                     vsCurrencies: List[String],
                     includeMarketCap: Boolean,
                     include24hrVol: Boolean,
                     include24hrChange: Boolean,
                     includeLastUpdateAt: Boolean
                   ): CoinWithCurrencies

  def getSupportedVsCurrencies: List[String]

  def getCoinsList(
                    includePlatform: Boolean
                  ): List[BaseCoin]


  def getCoinMarkets(vsCurrency: String): List[CoinMarket]

  def getCoinMarkets(
                      vsCurrency: String,
                      ids: List[String],
                      order: Option[String],
                      perPage: Option[Int],
                      page: Option[Int],
                      sparkline: Option[Boolean],
                      priceChangePercentage: Option[String]
                    ): List[CoinMarket]

  def getCoinsById(id: String)

  def getCoinsById(
                    id: String,
                    localization: String,
                    tickers: Boolean,
                    market_data: Boolean,
                    community_data: Boolean,
                    developer_data: Boolean,
                    sparkline: Boolean
                  )

  def getCoinTickerById(id: String): CoinTicker

  def getCoinTickerById(
                         id: String,
                         exchangeIds: List[String],
                         page: Option[Int],
                         order: Option[String],
                         depth: Option[String]
                       ): CoinTicker

  def getCoinHistoryById(
      id: String,
      date: String
//      localization: String
  ): CoinHistory

  def getCoinMarketChartById(
                              id: String,
                              vsCurrency: String,
                              days: Int
                            ): MarketChart

  def getCoinMarketChartByRange(
                                 id: String,
                                 vsCurrency: String,
                                 from: Long,
                                 to: Long
                               ): MarketChart


  def getCoinStatusUpdates(id: String): StatusUpdates

  def getCoinStatusUpdates(id: String, page: Option[Int], perPage: Option[Int]): StatusUpdates


  def getExchanges: List[Exchange]


}
