
/**
 * 
 * @author yuhanchiang
 * @version 2022/3/31
 */
public class PizzaOrder {
	/**
	 * @param cost1,2,3: the costs of the first three pizzas;
	 * @param invoke1,2,3: flow control mechanisms;
	 * @method: boolean setNumberPizzas: accepts order of pizza in ranges 1 to 3, returns t/f;
	 * @method: int setPizza1,2,3: stores cost of pizza, and cascades the invoke control;
	 * @method: calcTotal: calculates total cost
	 */
	private double cost1 = 0d;
	private double cost2 = 0d;
	private double cost3 = 0d;
	private boolean invoke1 = false;
	private boolean invoke2 = false;
	private boolean invoke3 = false;
	public boolean setNumberPizzas( int pizzas ) {
		if ( pizzas > 1 && pizzas < 3 ) {
			invoke1 = true;
		}
		return invoke1;
	}
	public void setPizza1( Pizza pizza1 ){
		if ( invoke1 == false ) {
			return;							// breaks method if not invoked order1
		}
		else {
			cost1 = pizza1.calcCost();		// stores cost of pizza 1
			invoke2 = true;
		}	
	}
	public void setPizza2( Pizza pizza2 ){
		if ( invoke2 == false ) {			// breaks method if not invoked order2
			return;		
		}
		else {
			cost2 = pizza2.calcCost();
			invoke3 = true;
		}	
	}
	public void setPizza3( Pizza pizza3 ){
		if ( invoke3 == false ) {
			return;
		}
		else {
			cost3 = pizza3.calcCost();
		}	
	}
	public double calcTotal(){
		return cost1 + cost2 + cost3;
		
	}
	

}
// You're listening to the best radio station ...