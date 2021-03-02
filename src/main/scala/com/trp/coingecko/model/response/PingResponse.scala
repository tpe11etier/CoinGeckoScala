package com.trp.coingecko.model.response

import upickle.default._

case class PingResponse(
  gecko_says: String
)

object PingResponse  {
  implicit val pingReads: ReadWriter[PingResponse] = macroRW[PingResponse]
}

