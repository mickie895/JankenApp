package personal.mickie.janken.Model;

import java.util.Random;

public class JankenModel {

	public String[] getHands() {
		String[] result =  JankenHands.getHandsName();
		return result;
	}

	private JankenHands cpuHand;
	
	public void setCpuHand(int handCode) {
		setCpuHand(JankenHands.GetHandFromCode(handCode));
	}
	
	public void setCpuHand(JankenHands hand) {
		cpuHand = hand;
	}
	
	public void setCpuHand() {
		Random rand = new Random();
		setCpuHand(rand.nextInt(3) + 1);
	}
	
	public String getCpuHandName() {
		return cpuHand.getHandName();
	}
	
	public JankenResult checkResult(JankenHands playerHand) {
		return playerHand.getResult(cpuHand);
	}
	
	public JankenModel() {
		cpuHand = null;
	}
	
}
