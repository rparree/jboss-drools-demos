package simple.util

import org.kie.api.builder.{Message, Results}
import org.kie.api.runtime.KieContainer

/**
 * todo
 */
object KieUtil {
  def checkErrors(container: KieContainer) = {
    val results: Results = container.verify
    val hasErrors = results.hasMessages(Message.Level.ERROR)
    if (hasErrors) {
      import scala.collection.JavaConversions._
      for (message <- results.getMessages) {
        
        throw new RuntimeException (s"At ${message.getLine} / ${message.getColumn} Path: ${message.getPath}| Message: ${message.toString} ")

      }
    }
    container
  }

}
