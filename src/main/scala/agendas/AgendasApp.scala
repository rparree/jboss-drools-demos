package agendas


import simple.util.StatefulKieSessionSupport

/**
 * todo
 */
object AgendasApp extends App with StatefulKieSessionSupport{
  override val sessionName: String = "AgendasSession"
  
  ksession.insert(Foo())


  ksession.fireAllRules();
}

case class Foo()
case class Bar()
case class Tar()
