package com.tasktd

import com.tasktd.services.AOEService
import com.tasktd.services.AOEServiceOnHttp
import com.tasktd.services.AOEAsyncServiceOnHttp
import monix.execution.Scheduler.Implicits.global

object TaskTD {
  /**
   * API url  https://age-of-empires-2-api.herokuapp.com/api/v1/
   */
  def main(args: Array[String]): Unit =
    val aoeSvc = new AOEAsyncServiceOnHttp(http = new AsyncHttp)

    aoeSvc.getUnits()
      .runAsync {
        case Left(err) =>
          println(s"Got err: ${err.toString}")
        case Right(units) =>
          println(units.head)
      }
}
