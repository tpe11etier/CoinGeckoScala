package com.trp.coingecko.model.exchanges

import cats.derived.auto.iterable.kittensMkIterable
import upickle.default._

case class VolumeChart(
                        vcd: Int,
                        vca: String
                      )


object VolumeChart {
    implicit val readsVolumeChart: ReadWriter[VolumeChart] = macroRW[VolumeChart]





  //  val foo: VolumeChart = readsVolumeChart.foldLeft(readsVolumeChart: Any){case (r, v) => r.asInstanceOf[Function[Any, _]](v) }.asInstanceOf[VolumeChart]

}
