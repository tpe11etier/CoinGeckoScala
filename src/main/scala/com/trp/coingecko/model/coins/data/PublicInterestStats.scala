package com.trp.coingecko.model.coins.data

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class PublicInterestStats(
                                alexa_rank: Int,
                                bing_matches: String
                              )

object PublicInterestStats {
  implicit val readsPublicInterestStats: ReadWriter[PublicInterestStats] = macroRW[PublicInterestStats]
}

