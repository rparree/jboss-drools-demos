package demo

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs._

import org.kie.api.cdi.KSession
import org.kie.api.runtime.StatelessKieSession
import simple.model.Applicant


/**
 * todo
 */
@Path("/simple")
class SimpleAppDemo {
  
  @Inject
  @KSession ("SimpleSession")
  var session : StatelessKieSession = _
  
  @POST
  @Produces(Array("text/plain"))
  @Consumes(Array(MediaType.APPLICATION_JSON))
  def check(a : Applicant) : String = {

    session.execute(a)
    a.pass.toString
  }

}
