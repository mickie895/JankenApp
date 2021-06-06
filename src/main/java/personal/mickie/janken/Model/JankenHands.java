package personal.mickie.janken.Model;

import java.util.ArrayList;
import java.util.List;

public enum JankenHands {
	ROCK("�O�[", 1),
	SCISSORS("�`���L",2),
	PAPER("�p�[",3);
	
	private String handName;
	private int handId;
	
	private JankenHands(String handName, int handId) {
		this.handName = handName;
		this.handId = handId;
	}
	
	public String getHandName() {
		return this.handName;
	}
	
	public int getHandId() {
		return this.handId;
	}
	
	public JankenResult getResult(JankenHands oppornentHand) {
		if (this.getHandId() == oppornentHand.getHandId()) {
			return JankenResult.Draw;
		}else if (this.getHandId() % 3 == (oppornentHand.getHandId() - 1) % 3) {
			return JankenResult.Win;
		}else {
			return JankenResult.Lose;
		}
	}
	
	public static final String[] getHandsName() {
		List<String> result = new ArrayList<String>();
		for (JankenHands hand : JankenHands.values()) {
			result.add(hand.getHandName());
		}
		return result.toArray(new String[result.size()]);
	}
	
	public static final JankenHands GetHandFromCode(int code) {
		for (JankenHands hand : JankenHands.values()) {
			if (hand.handId == code) {
				return hand;
			}
		}
		throw new IllegalArgumentException("����񂯂�̎��1�`3�܂ł̐��ł��肢���܂��B");
	}
	
}
