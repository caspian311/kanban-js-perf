import io.gatling.core.Predef._
import io.gatling.core.session.Expression
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import io.gatling.http.Headers.Names._
import io.gatling.http.Headers.Values._
import scala.concurrent.duration._
import bootstrap._
import assertions._
import io.gatling.core.structure.ScenarioBuilder
import KanbanJSSimulation._
import io.gatling.core.structure.ChainBuilder

class KanbanJSSimulation extends Simulation {

    val siteUrl = "http://localhost:3000";
    val numberOfUsers = 500;
    val rampUpPeriod = 30 seconds;

    val httpProtocol = http
      .baseURL(siteUrl)
      .acceptHeader("*/*")
      .acceptEncodingHeader("gzip,deflate,sdch")
      .acceptLanguageHeader("en-US,en;q=0.8")
      .connection("keep-alive")
      .userAgentHeader("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1847.131 Safari/537.36")
      
   val staticContentScenario = scenario("Scenario Name")
      .makeRequest("/")
      .makeRequest("/vendor/css/bootstrap-glyphicons.css")
      .makeRequest("/vendor/css/bootstrap.min.css")
      .makeRequest("/vendor/scripts/knockout-sortable-0.8.2.min.js")
      .makeRequest("/scripts/site.js")
      .makeRequest("/vendor/scripts/knockout-2.3.0.min.js")
      .makeRequest("/vendor/scripts/bootstrap-3.0.0.min.js")
      .makeRequest("/vendor/scripts/jquery-1.10.2.min.js")
      .makeRequest("/vendor/scripts/jquery-ui-1.10.3.custom.min.js")
      .makeRequest("/favicon.ico")

   val loginScenario = 
      exec(http("/login")
               .post("/login")
                  .param("""username""", """test@test.com""")
                  .param("""password""", """test""")
         )

   setUp(
      staticContentScenario.inject(ramp(numberOfUsers users) over (rampUpPeriod)),
      loginScenario.inject(ramp(numberOfUsers users) over (rampUpPeriod))
   ).protocols(httpProtocol)
}

object KanbanJSSimulation {
  implicit class CustomScenarioBuilder(val scenario: ScenarioBuilder) {
    val headers = Map("Accept" -> "image/webp,text/plain,application/json,text/css,text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")

   def makeRequest(path:String) = {
      scenario.exec(http(path).get(path).headers(headers).check(status.is(200))).pause(25 milliseconds)
    }
  }
  
}
