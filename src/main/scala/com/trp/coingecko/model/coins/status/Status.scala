package com.trp.coingecko.model.coins.status

import com.trp.coingecko.model.coins.common.Image
import upickle.default._

case class Status(
                   status_updates: List[String],
                   description: String,
                   category: String,
                   created_at: String,
                   user: String,
                   user_title: String,
                   pin: Boolean,
                   project: Map[String, String],
                   image: Image,

                 )

object Status {
  implicit val readsStatus: Reader[Status] = macroRW[Status]
}