package dsl

import org.drools.builder.{ResourceType, KnowledgeBuilderFactory}
import org.drools.io.ResourceFactory
import org.drools.{FactHandle, KnowledgeBaseFactory}
import scala.collection.JavaConversions._

/**
 * todo  
 */
object DSLApp extends App {
  val kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder
  kbuilder.add(ResourceFactory.newClassPathResource("dsl/sample.dsl"), ResourceType.DSL)
  kbuilder.add(ResourceFactory.newClassPathResource("dsl/sample.dslr"), ResourceType.DSLR)


  if (kbuilder.hasErrors) {
    System.err.println(kbuilder.getErrors.toString)
  }

  //Initialise new session
  val kbase = KnowledgeBaseFactory.newKnowledgeBase
  kbase.addKnowledgePackages(kbuilder.getKnowledgePackages)
  val ksession = kbase.newStatefulKnowledgeSession()

  val customer = new Customer("Gold")


  val r = new Reservation(classUpgrade = true)


  ksession.insert(customer)
  ksession.insert(r)
  ksession.fireAllRules()

  val handles = ksession.getFactHandles[FactHandle]()
  handles.map(h => ksession.getObject(h)).foreach(println _)
  

  ksession.dispose()






}
