package reactive

import simple.util.StatefulKieSessionSupport
import PetType._
/**
 * todo
 */
object ReactiveApp  extends App with StatefulKieSessionSupport {
  override val sessionName: String = "ReactiveSession"

  val butkus = Pet(name = "Butkus", kind = Unknown)
  
  ksession insert butkus 
  
  ksession.fireAllRules()
}
