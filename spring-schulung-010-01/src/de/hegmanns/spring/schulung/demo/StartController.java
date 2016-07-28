package de.hegmanns.spring.schulung.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StartController {

	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hallo Welt</h3>Eine Nachricht vom StartController.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
}
