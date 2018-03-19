package com.springboot.simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

import scala.concurrent.duration._

class CustomerBlockingSimulation extends Simulation {

    before {
        println("***** Customer blocking simulation start *****")
    }

    after {
        println("***** Customer blocking simulation end ******")
    }

    val theHttpProtocolBuilder = http
        .baseURL("http://localhost:8080")
        .acceptHeader("application/json")

 
    val theScenarioBuilder = scenario("Scenario1")
        .exec(
            http("Request all blocking customers")
                .get("/blocking/customers")
                /* Several checks on the response can be specified. */
                .check(
                    /* Check that the HTTP status returned is 200 or 201. */
                    status.find.in(200),
                    /* Check that there is at least one match of the supplied regular expression in the response body. */
                    regex("first-name").count.greaterThanOrEqual(1)
            )
        )
        
    setUp(
       theScenarioBuilder.inject(rampUsersPerSec(50) to (200) during(5 minutes))
    ).protocols(theHttpProtocolBuilder)
}
