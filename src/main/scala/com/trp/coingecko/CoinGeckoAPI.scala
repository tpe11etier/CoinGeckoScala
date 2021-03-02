package com.trp.coingecko

import geny.Readable
import requests.Session

class CoinGeckoAPI {
  def get(endpoint: String, params: Map[String,String]): Readable = {
    val apiURL = s"${CoinGeckoAPI.baseUrl}/$endpoint"
    val session = Session()
    session.get(apiURL, params = params)
  }
}

object CoinGeckoAPI {
  lazy val baseUrl = "https://api.coingecko.com/api/v3"
}