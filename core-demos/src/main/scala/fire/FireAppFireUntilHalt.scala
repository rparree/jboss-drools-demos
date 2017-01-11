package fire

import fire.FireApp.ksession
import org.drools.core.{ClassObjectFilter, ObjectFilter}
import org.kie.api.event.rule._
import simple.util.StatefulKieSessionSupport

import scala.concurrent._
import ExecutionContext.Implicits.global
/**
 * todo  
 */
object FireAppFireUntilHalt extends App with StatefulKieSessionSupport{

  override val sessionName: String = "BuildingSession"

  System.out.println("fire until halt")
  //Create Building with Rooms
  val rooms = Room("kitchen") :: Room("Bedroom") :: Room("office") :: Room("living room") :: Nil

  val SprinkerOff = Sprinkler(_: Room)
  rooms map SprinkerOff foreach ksession.insert
  rooms foreach ksession.insert

  Future {
    ksession.fireUntilHalt()
  }
  // Start fires
  ksession.insert(Fire(rooms(2)))
  ksession.insert(Fire(rooms(3)))

  Thread.sleep(30000)

  ksession.dispose()
  
  println("done")
}
