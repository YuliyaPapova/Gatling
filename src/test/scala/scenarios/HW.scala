package scenarios

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object HW {
  def scnHW:ScenarioBuilder = {
    val chairsGroup = group("Category Chairs") {
      exec(api.category.category("chairs")).exec(thinkTimer())
        .exec(api.category.chair()).exec(thinkTimer())
        .exec(api.category.addChairToCart()).exec(thinkTimer())
    }

    val checkoutGroup = group("Checkout") {
      exec(api.category.cart()).exec(thinkTimer())
        .exec(api.category.checkout()).exec(thinkTimer())
        .exec(api.category.getCountries()).exec(thinkTimer())
        .exec(api.category.checkoutFinal()).exec(thinkTimer())
        .exec(api.category.thankYou())
    }

    scenario("Add Table and Chair and Place an Order")
      .exec(flushHttpCache)
      .exec(flushCookieJar)
      .exitBlockOnFail(
        group("Home page") {
          exec(api.Home.localhostHome()).exec(thinkTimer())
        }
        .group("Category Tables") {
          exec(api.category.category()).exec(thinkTimer())
            .exec(api.category.tablePage()).exec(thinkTimer())
            .exec(api.category.addTableToCart()).exec(thinkTimer())
        }
        .randomSwitch(
          50.0 -> exec(chairsGroup)
        )
        .randomSwitch(
           30.0 -> exec(checkoutGroup)
        )
      )
  }
}
