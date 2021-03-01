package com.trp.coingecko

import com.trp.coingecko.model.PingResponse
import requests.Response

trait CoinGeckoClient {
  def ping: Either[CoinGeckoAPIError, PingResponse]

  def getPrice(ids: List[String], vsCurrencies: List[String]): Either[CoinGeckoAPIError, Response]
}
