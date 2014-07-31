package simple

import simple.model.Applicant
import simple.util.StatelessKieSessionSupport

/**
 * todo
 */
object SimpleApp extends App with StatelessKieSessionSupport {

  override val sessionName  = "SimpleSession"

  val applicant: Applicant =  Applicant("jennifer",28,pass = false)
  ksession.execute(applicant)

  System.out.println(applicant.getPass)
}
