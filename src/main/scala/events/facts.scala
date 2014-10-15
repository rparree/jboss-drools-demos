package events

import scala.beans.BeanProperty

class Fire

case class Sprinkler(@BeanProperty var on: Boolean = false)
