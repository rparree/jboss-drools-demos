package simple.util

import org.kie.api.KieServices
import org.kie.api.runtime.KieContainer

/**
 * todo
 */
trait KieContainerSupport {
  lazy val container: KieContainer = {
    val kieServices: KieServices = KieServices.Factory.get
    val kieContainer = kieServices.getKieClasspathContainer
    KieUtil.checkErrors(kieContainer)
  }

}
