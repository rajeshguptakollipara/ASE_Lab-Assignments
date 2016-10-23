/**
 * @author ry6d3
 *
 */
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/mltokms")
public class FtoCService {
 
	  @GET
	  @Produces("application/json")
	  public Response convertFtoC() throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double kms = 98.24;
		Double ml;
		ml = (kms)*1.60934; 
		jsonObject.put("F Value", kms); 
		jsonObject.put("C Value", ml);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFtoCfromInput(@PathParam("f") float f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		Double ml;
		ml =  (f)*1.60934; 
		jsonObject.put("miles Value", f); 
		jsonObject.put(" kms Value", ml);
 
		String result = "@Produces(\"application/json\") Output: \n\nmiles to kilometers Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
  
	  public  long mlTokms(long ml){
		  
		  long km= (long) (ml*1.60934);
		 return km;  
		  
		  
	  }
	  
}