package com.trp.coingecko.model.coins

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class BaseCoin(
                     id: String,
                     symbol: String,
                     name: String
                   )

object BaseCoin {
  implicit val baseCoinReads: ReadWriter[BaseCoin] = macroRW[BaseCoin]
}