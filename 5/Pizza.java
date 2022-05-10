
/**
 * 
 * @author yuhanchiang
 * @version 2022/3/30
 */
public class Pizza {
	/**
	 * @param size(str) is the size of pizza: private
	 * @param NumberofCheese(int) is the # of cheese: private
	 * @param NumberofPepperoni(int): private
	 * @param NumberofHam(int): private
	 * public method calcCost: calculate overall price
	 * public methods ot set all the variables
	 * overload method: equals(): determine if one pizza is totally equal to another
	 * override method: toString(); returns format of pizza
	 */

	private String size;
	private int NumberofCheese;
	private int NumberofPepperoni;
	private int NumberofHam;
	// default constructor
	Pizza(){ 
		this.size = "small";
		this.NumberofCheese = 1;
		this.NumberofPepperoni = 1;
		this.NumberofHam = 1;
	};
	// regular constructor
	Pizza(String size, int NumberofCheese, int NumberofPepperoni, int NumberofHam){
		this.size = size;
		this.NumberofCheese = NumberofCheese;
		this.NumberofPepperoni = NumberofPepperoni;
		this.NumberofHam = NumberofHam;
	}
	// Methods
	public String getSize() {return size;}
	public int getNumberOfCheese() { return NumberofCheese;}
	public int getNumberOfPepperoni() { return NumberofPepperoni;}
	public int getNumberOfHam() { return NumberofHam;}
	public String setSize(String size) { this.size = size; return size;}
	public int setNumberOfCheese(int NumberofCheese) { this.NumberofCheese = NumberofCheese; return NumberofCheese; }
	public int setNumberOfPepperoni(int NumberofPepperoni) { this.NumberofPepperoni = NumberofPepperoni; return  NumberofPepperoni;}
	public int setNumberOfHam(int NumberofHam) { this.NumberofHam = NumberofHam; return NumberofHam; }
	public double calcCost() {
		/**
		 * @param sizeMoney ( local variable ) : conversion between money and size
		 * @param toppingSum ( local variable ): calculate all the topping money
		 * @return money of pizza
		 */
		double sizeMoney;
		double toppingSum;
		if(size == "small") {
			sizeMoney = 10d;
		} else if(size == "medium") {
			sizeMoney = 12d;
		} else {
			sizeMoney = 14d;
		}
		toppingSum = Double.valueOf( NumberofCheese + NumberofPepperoni + NumberofHam );
		return sizeMoney+2*toppingSum;
	}
	public String toString() {
		/**
		 * @return Output all the items in a string format
		 */
		return "size = "+size+", numOfCheese = "+NumberofCheese+", numOfPepperoni = "+NumberofPepperoni+", numOfHam = "+NumberofHam;
	}
	public boolean equals(Pizza pizza2) {
		/**
		 * @param flag ( local ) : true or false, and return this if pizza is equal
		 */
		boolean flag = false;
		if( (this.size == pizza2.size && this.NumberofCheese == pizza2.NumberofCheese && this.NumberofHam == pizza2.NumberofHam && this.NumberofPepperoni == pizza2.NumberofPepperoni)== true) {
			flag = true;
		}
		return flag;
	}
}
// That's it, You're MIRIN'
