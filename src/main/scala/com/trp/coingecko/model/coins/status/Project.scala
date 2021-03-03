package com.trp.coingecko.model.coins.status

import upickle.default._


case class Project(
                    `type`: String,
                    id: String,
                    name: String,
                    symbol: String,
                  )

object Project {
  implicit val readsProject: Reader[Project] = macroRW[Project]
}
