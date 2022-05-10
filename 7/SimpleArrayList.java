
/**
 * 
 * @author yuhanchiang
 * @version 2022/4/13
 *
 */
public class SimpleArrayList {
	public Integer arr[]; // array
	public int len; 
	// default constructor
	SimpleArrayList(){
		this.arr = new Integer[0];  // set a new int array to arr
		this.len = arr.length;
	}
	// constructor
	SimpleArrayList(int length){
		this.arr = new Integer[length];
		for (int i = 0; i < length; i++) {
			this.arr[i] = 0;
		}
		this.len = arr.length;
	}
	// add an element to array
	public void add(Integer i) {
 		Integer[] newarr = new Integer[this.len+1]; // declare a new array
 		// copy elements to new array
 		if (this.len == 0) {		// if length is zero, the loop will not be executed
 			newarr[0] = i;	// copy first element
 			arr = newarr;
 			this.len = 1;	// set this length to one
 		} else {			// if length is not zero, run this block
 			for (int j = 0; j < this.len; j++) {  
 				newarr[j] = this.arr[j];
 			}
 			newarr[len] = i; // append the last object to new array
 			arr = newarr; // direct the new array to the original array
 		this.len+=1;	
 		}
		// Question: is it a lot of waste in the memory to do this? No memory whiped?
	}
	// retrieve an element for a given index
	public Integer get(int index) {
		Integer element;
		if (index >= this.len) {
			element = (Integer) null; // Question: Add cast?
		}else {
			element = arr[index];
		}
		return (Integer)element;
	}
	// set
	public Integer set(int index, Integer replacement) {
		Integer original;
		if (index >= this.len) {
			original = (Integer) null; // Question: Add cast?
		}else {
			Integer dummy; // create a dummy variable
			dummy = arr[index]; // dummy = original element
			arr[index] = replacement;
			original = dummy;
		}
		return original;
	}
	// remove an element
	public boolean remove(int index) {
		boolean flag = false;
		Integer[] newarr = new Integer[this.len-1];		// new array with index-1
		if ( arr[index] == (Integer)null ) {
			flag = false;
		} else {
			flag = true;
			// Old index = New index = i
			for(int i = 0; i < index; i++) {	// copy element before removed item
				newarr[i] = this.arr[i];
			}
			// Old index = i, New index = i+1 = j
			for(int i = index; i < this.len-1; i++ ) { // copy element before removed
				int j = i+1;	
				newarr[i] = this.arr[j];
			}
			this.arr = newarr;	
			this.len --;
		}
		return flag;
	}
	// clear the whole array
	public void clear() {
		Integer[] newarr = new Integer[0];
		this.arr = newarr;
		this.len = 0;
	}
	// return the size of array
	public int size() {
		int size = this.len;
		return size;
	}
	// retain all elements in array
	public boolean retainAll(SimpleArrayList l) {
		boolean flag = false; // return the flag, true: altered, false, not altered
		int[] toBeRemoved = new int[0];		// array of indexes to be removed
		// List indexes to be removed
		for ( int i = 0; i < this.len; i++) {				// index to be removed 
			boolean found = false; 							// false: didn't found, remove element 
			// search to be removed
			for (int j = 0; j < l.len; j++) { 
				if (this.arr[i] == l.get(j)) {
					found = true; 							// if found = true, do not removed
					break; // if found then break inner searching loop
				} else {} 
			}
			// if found = false : add item in to be removed
			if (found == false) { 
				int[] dummy = new int[toBeRemoved.length+1]; // one element more
				if (toBeRemoved.length == 0) {
					dummy[0] = i;	// Assign first item to dummy
				} else {
					// copy previous elements to dummy
					for (int j = 0; j < toBeRemoved.length; j++) {		
						dummy[j] = toBeRemoved[j];
					}
					dummy[toBeRemoved.length] = i; 	// Assign newest index to dummy
				}
				toBeRemoved = dummy;		// Assign dummy to toBeRemovednh
			}
		}
		// remove items  this part has problems!
		if (toBeRemoved.length != 0) {		// if there is something to be removed, execute this block
			for (int i = 0; i < toBeRemoved.length; i++) {
				Integer[] newarr = new Integer[this.len-1];		// should this be in the block? Yes!
				int index = toBeRemoved[i];	// the index to be removed
				for(int j = 0; j < index; j++) {	// copy element before removed index
					newarr[j] = this.arr[j];
				}
				for(int j = index; j < this.len-1; j++ ) { // copy element before removed index
					int k = j+1;	
					newarr[j] = this.arr[k];
				}
				this.arr = newarr;			// copy new array to original array
				this.len --;
				// shift the index to be removed by 1
				for (int j = 0; j < toBeRemoved.length; j++) {
					toBeRemoved[j] = toBeRemoved[j] -1 ; // shift indexes by 1 because index changes every iteration
				}
			}
			flag = true;
		} else {
			// or else, don't remove anything
		}
 		return flag;
	}

}
