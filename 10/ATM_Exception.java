

@SuppressWarnings("serial")
public class ATM_Exception extends Exception{
	
	private enum ExceptionTYPE {
		
		e1("BALANCE_NOT_ENOUGH"),
		e2("AMOUNT_INVALID");
		
		private String error;

		// constructor
		ExceptionTYPE(String error) {
			// TODO Auto-generated constructor stub
			this.error = error;
		}
		
		// getting method
		public String getError() {
			return this.error;
		}
		
	};
	
	private String ErrorLabel = "0";
		
	public ATM_Exception(String errmessage) {
		super(errmessage);
		ErrorLabel = errmessage;
	}
	
	public String getMessage() {
		String out = null;
		ExceptionTYPE label = ExceptionTYPE.valueOf(ErrorLabel);
		out = label.getError();
		return out;
	}

}
