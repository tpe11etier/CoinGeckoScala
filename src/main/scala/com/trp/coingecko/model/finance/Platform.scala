package com.trp.coingecko.model.finance

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class Platform(
                     name: String,
                     facts: String,
                     category: String,
                     centralized: Boolean,
                     website_url: String
                   )

object Platform {
  implicit val readsPlatform: ReadWriter[Platform] = macroRW[Platform]
}
