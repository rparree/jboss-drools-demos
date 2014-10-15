package reactive

import org.kie.api.definition.`type`.PropertyReactive

import scala.beans.BeanProperty

/**
 * todo
 */
@PropertyReactive 
case class Pet(@BeanProperty var name: String, 
               @BeanProperty var kind   : PetType.Value ) {

}
