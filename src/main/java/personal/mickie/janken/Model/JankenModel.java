package personal.mickie.janken.Model;

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
	
	public String getCpuHandName() {
		return cpuHand.getHandName();
	}
	
	public JankenResult CheckResult(JankenHands playerHand) {
		return playerHand.getResult(cpuHand);
	}
	
	public JankenModel() {
		cpuHand = null;
	}
	
}
