package listeners

import java.util
import java.util.concurrent.Executors

import com.typesafe.scalalogging.Logger
import fire.{Fire, Room, Sprinkler}
import org.drools.compiler.testframework.RuleCoverageListener
import org.drools.core.audit.WorkingMemoryConsoleLogger
import org.kie.internal.runtime.StatefulKnowledgeSession
import org.slf4j.LoggerFactory
import simple.util.StatefulKieSessionSupport



/**
  * todo
  */
object AuditApp extends App with StatefulKieSessionSupport {

  override val sessionName: String = "auditSession"


  private val logger = new WorkingMemoryConsoleLogger(ksession.asInstanceOf[StatefulKnowledgeSession])

  private val factType = container.getKieBase("auditbase").getFactType("auditdemo", "Customer" )
  private val c = factType.newInstance()
  factType.set(c,"age",23)
  factType.set(c,"name","john")
  ksession.setGlobal("logger",LoggerFactory.getLogger("drl"))

  ksession.insert(c)
  ksession.fireUntilHalt()




}
