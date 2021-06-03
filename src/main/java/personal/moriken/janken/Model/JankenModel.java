package personal.moriken.janken.Model;

public class JankenModel {
	private String[] hands;

	public String[] getHands() {
		return hands;
	}

	private int cpuHand;
	
	public void setCpuHand(int handCode) {
		cpuHand = handCode;
	}
	
	public String getCpuHandName() {
		return hands[cpuHand];
	}
	
	public JankenModel() {
		hands = new String[] {"グー", "チョキ", "パー"};
	}
	
}
