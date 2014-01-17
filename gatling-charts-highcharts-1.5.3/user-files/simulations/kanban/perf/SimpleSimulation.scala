package kanban.perf 
import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._
import assertions._

class SimpleSimulation extends Simulation {

   val httpConf = httpConfig
         .baseURL("http://localhost")
         .acceptHeader("*/*")
         .acceptEncodingHeader("gzip, deflate")
         .acceptLanguageHeader("en-US,en;q=0.5")
         .connection("keep-alive")
         .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:25.0) Gecko/20100101 Firefox/25.0")


   val loginScenario = 
      scenario("")
      .exec(http("/login")
               .post("/login")
                  .param("""username""", """test@test.com""")
                  .param("""password""", """test""")
         )
      .repeat(10) {
         pause(1)
         .exec(
            http("GET /queues").get("/queues")
            )
      }
      .pause(1)
      .exec(
            http("/logout") .get("/logout")
         )

   val numberOfUsers = 500

   setUp(
       loginScenario.users(numberOfUsers).ramp(10).protocolConfig(httpConf)
       )
}
