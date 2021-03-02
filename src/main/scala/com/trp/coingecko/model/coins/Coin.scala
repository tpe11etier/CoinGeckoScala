package com.trp.coingecko.model.coins

import upickle.default._

case class Coin(
  id: String
)

object Coin {
    implicit val coinReads: ReadWriter[Coin] = macroRW[Coin]
}
