package com.trp.coingecko.model.exchanges

import upickle.default._

case class VolumeChart(
                        vcd: VolumeChartDate,
                        vca: VolumeChartAmount
                      )

case class VolumeChartDate(
                            vcd: Double
                          )

case class VolumeChartAmount(
                              vca: Double
                            )

object VolumeChart {
  implicit val readsVolumeChart: ReadWriter[VolumeChart] = macroRW[VolumeChart]
  implicit val readsVolumeChartDate: ReadWriter[VolumeChartDate] = macroRW[VolumeChartDate]
  implicit val readsVolumeChartAmount: ReadWriter[VolumeChartAmount] = macroRW[VolumeChartAmount]
}
