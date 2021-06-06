package personal.moriken.janken.Model;

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
		if (cpuHand.getHandId() == playerHand.getHandId()) {
			return JankenResult.Draw;
		}
		if (cpuHand.getHandId() % 3 == (playerHand.getHandId() + 1) % 3) {
			return JankenResult.Win;
		}
		return JankenResult.Lose;
	}
	
	public JankenModel() {
		cpuHand = null;
	}
	
}
