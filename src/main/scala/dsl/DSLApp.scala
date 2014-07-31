package dsl

import simple.util.StatefulKieSessionSupport
import scala.collection.JavaConversions._

/**
 * todo  
 */
object DSLApp extends App with StatefulKieSessionSupport {

  override val sessionName: String = "DSLSession"

  val member = Member("Gold")

  val reservation = Reservation(classUpgrade = true)

  ksession.insert(member)
  ksession.insert(reservation)
  ksession.fireAllRules()

  ksession.getObjects filter(c=>c.isInstanceOf[Miles]) foreach println

  ksession.dispose()
}
