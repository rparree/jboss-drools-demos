package fire

import scala.beans.BeanProperty

/**
 * todo  
 */
case class Room(@BeanProperty var name: String) {

}

case class Sprinkler(@BeanProperty var room: Room,
                     @BeanProperty var on: Boolean = false)

case class Fire (@BeanProperty var room: Room)

class Alarm
