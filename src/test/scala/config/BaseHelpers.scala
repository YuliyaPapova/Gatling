package config

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object BaseHelpers {
  val application = "http://localhost/"
  val ajaxRequest = application + "wp-admin/admin-ajax.php"
  val checkoutRequest = application + "checkout"
  val postHeaderName = "Content-Type"
  val postHeaderValue = "application/x-www-form-urlencoded"


  val httpProtocol = http
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  def thinkTimer(Min: Int = 2, Max: Int = 5): ChainBuilder = {
    pause(Min, Max)
  }
}
