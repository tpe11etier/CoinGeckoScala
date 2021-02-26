package com.trp.coingecko

import requests.{Request, Response}

class CoinGeckoAPI {
  def get(endpoint: String): Response = {
    val apiURL = s"${CoingeckoApi.baseUrl}/$endpoint"
    requests.get(apiURL)
  }
}

object CoingeckoApi {
  lazy val baseUrl = "https://api.coingecko.com/api/v3"
}