package com.trp.coingecko.model.coins.data

import upickle.default._

case class CodeAdditionsDeletions4Weeks(
                                         additions: Int,
                                         deletions: Int
                                       )

object CodeAdditionsDeletions4Weeks {
  implicit val readsCodeAdditionsDeletions4Weeks: ReadWriter[CodeAdditionsDeletions4Weeks] = macroRW[CodeAdditionsDeletions4Weeks]
}
