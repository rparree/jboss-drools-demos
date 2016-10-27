package listeners

import java.util

import fire.{Fire, Room, Sprinkler}
import org.drools.compiler.testframework.RuleCoverageListener
import simple.util.StatefulKieSessionSupport

import scala.collection.JavaConverters._

/**
  * todo
  */
object RuleCoverage extends App with StatefulKieSessionSupport {

  override val sessionName: String = "BuildingSession"

  private val expected = Set("When there is a fire turn on Sprinkler", "Status output when things are ok").asJava
  private val ruleCoverage = new RuleCoverageListener(new util.HashSet(expected))
  ksession.addEventListener(ruleCoverage)

  val k = Room("kitchen")
  val s = Sprinkler(k)
  ksession.insert(k)
  ksession.insert(s)


  ksession.fireAllRules()

  private val c = ruleCoverage.getPercentCovered
  private val u = ruleCoverage.getUnfiredRules.map("[" + _ + "]") reduceLeft[String] (_ + ", " + _)

  println(s"coverage $c% (from expected) Unfired: $u")



}
