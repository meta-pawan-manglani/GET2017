import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * The Class MyService.
 * 
 * @author Pawan Manglani
 * @version 1.1 16-Aug-2017
 */
@WebService
public class MyService {
 
 
 /**
  * Converter.
  *
  * @param fahrenheit the fahrenheit
  * @return the celcius equivalent of given farenheit value
  */
 @WebMethod
 public double converter(double fahrenheit){
	 double celcius = 0;
	 celcius =  ((( fahrenheit - 32 ) * 5)/9);
	 return celcius;
 }
}
