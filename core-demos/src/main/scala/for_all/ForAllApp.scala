package for_all

import java.util

import simple.util.{StatefulKieSessionSupport, StatelessKieSessionSupport}

import scala.concurrent.{ExecutionContext, Future}

/**
  * todo
  */

case class Bus(colour : String, _type : String)

object ForAllApp extends App with StatefulKieSessionSupport {

  override val sessionName = "for_all"


  import ExecutionContext.Implicits.global
 /* Future{
    ksession.fireUntilHalt()
  }
 */


  ksession.insert(
    Bus("red", "uk"),
    Bus("red", "uk"),
    Bus("red", "uk"),
    Bus("blue", "fr"))
  ksession.fireAllRules()
  Thread.sleep(1000000)




}
