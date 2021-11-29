package com.trp.coingecko.model.coins.status

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class StatusUpdates(
                        status_updates: List[Status]
                        )

object StatusUpdates {
  implicit val readStatusUpdates: ReadWriter[StatusUpdates] = macroRW[StatusUpdates]
}