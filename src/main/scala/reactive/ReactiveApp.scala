package reactive

import simple.util.StatefulKieSessionSupport
import PetType._
/**
 * todo
 */
object ReactiveApp  extends App with StatefulKieSessionSupport {
  override val sessionName: String = "ReactiveSession"
  
  ksession.insert(Pet("Butkus",kind = Unknown))
  ksession.fireAllRules()
}
