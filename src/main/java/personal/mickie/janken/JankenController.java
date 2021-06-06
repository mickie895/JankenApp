package personal.mickie.janken;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JankenController {

@RequestMapping(value="/hello")
	private String hello(){
		return "/index.html";
	}
}
