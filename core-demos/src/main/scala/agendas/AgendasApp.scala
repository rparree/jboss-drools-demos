package agendas


import simple.util.StatefulKieSessionSupport

/**
 * todo
 */
object AgendasApp extends App with StatefulKieSessionSupport{
  override val sessionName: String = "AgendasSession"

  val foo = Foo()
  ksession insert foo

  ksession.fireAllRules()
}

case class Foo()
case class Bar()
case class Tar()
