package com.trp.coingecko

trait CoinGeckoClient {
  def ping: Either[CoinGeckoAPIError, requests.Response]
}
