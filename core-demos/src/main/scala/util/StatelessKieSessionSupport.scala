package simple.util

import org.kie.api.runtime.StatelessKieSession

/**
 * todo
 */
trait StatelessKieSessionSupport extends KieContainerSupport {
  
  val sessionName : String
  
  lazy val ksession: StatelessKieSession = container.newStatelessKieSession(sessionName)

}
