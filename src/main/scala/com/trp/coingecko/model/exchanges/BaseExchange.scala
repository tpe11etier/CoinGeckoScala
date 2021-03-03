package com.trp.coingecko.model.exchanges

import upickle.default._

case class BaseExchange(
                       id: String,
                       name: String
                       )

object BaseExchange {
  implicit val readBaseExchange: ReadWriter[BaseExchange] = macroRW[BaseExchange]
}