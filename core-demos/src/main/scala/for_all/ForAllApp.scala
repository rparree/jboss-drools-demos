package for_all

import simple.util.{StatefulKieSessionSupport, StatelessKieSessionSupport}

import scala.concurrent.{ExecutionContext, Future}

/**
  * todo
  */

case class Bus(colour : String)

object ForAllApp extends App with StatefulKieSessionSupport {

  override val sessionName = "otherSession"


  import ExecutionContext.Implicits.global
 /* Future{
    ksession.fireUntilHalt()
  }
 */

  ksession.insert(Bus("red"),Bus("red"),Bus("red"))
  ksession.fireAllRules()
  ksession.insert(Bus("red"))
  ksession.fireAllRules()
  ksession.insert(Bus("blue"))
  ksession.fireAllRules()
  Thread.sleep(1000000)




}
