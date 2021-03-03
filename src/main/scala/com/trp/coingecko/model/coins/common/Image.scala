package com.trp.coingecko.model.coins.common

import upickle.default._

case class Image(
                  thumb: String,
                  small: String,
                  large: String
                )

object Image {
  implicit val imageReads: Reader[Image] = macroRW[Image]
}
