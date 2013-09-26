package fire

import org.drools.builder.{ResourceType, KnowledgeBuilderFactory}
import org.drools.io.ResourceFactory
import org.drools.{FactHandle, KnowledgeBaseFactory}

/**
 * todo  
 */
object FireApp extends App {
  val kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder
  kbuilder.add(ResourceFactory.newClassPathResource("fire/Fire.drl"), ResourceType.DRL)


  if (kbuilder.hasErrors) {
    System.err.println(kbuilder.getErrors.toString)
  }

  //Initialise new session
  val kbase = KnowledgeBaseFactory.newKnowledgeBase
  kbase.addKnowledgePackages(kbuilder.getKnowledgePackages)
  val ksession = kbase.newStatefulKnowledgeSession()

  Map()

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

  ksession.insert(kitchenFire)
  ksession.insert(officeFire)

  ksession.fireAllRules()


  Thread.sleep(60000l)

  ksession.dispose()
  println("done")

}
