package dsl

import scala.beans.BeanProperty

/**
 * todo  
 */

case class Member( @BeanProperty var loyaltyLevel: String) {

}

case class Reservation(@BeanProperty var classUpgrade: Boolean=false)

case class Miles(@BeanProperty var amount : Double)