package com.trp.coingecko.model.coins.common

import upickle.default._

case class ConvertedLast (
  btc: Double,
  eth: Double,
  usd: Double
)

object ConvertedLast {
  implicit val readsConvertedLast: ReadWriter[ConvertedLast] = macroRW[ConvertedLast]
}
