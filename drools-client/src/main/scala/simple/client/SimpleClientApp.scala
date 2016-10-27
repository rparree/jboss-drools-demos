package simple.client

import org.kie.api.KieServices
import org.kie.api.runtime.manager.RuntimeEnvironmentBuilderFactory
import simple.model.Applicant

import scala.annotation.tailrec

/**
 * todo
 */
object SimpleClientApp extends App {

    private val services = KieServices.Factory.get
    private val releaseId = services.newReleaseId("com.edc4it",
      "drools-core-demos", "[1.0,2.0)")
    private val kieContainer = services.newKieContainer(releaseId)

    val kScanner = services.newKieScanner(kieContainer)
    kScanner.start(2000L)

    val kieSession = kieContainer.newStatelessKieSession("SimpleSession")

    @tailrec
    def check() {
      val (aName, aAge) = scala.io.StdIn.readf2("{0} {1,number}")
      val applicant = Applicant(name = aName.asInstanceOf[String], age = aAge.asInstanceOf[Long].toInt, pass = false)
      kieSession.execute(applicant)

      println(s"valid is ${applicant.pass}")
      check()
    }

    check()

}

