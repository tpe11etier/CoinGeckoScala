package com.trp.coingecko.model

import upickle.default

case class PingResponse(
  geckoSays: String
)

object PingResponse  {
  implicit val pingReads: default.ReadWriter[PingResponse] = upickle.default.macroRW[PingResponse]
}
