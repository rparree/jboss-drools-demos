package simple.model

import scala.beans.BeanProperty


/**
 * todo  
 */
case class Applicant(@BeanProperty var name: String,
                      @BeanProperty var age: Integer,
                      @BeanProperty var pass: Boolean = false) {

  def this() = this ("",0,false)
}
