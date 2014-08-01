package fire

import simple.util.StatefulKieSessionSupport

/**
 * todo  
 */
object FireApp extends App with StatefulKieSessionSupport{

  override val sessionName: String = "BuildingSession"

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

  // Print status of building
  ksession.fireAllRules()

  // Start fires
  val kitchenFire = Fire( building.get( "kitchen" ).get )

  val officeFire= Fire( building.get( "office" ).get )
  
  val kitchenFireHandle = ksession.insert(kitchenFire)
  val officeFireHandler = ksession.insert(officeFire)

  ksession.fireAllRules()
  
  Thread.sleep(2000)

  ksession.delete(kitchenFireHandle)


  ksession.delete(officeFireHandler)
  println ("removed fires ")

  ksession.fireAllRules()

  ksession.dispose()
  println("done")
}
