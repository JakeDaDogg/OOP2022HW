

/**
 * 
 * @author yuhanchiang
 * @version 2022/3/29 
 * added javadoc
 */

public class IsLeapYear {

		public String determine(int i) {
			if(1<= i && i <=10000) {
				if(i%400==0) {
					return "true";}
				else if(i%4==0 && i%100!=0) {
					return "true";
				}
				else {
					return "false";
				}
			}
			else {
				return "Out of bounds";
			}
		}
	}
// You're listening to New World Sounds

