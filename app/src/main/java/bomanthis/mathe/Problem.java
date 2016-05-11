package bomanthis.mathe;
//Problem Class. A class with a question and an answer.

public class Problem{
	
	private String question;
	private String[] answers;
	private int level;
	private int index = 0;
	
	//Constructors
	
	public Problem(){
		question = "";
		answers = new String[5];
		level = 1;
		createQuestion();
	}
	
	public Problem(int l){
		question = "";
		answers = new String[5];
		level = l;
		createQuestion();
	}
	
	public Problem(String q, String[] a, int l){
		question = q;
		answers = new String[5];
		for(int i = 0; i < 5; i++){
			answers[i] = a[i];
		}
		level = l;
	}
	
	//Methods
	
	public void createQuestion(){
		Questions q;
		switch (level) {
			case 1: q = new LevelTwoQuestion();
				break;
			case 2: q = new LevelThreeQuestion();
				break;
			case 3: q = new LevelFourQuestion();
				break;
			//case 4: q = new LevelFiveQuestion();
				//break;
			default: q = new LevelOneQuestion();
				break;
		}
		question = q.getQuestion();
		index = (int)(Math.random()*5);
		for(int i = 0; i < 5; i++){
			if(i == index)
				answers[i] = q.getRightAnswer();
			else
				answers[i] = q.getWrongAnswer();
		}
	}
	
	//Modifying Methods
	
	public void setQuestion(String q){
		question = q;
	}
	
	public void setAnswers(String[] a){
		for(int i = 0; i < 5; i++){
			answers[i] = a[i];
		}
	}
	
	public void setLevel(int l){
		level = l;
		Questions q;
		switch (level) {
			case 1: q = new LevelTwoQuestion();
				break;
			case 2: q = new LevelThreeQuestion();
				break;
			case 3: q = new LevelFourQuestion();
				break;
			//case 4: q = new LevelFiveQuestion();
				//break;
			default: q = new LevelOneQuestion();
				break;
		}
		question = q.getQuestion();
		index = (int)(Math.random()*5);
		for(int i = 0; i < 5; i++){
			if(i == index)
				answers[i] = q.getRightAnswer();
			else
				answers[i] = q.getWrongAnswer();
		}
	}
	
	//Accessor Methods
	
	public String getQuestion(){ return question; }
	
	public String[] getAnswers(){ return answers; }
	
	public int getLevel(){ return level; }
	
	public int getRightAnswerIndex(){ return index; }
	
}