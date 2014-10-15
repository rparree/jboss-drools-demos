package simple.util

import org.kie.api.runtime.KieSession

/**
  * todo
  */
trait StatefulKieSessionSupport extends KieContainerSupport {
   
   val sessionName : String
   
   lazy val ksession: KieSession= container.newKieSession(sessionName)
 
 }
