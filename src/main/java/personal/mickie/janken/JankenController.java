package personal.mickie.janken;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import personal.mickie.janken.Model.JankenHands;
import personal.mickie.janken.Model.JankenModel;
import personal.mickie.janken.Model.JankenResult;

@Controller
public class JankenController {
	
@GetMapping(value="/start")
	public String startPage() {
		return "index";
	}

@PostMapping("/result")
	public String postHand(@RequestParam("hand") int hand_code, Model model) {
		JankenModel cpu = new JankenModel();
		JankenHands player = JankenHands.GetHandFromCode(hand_code);
		
		cpu.setCpuHand();
		
		JankenResult result = cpu.checkResult(player);
	
		model.addAttribute("cpu", cpu.getCpuHandName());
		model.addAttribute("player", player.getHandName());
		model.addAttribute("result", result.toString());
		
		return "start/result.html";
	}
	
}
