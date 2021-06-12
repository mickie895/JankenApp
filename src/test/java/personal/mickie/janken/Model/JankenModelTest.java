package personal.mickie.janken.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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
		// グー：1、チョキ:2、パー:3として実装する
		model.setCpuHand(1);
		assertEquals(model.getCpuHandName(), ROCK);
		model.setCpuHand(2);
		assertEquals(model.getCpuHandName(), SCISSORS);
		model.setCpuHand(3);
		assertEquals(model.getCpuHandName(), PAPER);
		try {
			model.setCpuHand(0);
			fail();
		} catch (Exception e) {
			// 例外発生が正しい
		}
		try {
			model.setCpuHand(4);
			fail();
		} catch (Exception e) {
			// 例外発生が正しい
		}
	}
	
	@Test
	void testHandStrength() {
		// CPUがグーを出している状態で、
		model.setCpuHand(JankenHands.ROCK);
		
		// プレイヤーがパーを出していれば勝ち
		JankenHands playerHand = JankenHands.PAPER;
		assertEquals(model.checkResult(playerHand), JankenResult.Win);
		
		// プレイヤーもグーなら引き分け
		playerHand = JankenHands.ROCK;
		assertEquals(model.checkResult(playerHand), JankenResult.Draw);
		
		// プレイヤーがチョキなら負け
		playerHand = JankenHands.SCISSORS;
		assertEquals(model.checkResult(playerHand), JankenResult.Lose);
		
		// 上記組み合わせで足りていない手の組み合わせを実装
		model.setCpuHand(JankenHands.PAPER);
		assertEquals(model.checkResult(playerHand), JankenResult.Win);
		
		// CPUとプレイヤーで逆の手を出したら勝ち負けも逆になる。(ただし引き分け以外)
		playerHand = JankenHands.ROCK;
		assertEquals(model.checkResult(playerHand), JankenResult.Lose);
	}
	
	@Test
	void testRandomHand() {
		boolean rockAppeared = false;
		boolean paperAppeared = false;
		boolean scissorsAppeared = false;
		
		for (int i = 0; i < 1000; i++) {
			model.setCpuHand();
			switch (model.getCpuHandName()){
			case ROCK:
				rockAppeared = true;
				break;
			case PAPER:
				paperAppeared = true;
				break;
			case SCISSORS:
				scissorsAppeared = true;
				break;
			default:
				fail();	
			}
		}
		
		// 100回も回せば全部の手がでると思う。
		assertTrue(rockAppeared);
		assertTrue(paperAppeared);
		assertTrue(scissorsAppeared);
	}
}
