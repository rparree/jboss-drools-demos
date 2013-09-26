package dsl

import scala.beans.BeanProperty

/**
 * todo  
 */
case class Customer(@BeanProperty var loyaltyLevel: String) {

}

case class Reservation(@BeanProperty var classUpgrade: Boolean=false)
