package dunbar.parker.csc280.hellospring;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class Calculator {

	//Can't send a request body on a GET method
	@CrossOrigin(origins = "http://localhost:9090")
	@RequestMapping(path="/add", method=RequestMethod.GET)
	public double add(
					@RequestParam(value = "x", required=true) Double x, 
					@RequestParam(value = "y", required=true) Double y) {
		return x + y;
	}
}