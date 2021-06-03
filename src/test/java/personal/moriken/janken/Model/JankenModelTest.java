package personal.moriken.janken.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class JankenModelTest {

	private JankenModel model;
	private final String ROCK = "グー";
	private final String SCISSORS = "チョキ";
	private final String PAPER = "パー";
	
	@BeforeEach
	void SetUp() {
		model = new JankenModel();
	}
	
	@Test
	void testHandList() {
		// じゃんけんの手は3つ
		assertEquals(model.getHands().length, 3);
		// グー、チョキ、パーが含まれる
		assertTrue(Arrays.asList(model.getHands()).contains(ROCK));
		assertTrue(Arrays.asList(model.getHands()).contains(PAPER));
		assertTrue(Arrays.asList(model.getHands()).contains(SCISSORS));	
	}
	
	@Test
	void testSetHand(){
		// グー：0、チョキ:1、パー:2として実装する
		model.setCpuHand(0);
		assertEquals(model.getCpuHandName(), ROCK);
		model.setCpuHand(1);
		assertEquals(model.getCpuHandName(), SCISSORS);
		model.setCpuHand(2);
		assertEquals(model.getCpuHandName(), PAPER);
	}
	
	@Test
	void testHandStrength() {
		
	}
}
