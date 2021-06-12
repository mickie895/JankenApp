package personal.mickie.janken.Model;


public enum JankenResult{
	Win, Draw, Lose;
	
	@Override
	public String toString() {

		switch (this){
		case Win:
			return "‚©‚¿";
		case Draw:
			return "‚Ð‚«‚í‚¯";
		case Lose:
			return "‚Ü‚¯";
		}
		
		return super.toString();
	}
}
