package com.trp.coingecko.client

import com.trp.coingecko.model.coins.{BaseCoin, CoinHistory, CoinMarket, CoinTicker, MarketChart}
import com.trp.coingecko.model.coins.CoinPrice.CoinWithCurrencies
import com.trp.coingecko.model.coins.status.{Status, StatusUpdates}
import com.trp.coingecko.model.exchanges.{BaseExchange, Exchange, RootInterface, VolumeChart}
import com.trp.coingecko.model.finance.Platform
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


  /*
    Simple API Requests Start
  */
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

  override def getTokenPrice(
                              id: String,
                              contractAddresses: String,
                              vsCurrencies: List[String]
                            ): CoinWithCurrencies =
    getTokenPrice(
      id,
      contractAddresses,
      vsCurrencies,
      includeMarketCap = false,
      include24hrVol = false,
      include24hrChange = false,
      includeLastUpdateAt = false
    )

  override def getTokenPrice(
                              id: String,
                              contractAddress: String,
                              vsCurrencies: List[String],
                              includeMarketCap: Boolean,
                              include24hrVol: Boolean,
                              include24hrChange: Boolean,
                              includeLastUpdateAt: Boolean
                            ): CoinWithCurrencies = {
    def buildQuery: Map[String, String] =
      Map(
        "contract_addresses" -> contractAddress,
        "vs_currencies" -> vsCurrencies.mkString(","),
        "include_market_cap" -> includeMarketCap,
        "include_24hr_vol" -> include24hrVol,
        "include_24hr_change" -> include24hrChange,
        "include_last_updated_at" -> includeLastUpdateAt
      ).map(kv => (kv._1, kv._2.toString))

    get[CoinWithCurrencies](endpoint = s"simple/token_price/$id", buildQuery)

  }

  override def getSupportedVsCurrencies: List[String] =
    get[List[String]]("simple/supported_vs_currencies", params = Map())

  /*
    Simple API Requests End
  */

  /* ============================================================================= */

  /*
   Coins API Requests Start
  */

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

    get[List[CoinMarket]](endpoint = "coins/markets", buildQuery)
  }


  override def getCoinsById(id: String): Unit = ???

  override def getCoinsById(id: String, localization: String, tickers: Boolean, market_data: Boolean, community_data: Boolean, developer_data: Boolean, sparkline: Boolean): Unit = ???

  override def getCoinTickerById(id: String): CoinTicker = {
    getCoinTickerById(id, exchangeIds = List.empty, page = None, order = None, depth = None)
  }

  override def getCoinTickerById(
                                  id: String,
                                  exchangeIds: List[String],
                                  page: Option[Int],
                                  order: Option[String],
                                  depth: Option[String]): CoinTicker = {
    def buildQuery: Map[String, String] =
      Map(
        "exchange_ids" -> exchangeIds.reduceLeftOption((left, right) => s"$left,$right")
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[CoinTicker](endpoint = s"coins/$id/tickers", buildQuery)
  }


  override def getCoinHistoryById(id: String, date: String): CoinHistory = {
    def buildQuery =
      Map(
        "date" -> date
        //        "localization" -> localization
      )

    get[CoinHistory](endpoint = s"coins/${id}/history", buildQuery)
  }

  override def getCoinMarketChartById(id: String, vsCurrency: String, days: Int): MarketChart = {
    def buildQuery =
      Map(
        "vs_currency" -> vsCurrency,
        "days" -> days.toString
      )

    get[MarketChart](endpoint = s"coins/${id}/market_chart", buildQuery)

  }

  override def getCoinMarketChartByRange(id: String, vsCurrency: String, from: Long, to: Long): MarketChart = {
    def buildQuery =
      Map(
        "vs_currency" -> vsCurrency,
        "from" -> from.toString,
        "to" -> to.toString
      )

    get[MarketChart](endpoint = s"coins/${id}/market_chart/range", buildQuery)

  }

  override def getCoinStatusUpdates(id: String): StatusUpdates = {
    get[StatusUpdates](endpoint = s"coins/${id}/status_updates", Map())
  }

  override def getCoinStatusUpdates(id: String, page: Option[Int], perPage: Option[Int]): StatusUpdates = {
    def buildQuery: Map[String, String] =
      Map(
        "per_page" -> perPage.map(_.toString),
        "page" -> page.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[StatusUpdates](endpoint = s"coins/${id}/status_updates", buildQuery)
  }

  override def getCoinOHLC(id: String, vs_currency: String, days: Int): List[List[Long]] = {
    def buildQuery =
      Map(
        "vs_currency" -> vs_currency,
        "days" -> days.toString
      )

    get[List[List[Long]]](endpoint = s"coins/${id}/ohlc", buildQuery)
  }


  /*
    Coins API Requests End
  */

  /* ============================================================================= */

  /*
    Finance API Requests Start
  */

  override def getFinancePlatforms: List[Platform] = {
    getFinancePlatforms(perPage = None, page = None)
  }

  override def getFinancePlatforms(perPage: Option[Int], page: Option[String]): List[Platform] = {
    def buildQuery =
      Map(
        "per_page" -> perPage.toString,
        "page" -> page.toString
      )

    get[List[Platform]](endpoint = s"finance_platforms", buildQuery)
  }


  /*
    Finance API Requests End
  */

  /*
    Exchange API Requests Start
  */

  override def getExchanges: List[Exchange] =
    get[List[Exchange]](endpoint = "exchanges", Map())

  override def getExchangesList: List[BaseExchange] = {
    get[List[BaseExchange]](endpoint = "exchanges/list", Map())

  }

  override def getExchangeById(id: String): RootInterface = {
    get[RootInterface](endpoint = s"exchanges/${id}", Map())

  }

  override def getExchangeTickersById(id: String): RootInterface = {
    getExchangeTickersById(id, coin_ids = List.empty, page = None, depth = None, order = None)
  }

  override def getExchangeTickersById(id: String, coin_ids: List[String], page: Option[Int], depth: Option[String], order: Option[String]): RootInterface = {
    def buildQuery: Map[String, String] =
      Map(
        "coin_ids" -> coin_ids.reduceLeftOption((left, right) => s"$left,$right"),
        "page" -> page.map(_.toString),
        "depth" -> depth.map(_.toString),
        "order" -> order.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    get[RootInterface](endpoint = s"exchanges/${id}/tickers", buildQuery)


  }

  override def getExchangeStatusUpdatesById(id: String): StatusUpdates = {
    getExchangeStatusUpdatesById(id, perPage = None, page = None)
  }

  override def getExchangeStatusUpdatesById(id: String, perPage: Option[Int], page: Option[Int]): StatusUpdates = {
    def buildQuery: Map[String, String] = {
      Map(
        "per_page" -> perPage.map(_.toString),
        "page" -> page.map(_.toString)
      ).filter(kv => kv._2.nonEmpty)
        .map(kv => kv._1 -> kv._2.getOrElse(""))

    }

    get[StatusUpdates](endpoint = s"exchanges/${id}/status_updates", buildQuery)

  }

  def getExchangeVolumeChart(id: String, days: Int): List[List[Double]] = {
    def buildQuery =
      Map(
        "days" -> days.toString
      )
    get[List[List[Double]]](endpoint = s"exchanges/${id}/volume_chart", buildQuery)
  }

  /*
    Exchange API Requests End
  */


}


