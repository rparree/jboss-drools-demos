package fire

import org.drools.core.ClassObjectFilter
import simple.util.StatefulKieSessionSupport

/**
 * todo  
 */
object FireApp extends App with StatefulKieSessionSupport{

  override val sessionName: String = "BuildingSession"

  //Create Building with Rooms
  val rooms = Room("kitchen") :: Room("Bedroom") :: Room("office") :: Room("living room") :: Nil

  val SprinkerOff = Sprinkler(_: Room)
  rooms map SprinkerOff foreach ksession.insert
  rooms foreach ksession.insert

  // Print status of building
  ksession.fireAllRules()

  // Start fires
  val fireHandler1 = ksession.insert(Fire(rooms(2)))
  val fireHandler2 = ksession.insert(Fire(rooms(3)))

  ksession.fireAllRules()
  
  Thread.sleep(6000)

  /* ksession delete fireHandler1
   ksession delete fireHandler2 */
  println ("removed fires ")

  ksession.fireAllRules()

  ksession.dispose()
  
  println("done")
}
