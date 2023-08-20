package simulations

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.HW.scnHW

class PerfTestSimulation extends Simulation {

val testDuration = 4 * 60 * 60;
val numUsers = 160;
  
  //mvn gatling:test
  //mvn clean gatling:test
  
setUp {
     scnHW.inject(constantConcurrentUsers(numUsers).during(testDuration))
  }.protocols(httpProtocol)
}
