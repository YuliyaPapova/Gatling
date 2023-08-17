package simulations

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.HW.scnHW

class PerfTestSimulation extends Simulation {


  //mvn gatling:test
  //mvn clean gatling:test
  setUp {
    scnHW.inject(atOnceUsers(100))
  }.protocols(httpProtocol)
}