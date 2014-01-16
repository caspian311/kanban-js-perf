package kanban.perf 
import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._
import assertions._

class KanbanJSSimulation extends Simulation {

   val httpConf = httpConfig
         .baseURL("http://localhost")
         .acceptHeader("*/*")
         .acceptEncodingHeader("gzip, deflate")
         .acceptLanguageHeader("en-US,en;q=0.5")
         .connection("keep-alive")
         .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:25.0) Gecko/20100101 Firefox/25.0")


   val requestStaticContent = scenario("Static content")
      .exec(http("/")
               .get("/")
         )
      .exec(http("/vendor/css/bootstrap-glyphicons.css")
               .get("/vendor/css/bootstrap-glyphicons.css")
         )
      .exec(http("/css/site.css")
               .get("/css/site.css")
         )
      .exec(http("/vendor/css/bootstrap.min.css")
               .get("/vendor/css/bootstrap.min.css")
         )
      .exec(http("/vendor/scripts/knockout-sortable-0.8.2.min.js")
               .get("/vendor/scripts/knockout-sortable-0.8.2.min.js")
         )
      .exec(http("/scripts/site.js")
               .get("/scripts/site.js")
         )
      .exec(http("/vendor/scripts/knockout-2.3.0.min.js")
               .get("/vendor/scripts/knockout-2.3.0.min.js")
         )
      .exec(http("/vendor/scripts/bootstrap-3.0.0.min.js")
               .get("/vendor/scripts/bootstrap-3.0.0.min.js")
         )
      .exec(http("/vendor/scripts/jquery-1.10.2.min.js")
               .get("/vendor/scripts/jquery-1.10.2.min.js")
         )
      .exec(http("/vendor/scripts/jquery-ui-1.10.3.custom.min.js")
               .get("/vendor/scripts/jquery-ui-1.10.3.custom.min.js")
         )
      .exec(http("/favicon.ico")
               .get("/favicon.ico")
         )
   
   val loginScenario = scenario("Login")
      .exec(http("/login")
               .post("/login")
                  .param("""username""", """test@test.com""")
                  .param("""password""", """test""")
         )

   val homePageStaticContentScenario = scenario("Home page static content") 
      .exec(http("/vendor/css/bootstrap.min.css")
               .get("/vendor/css/bootstrap.min.css")
         )
      .exec(http("/vendor/css/bootstrap-glyphicons.css")
               .get("/vendor/css/bootstrap-glyphicons.css")
         )
      .exec(http("/css/site.css")
               .get("/css/site.css")
         )
      .exec(http("/vendor/scripts/bootstrap-3.0.0.min.js")
               .get("/vendor/scripts/bootstrap-3.0.0.min.js")
         )
      .exec(http("/vendor/scripts/knockout-2.3.0.min.js")
               .get("/vendor/scripts/knockout-2.3.0.min.js")
         )
      .exec(http("/vendor/scripts/jquery-ui-1.10.3.custom.min.js")
               .get("/vendor/scripts/jquery-ui-1.10.3.custom.min.js")
         )
      .exec(http("/vendor/scripts/jquery-1.10.2.min.js")
               .get("/vendor/scripts/jquery-1.10.2.min.js")
         )
      .exec(http("/scripts/site.js")
               .get("/scripts/site.js")
         )
      .exec(http("/vendor/scripts/knockout-sortable-0.8.2.min.js")
               .get("/vendor/scripts/knockout-sortable-0.8.2.min.js")
         )
      .exec(http("/vendor/scripts/jquery.bootstrap-growl.min.js")
               .get("/vendor/scripts/jquery.bootstrap-growl.min.js")
         )
      .exec(http("/vendor/scripts/require-2.1.8.js")
               .get("/vendor/scripts/require-2.1.8.js")
         )
      .exec(http("/vendor/scripts/pager.js")
               .get("/vendor/scripts/pager.js")
         )
      .exec(http("/vendor/fonts/glyphiconshalflings-regular.woff")
               .get("/vendor/fonts/glyphiconshalflings-regular.woff")
         )
      .exec(http("/scripts/main.js")
               .get("/scripts/main.js")
         )
      .exec(http("/scripts/viewModels/queueManagement.js")
               .get("/scripts/viewModels/queueManagement.js")
         )
      .exec(http("/scripts/viewModels/editQueue.js")
               .get("/scripts/viewModels/editQueue.js")
         )
      .exec(http("/scripts/viewModels/newCard.js")
               .get("/scripts/viewModels/newCard.js")
         )
      .exec(http("/scripts/viewModels/home.js")
               .get("/scripts/viewModels/home.js")
         )
      .exec(http("/scripts/viewModels/main.js")
               .get("/scripts/viewModels/main.js")
         )
      .exec(http("/scripts/navigation.js")
               .get("/scripts/navigation.js")
         )
      .exec(http("/scripts/services/queueService.js")
               .get("/scripts/services/queueService.js")
         )
      .exec(http("/scripts/ui/queueManagementUI.js")
               .get("/scripts/ui/queueManagementUI.js")
         )
      .exec(http("/scripts/services/cardService.js")
               .get("/scripts/services/cardService.js")
         )
      .exec(http("/scripts/growler.js")
               .get("/scripts/growler.js")
         )
         
   val homePageScenario = scenario("Home page")
      .exec(http("GET /queues")
               .get("/queues")
         )
      
   val dragCardToRightScenario = scenario("Drag card to right")
      .exec(http("PUT /queues")
               .put("/queues")
                  .body(s => """
                     { 
                        "id", "52d703a3cf493f520f000004",
                        "name", "test board",
                        "description", "this is the test board",
                        "creationDate", ,
                        "states[0][name]", "state 1",
                        "states[0][cards][0][name]", "card 1",
                        "states[0][cards][0][description]", "this is my first card",
                        "states[0][cards][0][orderBy]", "0",
                        "states[0][orderBy]", "0",
                        "states[1][name]", "state 2",
                        "states[1][orderBy]", "1"
                     }
                    """)
         )
         
   val dragCardToLeftScenario = scenario("Drag card to right")
      .exec(http("PUT /queues")
               .put("/queues")
                  .body(s => """
                     {
                        "id", "52d703a3cf493f520f000004",
                        "name", "test board",
                        "description", "this is the test board",
                        "states[0][id]", "52d706141608c92f14000005",
                        "states[0][name]", "state 1",
                        "states[0][orderBy]", "0",
                        "states[1][id]", "52d706141608c92f14000006",
                        "states[1][name]", "state 2",
                        "states[1][cards][0][name]", "card 1",
                        "states[1][cards][0][description]", "this is my first card",
                        "states[1][cards][0][orderBy]", "0",
                        "states[1][orderBy]", "1"
                     }
                      """)
         )

   val waitASecond = scenario("Wait for a second")
      .pause(1)
         
   val numberOfUsers = 100
   
   setUp(
       requestStaticContent.users(numberOfUsers).protocolConfig(httpConf),
       loginScenario.users(numberOfUsers).protocolConfig(httpConf),
       waitASecond.users(numberOfUsers).protocolConfig(httpConf),
       homePageStaticContentScenario.users(numberOfUsers).protocolConfig(httpConf),
       homePageScenario.users(numberOfUsers).protocolConfig(httpConf),
       dragCardToRightScenario.users(numberOfUsers).protocolConfig(httpConf),
       homePageScenario.users(numberOfUsers).protocolConfig(httpConf),
       dragCardToLeftScenario.users(numberOfUsers).protocolConfig(httpConf)
       )
}
