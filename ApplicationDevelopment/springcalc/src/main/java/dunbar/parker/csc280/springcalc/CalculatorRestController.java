package dunbar.parker.csc280.springcalc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorRestController {
	
	@RequestMapping("/add")
	public double add(@RequestParam Double x, @RequestParam Double y) {
		return x + y;
	}
	@RequestMapping("/subtract")
	public double subtract(@RequestParam Double x, @RequestParam Double y) {
		return x - y;
	}
	@RequestMapping("/multiply")
	public double multiply(@RequestParam Double x, @RequestParam Double y) {
		return x * y;
	}
	@RequestMapping("/divide")
	public double divide(@RequestParam Double x, @RequestParam Double y) {
		return x / y;
	}
}