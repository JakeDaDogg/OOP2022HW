
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author yuhanchiang
 * @version 2022/3/29
 *
 */

public class SentenceProcessor {
	/**
	 * sentence is for examination
	 * target is the word that would be replaced
	 * replacement is the word that will replace the target word
	 */
	String sentence;	
	String target;
	String replacement;
	String removeDuplicatedWords(String sentence) {
		/**
		 * str is the string to be returned
		 * @param sentence is input
		 * Generate a list that fills the requirement
		 * Writes the list back into a string for return
		 */
		String str = "";							// return this string
		this.sentence = sentence;					// Declare a sentence to be returned 
		String[] words = sentence.split("\\W+"); 	// Return a list of words in the sentence 
		List<String> list = new ArrayList<>();
		list.add("cap");							// Add a cap to prevent 
		for (int i = 0; i < words.length; i++ ) {	// Search in words 
	    	String current = words[i];
	    	boolean flag = false;					// if false than add
	    	for (int j = 0; j <  list.size(); j++ ) {	// Search in list to find match
	    		String current2 = list.get(j);			// Get element j from list
	    		flag = current.equals(current2);		// Check if equal
	    		if(flag == true) {
	    			break;
	    		}
	    		else {
	    		}
	    		}
    		if (flag == false) {
    			list.add(current);
    		}
	    	}
		list.remove(0);								// remove cap
		for (int i = 0; i < list.size(); i++) {
			if(i == list.size()-1 ) {
				str = str + list.get(i);			// Last item don't need white space
			}
			else {
				str = str + list.get(i) + " ";		// Other item need white space
			}
		}
		return str;
	}
	String replaceWord(String target, String replacement, String sentence) {
		/**
		 * newstr is the string to be returned
		 * Generate a list that fills the requirement
		 * Writes the list back into a string for return
		 */
		String newstr = "";
		this.sentence = sentence;					// use this to avoid ambiguity
		this.target = target;
		this.replacement = replacement;
		String[] words = sentence.split("\\W+"); 	// Return a list of words in the sentence 
		for (int i = 0; i < words.length; i++) {
			if ( words[i].equals(target) == true){
				words[i] = replacement;				// Replace the words here
			}
		}
		for (int j = 0; j < words.length; j++) {	// Write it back into string
			if(j == words.length-1 ) {
				newstr = newstr + words[j];			// Last item don't need white space
			}
			else {
				newstr = newstr + words[j]+" ";		// Other item need white space
			}
				
		}
		return newstr;
	}
}
// Yea you guys MIRIN! Come at us bro!
