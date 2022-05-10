
/**
 * 
 * @author yuhanchiang
 * @version 2022/3/29 modified 
 */

public class GreenCrud {
	int initialSize;
	int days;
	int calPopulation(int initialSize, int days) {
		/**
		 * @param initialSize is initial size
		 * @param days is grows once every five days
		 * @return return initial size times the growth of fibonacci sequence
		 */
		this.initialSize = initialSize;
		this.days = days;
		int growth = (int) days/5;	// 五天長一次
		int f1 = 1;	// 費氏數列第一項
		int f2 = 1; // 費氏數列第二項
		int f3 = 1; // 費氏數列最末項，初始值為一，因為可能為f1
		for (int i = 2; i <= growth;  i++ ) {	// 從第二圈開始計算費氏數列第末項
			f3 = f1 + f2;	// 費氏數列最末項算法
			f1 = f2;		// 第二項變成第一項
			f2 = f3;		// 最末項變成第二項
		}
		return initialSize*f3;	// 回傳最末項＊初始值
	}
}
// with Chestbrah, You guys MIRIN?
