package com.trp.coingecko.model.coins.status

import com.trp.coingecko.model.coins.common.Image
import upickle.default._


case class Project(
                    `type`: String,
                    id: String,
                    name: String,
//                    symbol: String,
                    image: Image
                  )

object Project {
  implicit val projectReads: ReadWriter[Project] = macroRW[Project]
}
