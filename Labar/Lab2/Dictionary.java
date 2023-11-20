package lab2;
import java.util.*;
public class Dictionary {
	private ArrayList<Word> theList = new ArrayList<Word> ();
	private ArrayList<Word> backup = null;
	
	public Dictionary() {
		
	}
	
	public String addString(String arg) {
		
		
		for (int pass = 0; pass < theList.size(); ++pass) {
		
			if (arg.equals(theList.get(pass).getWord())) {
				 int temp = 1;
				 temp += theList.get(pass).getCount();
				 
				 
				 //theList.set(pass, new Word(arg, temp));
				 theList.remove(pass);
				 theList.add(pass, new Word(arg, temp));
				 return theList.get(pass).toString();			
			}			
		}		
		
		theList.add(new Word(arg, 1));
		
		return theList.get(theList.size()-1).toString();
		
	}
	
	public String sortList(int arg) {
		
		if (backup == null) {
			backup = new ArrayList<>();
			for (int pass = 0; pass < theList.size(); pass++) {
				
				String s = theList.get(pass).getWord();
				int a = theList.get(pass).getCount();
				
				backup.add(new Word(s, a));				
			} 
		}
		
		if (arg == Word.ORIGINAL) {			
			theList = backup;
			Word.setCriterion(Word.ORIGINAL);
			return "Word list was reset\n";
		}
		else if (arg == Word.BYNAME){
			Word.setCriterion(arg);
			for (int pass = 0; pass < theList.size()-1; ++pass) {
				for (int pass2 = pass + 1; pass2 < theList.size(); ++pass2) {
					if (theList.get(pass).compareTo(theList.get(pass2)) == -1) {
						Word temp = new Word(theList.get(pass2).getWord(), theList.get(pass2).getCount());
						theList.remove(pass2);
						theList.add(pass, temp);
						//String name = theList.get(pass).getWord();
						//int numb = theList.get(pass).getCount();
						//theList.set(pass, new Word(theList.get(pass2).getWord(), theList.get(pass2).getCount()));
						//theList.set(pass2, new Word(name, numb));
						
					}						
				}				
			}
			return "Sorted alphabetically\n";
		}
		else if (arg == Word.BYCOUNTS) {
			Word.setCriterion(arg);
			for (int pass = 0; pass < theList.size()-1; ++pass) {
				for (int pass2 = pass + 1; pass2 < theList.size(); ++pass2) {
					if (theList.get(pass).compareTo(theList.get(pass2)) == -1) {
						
						//Word temp2 = new Word(theList.get(pass2).getWord(), theList.get(pass2).getCount());
						//theList.remove(pass2);
						//theList.add(pass, temp2);
						
						String name = theList.get(pass).getWord();
						int numb = theList.get(pass).getCount();
						theList.set(pass, new Word(theList.get(pass2).getWord(), theList.get(pass2).getCount()));
						theList.set(pass2, new Word(name, numb));
						
					}						
				}				
			}
			return "Sorted by counts\n";
		}		
		return "Sort criterion not known\n";	
	}
	
	public String toString() {
		String result = "Content: \n";
		
		for (int pass = 0; pass < theList.size(); ++pass) {
			result += theList.get(pass).toString() + "\n";
		}		
		return result;
	}
}
