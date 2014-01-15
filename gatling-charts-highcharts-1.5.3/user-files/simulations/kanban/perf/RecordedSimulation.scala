package kanban.perf 
import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import com.excilys.ebi.gatling.jdbc.Predef._
import com.excilys.ebi.gatling.http.Headers.Names._
import akka.util.duration._
import bootstrap._
import assertions._

class RecordedSimulation extends Simulation {

   val httpConf = httpConfig
         .baseURL("http://localhost")
         .acceptHeader("*/*")
         .acceptEncodingHeader("gzip, deflate")
         .acceptLanguageHeader("en-US,en;q=0.5")
         .connection("keep-alive")
         .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.9; rv:25.0) Gecko/20100101 Firefox/25.0")


   val headers_1 = Map(
         "Accept" -> """text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"""
   )

   val headers_2 = Map(
         "Accept" -> """text/css,*/*;q=0.1"""
   )

   val headers_11 = Map(
         "Accept" -> """image/png,image/*;q=0.8,*/*;q=0.5"""
   )

   val headers_12 = Map(
         "Accept" -> """text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8""",
         "Content-Type" -> """application/x-www-form-urlencoded"""
   )

   val headers_13 = Map(
         "Accept" -> """text/css,*/*;q=0.1""",
         "If-Modified-Since" -> """Sun, 22 Sep 2013 04:48:02 GMT""",
         "If-None-Match" -> """"69390-1379825282000""""
   )

   val headers_14 = Map(
         "Accept" -> """text/css,*/*;q=0.1""",
         "If-Modified-Since" -> """Sun, 22 Sep 2013 04:48:02 GMT""",
         "If-None-Match" -> """"7587-1379825282000""""
   )

   val headers_15 = Map(
         "Accept" -> """text/css,*/*;q=0.1""",
         "If-Modified-Since" -> """Fri, 13 Dec 2013 15:43:46 GMT""",
         "If-None-Match" -> """"1553-1386949426000""""
   )

   val headers_16 = Map(
         "If-Modified-Since" -> """Sun, 22 Sep 2013 04:48:02 GMT""",
         "If-None-Match" -> """"27427-1379825282000""""
   )

   val headers_17 = Map(
         "If-Modified-Since" -> """Sun, 22 Sep 2013 04:48:02 GMT""",
         "If-None-Match" -> """"42732-1379825282000""""
   )

   val headers_18 = Map(
         "If-Modified-Since" -> """Sun, 22 Sep 2013 04:48:02 GMT""",
         "If-None-Match" -> """"228137-1379825282000""""
   )

   val headers_19 = Map(
         "If-Modified-Since" -> """Sun, 22 Sep 2013 04:48:02 GMT""",
         "If-None-Match" -> """"93107-1379825282000""""
   )

   val headers_20 = Map(
         "If-Modified-Since" -> """Mon, 23 Sep 2013 14:01:54 GMT""",
         "If-None-Match" -> """"374-1379944914000""""
   )

   val headers_21 = Map(
         "If-Modified-Since" -> """Sun, 22 Sep 2013 04:48:02 GMT""",
         "If-None-Match" -> """"4258-1379825282000""""
   )

   val headers_37 = Map(
         "X-Requested-With" -> """XMLHttpRequest"""
   )

   val headers_39 = Map(
         "Content-Type" -> """application/x-www-form-urlencoded; charset=UTF-8""",
         "X-Requested-With" -> """XMLHttpRequest"""
   )


   val scn = scenario("Scenario Name")
      .exec(http("request_1")
               .get("/")
               .headers(headers_1)
         )
      .pause(74 milliseconds)
      .exec(http("request_2")
               .get("/vendor/css/bootstrap-glyphicons.css")
               .headers(headers_2)
         )
      .exec(http("request_3")
               .get("/css/site.css")
               .headers(headers_2)
         )
      .exec(http("request_4")
               .get("/vendor/css/bootstrap.min.css")
               .headers(headers_2)
         )
      .pause(15 milliseconds)
      .exec(http("request_5")
               .get("/vendor/scripts/knockout-sortable-0.8.2.min.js")
         )
      .exec(http("request_6")
               .get("/scripts/site.js")
         )
      .exec(http("request_7")
               .get("/vendor/scripts/knockout-2.3.0.min.js")
         )
      .exec(http("request_8")
               .get("/vendor/scripts/bootstrap-3.0.0.min.js")
         )
      .exec(http("request_9")
               .get("/vendor/scripts/jquery-1.10.2.min.js")
         )
      .pause(11 milliseconds)
      .exec(http("request_10")
               .get("/vendor/scripts/jquery-ui-1.10.3.custom.min.js")
         )
      .pause(183 milliseconds)
      .exec(http("request_11")
               .get("/favicon.ico")
               .headers(headers_11)
         )
      .pause(7)
      .exec(http("request_12")
               .post("/login")
               .headers(headers_12)
                  .param("""username""", """test@test.com""")
                  .param("""password""", """test""")
         )
      .pause(104 milliseconds)
      .exec(http("request_13")
               .get("/vendor/css/bootstrap.min.css")
               .headers(headers_13)
               .check(status.is(304))
         )
      .exec(http("request_14")
               .get("/vendor/css/bootstrap-glyphicons.css")
               .headers(headers_14)
               .check(status.is(304))
         )
      .exec(http("request_15")
               .get("/css/site.css")
               .headers(headers_15)
               .check(status.is(304))
         )
      .exec(http("request_16")
               .get("/vendor/scripts/bootstrap-3.0.0.min.js")
               .headers(headers_16)
               .check(status.is(304))
         )
      .pause(11 milliseconds)
      .exec(http("request_17")
               .get("/vendor/scripts/knockout-2.3.0.min.js")
               .headers(headers_17)
               .check(status.is(304))
         )
      .exec(http("request_18")
               .get("/vendor/scripts/jquery-ui-1.10.3.custom.min.js")
               .headers(headers_18)
               .check(status.is(304))
         )
      .exec(http("request_19")
               .get("/vendor/scripts/jquery-1.10.2.min.js")
               .headers(headers_19)
               .check(status.is(304))
         )
      .exec(http("request_20")
               .get("/scripts/site.js")
               .headers(headers_20)
               .check(status.is(304))
         )
      .exec(http("request_21")
               .get("/vendor/scripts/knockout-sortable-0.8.2.min.js")
               .headers(headers_21)
               .check(status.is(304))
         )
      .exec(http("request_22")
               .get("/vendor/scripts/jquery.bootstrap-growl.min.js")
         )
      .exec(http("request_23")
               .get("/vendor/scripts/require-2.1.8.js")
         )
      .exec(http("request_24")
               .get("/vendor/scripts/pager.js")
         )
      .pause(248 milliseconds)
      .exec(http("request_25")
               .get("/vendor/fonts/glyphiconshalflings-regular.woff")
               .headers(headers_1)
         )
      .exec(http("request_26")
               .get("/scripts/main.js")
         )
      .pause(50 milliseconds)
      .exec(http("request_27")
               .get("/scripts/viewModels/queueManagement.js")
         )
      .exec(http("request_28")
               .get("/scripts/viewModels/editQueue.js")
         )
      .exec(http("request_29")
               .get("/scripts/viewModels/newCard.js")
         )
      .exec(http("request_30")
               .get("/scripts/viewModels/home.js")
         )
      .exec(http("request_31")
               .get("/scripts/viewModels/main.js")
         )
      .exec(http("request_32")
               .get("/scripts/navigation.js")
         )
      .pause(11 milliseconds)
      .exec(http("request_33")
               .get("/scripts/services/queueService.js")
         )
      .exec(http("request_34")
               .get("/scripts/ui/queueManagementUI.js")
         )
      .exec(http("request_35")
               .get("/scripts/services/cardService.js")
         )
      .exec(http("request_36")
               .get("/scripts/growler.js")
         )
      .pause(48 milliseconds)
      .exec(http("request_37")
               .get("/queues")
               .headers(headers_37)
         )
      .pause(3)
      .exec(http("request_38")
               .get("/queues")
               .headers(headers_37)
         )
      .pause(3)
      .exec(http("request_39")
               .put("/queues")
               .headers(headers_39)
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
      .pause(22 milliseconds)
      .exec(http("request_40")
               .get("/queues")
               .headers(headers_37)
         )
      .pause(1)
      .exec(http("request_41")
               .get("/queues")
               .headers(headers_37)
         )
      .pause(2)
      .exec(http("request_42")
               .put("/queues")
               .headers(headers_39)
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

   setUp(scn.users(1).protocolConfig(httpConf))
}
