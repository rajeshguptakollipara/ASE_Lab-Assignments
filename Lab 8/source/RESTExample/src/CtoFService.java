/**
 * @author ry6d3
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/kmtoml")
public class CtoFService {
	@GET
	@Produces("application/xml")
	public String convertCtoF() {
 
		//Double ml;
		Double ml = 36.8;
		ml = 0.621371*ml;
 
		String result = "@Produces(\"application/xml\") Output: \n\nml to ml Converter Output: \n\n" + ml;
		return "<ctofservice>" + "<ml>" + ml + "</ml>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCtoFfromInput(@PathParam("c") Double c) {
		Double ml;
		Double km = c;
		ml = km*0.621371;
 
		String result = "@Produces(\"application/xml\") Output: \n\nkilometers to miles Converter Output: \n\n" + ml;
		return "<kmtomlservice>" + "<km>" + km + "</km>" + "<kmtomloutput>" + result + "</kmtomloutput>" + "</kmtomlservice>";
	}
	public  long mlTokm(long ml){
		  
		  long km= (long) (ml*0.621371);
		 return km;  
		  
		  
	  }
}