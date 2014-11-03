package fire

import simple.util.StatefulKieSessionSupport
import scala.concurrent._
/**
 * todo  
 */
object FireApp2 extends App with StatefulKieSessionSupport{

  override val sessionName: String = "BuildingSession"

  System.out.println("fire until halt")
  //Create Building with Rooms
  val building = {
    val roomNames = List("kitchen", "Bedroom", "office", "living room")
    roomNames.map {
      s => s -> Room(s)
    }.toMap
  }
  // Insert facts
  for ((name, room) <- building) {
    ksession.insert(room)
    ksession.insert(Sprinkler(room))
  }
  import ExecutionContext.Implicits.global
  // Print status of building
  Future {
    ksession.fireUntilHalt()
  }
  // Start fires
  val kitchenFire = Fire( building.get( "kitchen" ).get )
  val officeFire= Fire( building.get( "office" ).get )
  
  val kitchenFireHandle = ksession insert kitchenFire 
  val officeFireHandler = ksession insert officeFire 

  
  Thread.sleep(2000)

  ksession delete kitchenFireHandle 
  ksession delete officeFireHandler 
  
  println ("removed fires ")

  Thread.sleep(2000)

  ksession.dispose()
  
  println("done")
}
