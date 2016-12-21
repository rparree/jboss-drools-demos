package simple

import simple.model.Applicant
import simple.util.StatelessKieSessionSupport

/**
 * todo
 */
object SimpleApp extends App with StatelessKieSessionSupport {

  override val sessionName = "SimpleSession"

  val jenny= Applicant(name = "jennifer", age = 58, pass = false)


  println (s"value before: ${jenny.pass}")

  ksession.execute(jenny)

  println (s"value after: ${jenny.pass}")
}
