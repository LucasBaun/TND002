package lab2;

public class Word {
	public static final int ORIGINAL = 0; 
	public static final int BYNAME = 1; 
	public static final int BYCOUNTS = 2;
	
	private String theWord;
	private int count;
	private static int sortCriterion = ORIGINAL;
	
	public Word(String theWord, int count) {
		this.theWord = theWord;
		this.count = count;		
		
	}
	
	public int getCount() {		
		int result = count;
		return result;
	}
	
	public String getWord() {
		String result = theWord;
		return result;
	}
	
	public static void setCriterion(int arg) {
		 sortCriterion = arg;
	}
	
	public int compareTo(Word arg) {
		int result;
		
		if(sortCriterion == ORIGINAL) {
			result = 2;
		}
		else if () {
			
		}
		
		return result;
	}

}
