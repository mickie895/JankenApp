package personal.moriken.janken.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class JankenModelTest {

	private JankenModel model;
	private final String ROCK = "�O�[";
	private final String SCISSORS = "�`���L";
	private final String PAPER = "�p�[";
	
	@BeforeEach
	void SetUp() {
		model = new JankenModel();
	}
	
	@Test
	void testHandList() {
		// ����񂯂�̎��3��
		assertEquals(model.getHands().length, 3);
		// �O�[�A�`���L�A�p�[���܂܂��
		assertTrue(Arrays.asList(model.getHands()).contains(ROCK));
		assertTrue(Arrays.asList(model.getHands()).contains(PAPER));
		assertTrue(Arrays.asList(model.getHands()).contains(SCISSORS));	
	}
	
	@Test
	void testSetHand(){
		// �O�[�F0�A�`���L:1�A�p�[:2�Ƃ��Ď�������
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
