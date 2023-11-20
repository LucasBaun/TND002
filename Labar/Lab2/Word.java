package lab2;

public class Word {
	
	public static final int ORIGINAL = 0; 
	public static final int BYNAME = 1; 
	public static final int BYCOUNTS = 2;
	
	private String theWord;
	private int count;
	private static int sortCriterion = ORIGINAL;
	
	
	public Word(String arg1, int arg2) {
		theWord = arg1;
		count = arg2;	
		
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
	
	public String toString() {
		String result;
		
		result = String.format("Word:%10s, Count:%3d", theWord, count);
		
		return result;
	}
	
	public int compareTo(Word arg) {	
		int result = 0;		
		if(sortCriterion == ORIGINAL) {
			result = 2;
		}		
		else if (sortCriterion == BYNAME) {
			if (theWord.compareTo(arg.theWord) > 0) {
				result = 1;
			}
			else if (theWord.compareTo(arg.theWord) == 0) {
				result = 0;
			}
			else {
				result = -1;
			}					
		}
		
		else if (sortCriterion == BYCOUNTS) {
			if (count < arg.count) {
				result = -1;
			}
			else if (count == arg.count) {
				result = 0;
			}
			else {
				result = 1;
			}
		}		
		return result;
	}
	

}
