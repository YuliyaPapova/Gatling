package api

import config.BaseHelpers.application
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object Home {
  def localhostHome(): ChainBuilder = {
  exec(
    http("Application Home")
      .get(application)
  )
  }

}
