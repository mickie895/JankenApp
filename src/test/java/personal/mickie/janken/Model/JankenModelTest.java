package personal.mickie.janken.Model;

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
		// �O�[�F1�A�`���L:2�A�p�[:3�Ƃ��Ď�������
		model.setCpuHand(1);
		assertEquals(model.getCpuHandName(), ROCK);
		model.setCpuHand(2);
		assertEquals(model.getCpuHandName(), SCISSORS);
		model.setCpuHand(3);
		assertEquals(model.getCpuHandName(), PAPER);
	}
	
	@Test
	void testHandStrength() {
		// CPU���O�[���o���Ă����ԂŁA
		model.setCpuHand(JankenHands.ROCK);
		
		// �v���C���[���p�[���o���Ă���Ώ���
		JankenHands playerHand = JankenHands.PAPER;
		assertEquals(model.CheckResult(playerHand), JankenResult.Win);
		
		// �v���C���[���O�[�Ȃ��������
		playerHand = JankenHands.ROCK;
		assertEquals(model.CheckResult(playerHand), JankenResult.Draw);
		
		// �v���C���[���`���L�Ȃ畉��
		playerHand = JankenHands.SCISSORS;
		assertEquals(model.CheckResult(playerHand), JankenResult.Lose);
		
		// ��L�g�ݍ��킹�ő���Ă��Ȃ���̑g�ݍ��킹������
		model.setCpuHand(JankenHands.PAPER);
		assertEquals(model.CheckResult(playerHand), JankenResult.Win);
		
		// CPU�ƃv���C���[�ŋt�̎���o�����珟���������t�ɂȂ�B(���������������ȊO)
		playerHand = JankenHands.ROCK;
		assertEquals(model.CheckResult(playerHand), JankenResult.Lose);
	}
}
