package com.trp.coingecko

import requests.{Request, Response}
import geny.Readable

class CoinGeckoAPI {
  def get(endpoint: String): Readable = {
    val apiURL = s"${CoinGeckoAPI.baseUrl}/$endpoint"
    requests.get.stream(apiURL)
  }
}

object CoinGeckoAPI {
  lazy val baseUrl = "https://api.coingecko.com/api/v3"
}