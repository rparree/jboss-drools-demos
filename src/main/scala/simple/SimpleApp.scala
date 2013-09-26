package simple

import org.drools.builder.{ResourceType, KnowledgeBuilder, KnowledgeBuilderFactory}
import org.drools.io.ResourceFactory
import org.drools.{KnowledgeBaseFactory, KnowledgeBase}
import org.drools.runtime.StatelessKnowledgeSession
import simple.model.Applicant

/**
 * todo  
 */
object SimpleApp  extends  App {
  val kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder
  kbuilder.add(ResourceFactory.newClassPathResource(
    "simple/simple.drl"), ResourceType.DRL)


  if (kbuilder.hasErrors) {
    System.err.println(kbuilder.getErrors.toString)
  }

  //Initialise new session
  val kbase = KnowledgeBaseFactory.newKnowledgeBase
  kbase.addKnowledgePackages(kbuilder.getKnowledgePackages)
  val ksession = kbase.newStatelessKnowledgeSession

  //Create terms and execute
  val applicant = Applicant("Mr John Smith", 16, pass = true)
  println(applicant.pass)
  ksession.execute(applicant)

  // State changed after rules executed
  println(applicant.pass)

}
