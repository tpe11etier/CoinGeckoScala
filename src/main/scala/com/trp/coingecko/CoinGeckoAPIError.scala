package com.trp.coingecko

case class CoinGeckoAPIError(
  code: Int,
  error: String
)

object CoinGeckoAPIError {
  def internalApiError(message: Option[String] = None): CoinGeckoAPIError =
    CoinGeckoAPIError(500, s"${message.getOrElse("CoinGecko API Error")}")
}
