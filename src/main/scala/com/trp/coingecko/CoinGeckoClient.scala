package com.trp.coingecko

import com.trp.coingecko.model.coins.{BaseCoin, CoinMarket, CoinTicker}
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

  def getExchanges: List[Exchange]

  def getCoinStatusUpdates(id: String): StatusUpdates

  def getCoinStatusUpdates(id: String, page: Option[Int], perPage: Option[Int]): StatusUpdates

  def getCoinTickers(id: String): CoinTicker

  def getCoinTickers(
                      id: String,
                      exchangeIds: List[String],
                      includeExchangeLogo: Boolean,
                      page: Option[Int],
                      order: Option[String],
                      depth: Option[String]
                    ): CoinTicker


}
