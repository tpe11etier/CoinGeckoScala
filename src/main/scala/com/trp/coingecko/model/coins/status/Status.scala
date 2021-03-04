package com.trp.coingecko.model.coins.status

import com.trp.coingecko.model.coins.common.Image
import upickle.default._

case class Status(
                   description: String,
                   category: String,
                   created_at: String,
                   user: String,
                   user_title: String,
                   pin: Boolean,
                   project: Project

                 )

object Status {
  implicit val readsStatus: ReadWriter[Status] = macroRW[Status]
}