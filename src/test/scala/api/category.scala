package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object category {
  def category(category: String = "tables"): ChainBuilder = {
    exec(
      http("Category: " + category)
        .get(application + category)
    )
  }

  def tablePage(): ChainBuilder = {
    exec(
      http("Table Page")
        .get(application + "products/living-room-table8")
    )
  }

  def addTableToCart(): ChainBuilder = {
    exec(
      http("Add table to Cart")
        .post(ajaxRequest)
        .header(postHeaderName, postHeaderValue)
        .formParam("action", "ic_add_to_cart")
        .formParam("add_cart_data", "current_product=106&cart_content=&current_quantity=1")
        .formParam("cart_widget", "0")
        .formParam("cart_container", "0")
    )
  }

  def chair(): ChainBuilder = {
    exec(
      http("Chair Page")
        .get(application + "products/modern-chair1")
    )
  }

  def addChairToCart(): ChainBuilder = {
    exec(
      http("Add chair to Cart")
        .post(ajaxRequest)
        .header(postHeaderName, postHeaderValue)
        .formParam("action", "ic_add_to_cart")
        .formParam("add_cart_data", "current_product=76&cart_content=&current_quantity=1")
        .formParam("cart_widget", "0")
        .formParam("cart_container", "0")
    )
  }

  def cart(): ChainBuilder = {
    exec(
      http("Cart")
        .get(application + "cart")
    )
  }

  def checkout(): ChainBuilder = {
    exec(
      http("Checkout")
        .post(checkoutRequest)
        .header(postHeaderName, postHeaderValue)
        .formParam("cart_content", """{117__":1,"90__":1}""")
        .formParam("p_id[]", "117__")
        .formParam("p_quantity[]", "1")
        .formParam("p_id[]", "90__")
        .formParam("p_quantity[]", "1")
        .formParam("total_net", "184.00")
        .formParam("trans_id", "16904033155367")
        .formParam("shipping", "order")
    )
  }

  def getCountries(): ChainBuilder = {
    exec(
      http("Get Countries")
        .post(ajaxRequest)
        .header(postHeaderName, postHeaderValue)
        .formParam("action", "ic_state_dropdown")
        .formParam("country_code", "AF")
        .formParam("state_code", "")
    )
  }

  def checkoutFinal(): ChainBuilder = {
    exec(
      http("Final Checkout")
        .post(checkoutRequest)
        .header(postHeaderName, postHeaderValue)
        .formParam("ic_formbuilder_redirect", "http://localhost/thank-you")
        .formParam("cart_content", """{"90__":1,"121__":1}""")
        .formParam("product_price_90__", "95.00")
        .formParam("product_price_121__", "420.00")
        .formParam("total_net", "515.00")
        .formParam("trans_id", "16904052496619")
        .formParam("cart_content", """{"90__":1,"121__":1}""")
        .formParam("cart_type", "order")
        .formParam("cart_inside_header_1", "<b>BILLING ADDRESS</b>")
        .formParam("cart_company", "")
        .formParam("cart_name", "Yuliya")
        .formParam("cart_address", "Petar Petrov 7")
        .formParam("cart_postal", "9101")
        .formParam("cart_city", "Gomel")
        .formParam("cart_country", "AF")
        .formParam("cart_state", "")
        .formParam("cart_phone", "25897452")
        .formParam("cart_email", "125874@mail.ru")
        .formParam("cart_comment", "")
        .formParam("cart_inside_header_2", "<b>DELIVERY ADDRESS</b> (FILL ONLY IF DIFFERENT FROM THE BILLING ADDRESS)")
        .formParam("cart_s_company", "")
        .formParam("cart_s_name", "")
        .formParam("cart_s_address", "")
        .formParam("cart_s_postal", "")
        .formParam("cart_s_city", "")
        .formParam("cart_s_country", "")
        .formParam("cart_s_state", "")
        .formParam("cart_s_phone", "")
        .formParam("cart_s_email", "")
        .formParam("cart_s_comment", "")
        .formParam("cart_submit", "Place Order")
    )
  }

  def thankYou(): ChainBuilder = {
    exec(
      http("Thank You page")
        .get(application + "thank-you")
    )
  }
}
