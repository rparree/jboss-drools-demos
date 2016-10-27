package listeners

import com.typesafe.scalalogging.{LazyLogging, Logger}
import org.drools.core.audit.WorkingMemoryConsoleLogger
import org.kie.api.event.rule._
import org.kie.internal.runtime.StatefulKnowledgeSession
import org.slf4j.LoggerFactory
import simple.util.StatefulKieSessionSupport

import scala.runtime.Nothing$


/**
  * todo
  */
object ListenerApp extends App with StatefulKieSessionSupport with LazyLogging {

  override val sessionName: String = "auditSession"


  ksession.addEventListener(new MyLogger)

  val kbase = container.getKieBase("auditbase")
  val customerType = kbase.getFactType("auditdemo", "Customer" )
  val fooType = kbase.getFactType("auditdemo", "Foo" )
  val c = customerType.newInstance()
  customerType.set(c,"age",23)
  customerType.set(c,"name","john")

  ksession.setGlobal("logger",LoggerFactory.getLogger("drl"))

  ksession.insert(fooType.newInstance())
  ksession.insert(c)
  ksession.fireUntilHalt()




}


class MyLogger extends DefaultAgendaEventListener  with LazyLogging {

  override def matchCreated(event: MatchCreatedEvent) = logger.info(s"placed [${event.getMatch.getRule.getName}] on agenda ")


  override def beforeMatchFired(event: BeforeMatchFiredEvent) = logger.info(s"about to execute RHS of [${event.getMatch.getRule.getName}]")


  override def afterMatchFired(event: AfterMatchFiredEvent) = logger.info(s"executed [${event.getMatch.getRule.getName}]")


}
