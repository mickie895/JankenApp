package personal.mickie.janken.Model;


public enum JankenResult{
	Win, Draw, Lose;
	
	@Override
	public String toString() {

		switch (this){
		case Win:
			return "かち";
		case Draw:
			return "ひきわけ";
		case Lose:
			return "まけ";
		}
		
		return super.toString();
	}
}
