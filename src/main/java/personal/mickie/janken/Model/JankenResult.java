package personal.mickie.janken.Model;


public enum JankenResult{
	Win, Draw, Lose;
	
	@Override
	public String toString() {

		switch (this){
		case Win:
			return "����";
		case Draw:
			return "�Ђ��킯";
		case Lose:
			return "�܂�";
		}
		
		return super.toString();
	}
}
