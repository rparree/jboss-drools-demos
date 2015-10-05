package loops

import simple.util.StatefulKieSessionSupport

/**
 * todo
 */
object LoopsApp extends App with StatefulKieSessionSupport {
  override val sessionName: String = "LoopsSession"

  ksession insert new Foo()
  ksession.fireAllRules()

}

class Foo
class Bar