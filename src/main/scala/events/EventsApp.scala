package events


import simple.util.StatefulKieSessionSupport

/**
 * todo
 */
object EventsApp extends App with StatefulKieSessionSupport {
  override val sessionName: String = "EventsSession"

  val point = ksession.getEntryPoint("fire")
  ksession.insert(Sprinkler())
  ksession.fireAllRules()
  
  point.insert(new  Fire())

  ksession.fireAllRules()

}
