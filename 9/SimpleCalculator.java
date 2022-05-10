
/**
 * 
 * @author yuhanchiang
 * @version 2022/5/07
 */
public class SimpleCalculator {
	private double result = 0.0;
	private int count = 0;
	private boolean finalflag = false; 		// determines final output message
	private String op = null;				// operator
	private String white = null;			// white space 
	private String num = null;				// number
	private boolean opFlag = true;			// opFlag: determine if operator is valid, guess it is true first
	private boolean valFlag = true;			// valFlag: determine if value is valid, guess it is true first
	private boolean whiteFlag = true;		// determine if there is white space
	private boolean div0Flag = false;		// determine if divide by zero
	private boolean validFlag = true;		// determine if it is valid to be calculated

	public String getMsg() {
		String str = null;
		// rounding decimals:
		String output = String.format("%.2f", this.result);
		double doubleNum = 0.0;
		try {
			doubleNum = Double.parseDouble(this.num);
		}
		catch(Exception e) {
			
		}
		String outputNum = String.format("%.2f", doubleNum);
		
		if(count == 0 && this.validFlag == true) { // first round of str
			str = "Calculator is on. Result = " + output;
			count += 1;
		}
		else if(count ==1 && this.validFlag == true){
			// return result format
			str = "Result " + this.op + " " + outputNum + " = " + output + ". New result = " + output;
			count+=1;
		}
		else if(count > 1 && this.validFlag == true){
			// return result format
			str = "Result " + this.op + " " + outputNum + " = " + output + ". Updated result = " + output;
			count+=1;
		}
		
		// determine if it is final result
		if(this.finalflag == true){ 		// there are some problems here
			// return result format
			str = "Final result = " + output;
		} 
		return str;
	}
	public void calResult(String cmd) throws UnknownCmdException {
		// reset all flags for current iteration
		this.opFlag = true;	
		this.valFlag = true;	
		this.whiteFlag = true;
		this.validFlag = true;
		this.div0Flag = false;
		// reset error cases and error messages
		int errcase = 0;
		String errstr = null;
		// try to slice string 
		try {
		this.op = cmd.substring(0,1);		// first should be operator
		this.white = cmd.substring(1,2);	// second should be white
		this.num = cmd.substring(2);		// third should be number, without limited length
		}
		catch(Exception e) {
			this.whiteFlag = false;
		}
		// Check first if the calculation will end
		// there is a bug here, why this line didn't execute in the last iteration?
		//
		double locnum = 0.0;
		// determine if num is a double
		try {
		locnum = Double.parseDouble(num);
		}
		// handles exception
		catch(Exception e) {
			this.valFlag = false;		// false: num is not a double
			this.validFlag = false;
			// check if the last argument contains any items in the following array
			String[] arr = {"+", "-", "*", "/", " "};
			// check validity
			for ( int i = 0; i < this.num.length(); i++) {
				String dummy = Character.toString(this.num.charAt(i));
				for (int j = 0; j < arr.length; j++) {
					if (dummy.equals(arr[j])){
						this.whiteFlag = false;		// there is either an operator, or there is white space
						break;
					}
				}
			}
		}
		// check white space
		if (this.white.equals(" ") == true) {		// no white space
		} else {
			this.whiteFlag = false;
		}
		// Check operator
		String[] ops = {"+", "-", "*", "/", " "};
		boolean match = false;
		for ( int i = 0; i < 5; i++) {
			if (this.op.equals(ops[i])) {
				match = true;				// if there is a match, op is valid
				break;	
			}
		}
		if (match == false) {
			this.opFlag = false;		//operator is not + - * /
			this.validFlag = false;		// cannot be calculated
		}
		
		
		if(this.op.equals("+") && this.validFlag == true) {		// calculate only if both are true
			this.result +=  locnum;
			
			

		} else if(this.op.equals("-") && this.validFlag == true) {
			this.result -=  locnum;
			
			

		} else if(this.op.equals("*") && this.validFlag == true) {
			this.result *=  locnum;
			
			

		} else if(this.op.equals("/") && this.validFlag == true){
			if (locnum != 0.0) {
				this.result /= locnum;		
			} else {
				this.div0Flag = true;	// divide by zero is true
			}		
		} 
		// throws errors
		if (this.opFlag == false && this.valFlag == true ) {	// value valid, op invalid
			errcase = 1;
			
		} 
		if (this.valFlag == false && this.opFlag == true) {		// op valid, value invalid
			//errstr = this.num + " is an unknown value";
			errcase = 2;
			
		}
		if (this.valFlag == false && this.opFlag == false ) {	// op and value both invlaid
			errcase = 3;
			//errstr = this.op + " is an unknown operator and " + this.num + " is an unknown value";
			
		} 
		if (this.whiteFlag == false) {							// no white space
			//errstr = "Please enter 1 operator and 1 value separated by 1 space"; 
			errcase = 4;
			
		}
		if (this.div0Flag == true) {
			errcase = 5;
			
		}
		// switch 
		switch(errcase) {
		case 1:
			errstr = this.op + " is an unknown operator";
			throw new UnknownCmdException(errstr);
		case 2: 
			errstr = this.num + " is an unknown value";
			throw new UnknownCmdException(errstr);
			
		case 3:
			errstr = this.op + " is an unknown operator and " + this.num + " is an unknown value";
			throw new UnknownCmdException(errstr);
			
		case 4:
			errstr = "Please enter 1 operator and 1 value separated by 1 space";
			throw new UnknownCmdException(errstr);
		case 5:
			errstr = "Can not divide by 0";
			throw new UnknownCmdException(errstr);
		}
		
	}
	public boolean endCalc(String cmd) {
		boolean dummyFlag = false;
		char dummy = 'd';
		if (cmd.length()==1) {
			dummy = cmd.charAt(0);
			if(dummy == 'r' || dummy == 'R') {
				dummyFlag = true;	// dummyFlag will change final flag (this is confirmed true)
				this.finalflag = true;
			} 
		}
		return dummyFlag;	// return this flag to stop calculation
	}
	
}
