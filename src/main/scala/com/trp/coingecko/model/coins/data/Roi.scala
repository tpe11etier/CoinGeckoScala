package com.trp.coingecko.model.coins.data

import upickle.default._

case class Roi(
  times: Double,
  currency: String,
  percentage: Double
)

object Roi {
  implicit val format: ReadWriter[Roi] = macroRW[Roi]
}