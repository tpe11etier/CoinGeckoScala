package com.trp.coingecko.client

import com.trp.coingecko.model.coins.{BaseCoin, CoinMarket}
import com.trp.coingecko.model.coins.CoinPrice.CoinWithCurrencies
import com.trp.coingecko.model.exchanges.Exchange
import com.trp.coingecko.model.response.PingResponse
import com.trp.coingecko.{CoinGeckoAPI, CoinGeckoAPIError, CoinGeckoClient}
import upickle.default._


class CoinGeckoClientImpl(api: CoinGeckoAPI) extends CoinGeckoClient {
  override def ping: PingResponse =
    get[PingResponse](endpoint = "ping", Map())


  def get[T: Reader](endpoint: String, params: Map[String, String]): T =
    api.get(endpoint, params) match {
      case json => read[T](json)
    }

  override def getPrice(
                         ids: List[String],
                         vsCurrencies: List[String]
                       ): CoinWithCurrencies =
    getPrice(
      ids,
      vsCurrencies,
      includeMarketCap = false,
      include24hrVol = false,
      include24hrChange = false,
      includeLastUpdateAt = false
    )

  override def getPrice(
                         ids: List[String],
                         vsCurrencies: List[String],
                         includeMarketCap: Boolean,
                         include24hrVol: Boolean,
                         include24hrChange: Boolean,
                         includeLastUpdateAt: Boolean
                       ): CoinWithCurrencies = {
    def buildQuery: Map[String, String] =
      Map(
        "ids" -> ids.mkString(","),
        "vs_currencies" -> vsCurrencies.mkString(","),
        "include_market_cap" -> includeMarketCap,
        "include_24hr_vol" -> include24hrVol,
        "include_24hr_change" -> include24hrChange,
        "include_last_updated_at" -> includeLastUpdateAt
      ).map(kv => (kv._1, kv._2.toString))

    get[CoinWithCurrencies](endpoint = "simple/price", buildQuery)

  }


  override def getSupportedVsCurrencies: List[String] =
    get[List[String]]("simple/supported_vs_currencies", params = Map())

  override def getCoinsList(includePlatform: Boolean): List[BaseCoin] = {
    get[List[BaseCoin]](endpoint = "coins/list", Map())
  }

  override def getCoinMarkets(
                               vsCurrency: String
                             ): List[CoinMarket] =
    getCoinMarkets(
      vsCurrency,
      ids = List.empty,
      order = None,
      perPage = None,
      page = None,
      sparkline = None,
      priceChangePercentage = None
    )

  override def getCoinMarkets(
                               vsCurrency: String,
                               ids: List[String],
                               order: Option[String],
                               perPage: Option[Int],
                               page: Option[Int],
                               sparkline: Option[Boolean],
                               priceChangePercentage: Option[String]
                             ): List[CoinMarket] = {
    def buildQuery: Map[String, String] =
      Map(
        "vs_currency" -> Some(vsCurrency),
        "ids" -> ids.reduceLeftOption((left, right) => s"$left,$right"),
        "order" -> order,
        "per_page" -> perPage.map(_.toString),
        "page" -> page.map(_.toString),
        "sparkline" -> sparkline.map(_.toString),
        "price_change_percentage" -> priceChangePercentage
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    println(buildQuery)
    get[List[CoinMarket]](endpoint = "coins/markets", buildQuery)
  }

  override def getExchanges: List[Exchange] =
    get[List[Exchange]](endpoint = "exchanges", Map())
}


