public class AppleStocks {
    //Brute force naive solution O(n^2)
	// private static int getMaxProfit(int[] stockPricesYesterday) {
	// 	int maxProfit = 0;
	// 	for (int i = 0; i < stockPricesYesterday.length ; i++) {
	// 		for (int j = i + 1; j < stockPricesYesterday.length; j++) {
	// 			int potentialProfit = stockPricesYesterday[j] - stockPricesYesterday[i];
	// 			if (potentialProfit > maxProfit) {
	// 				maxProfit = potentialProfit;
	// 			}
	// 		}
	// 	}
	// 	return maxProfit;
	// }

	//attempting an O(n) solution
	private static int getMaxProfit(int[] stockPricesYesterday) {
		if (stockPricesYesterday.length < 2) {
       		System.out.println("Your data sucks!");
       		return 0;
    	}
		int maxProfit = stockPricesYesterday[1] - stockPricesYesterday[0];
		int lowestPrice = stockPricesYesterday[0];
		int potentialProfit;
		int currentPrice;

		//started i at 0 here, needed the hint to start at 1
		for(int i = 1; i < stockPricesYesterday.length; i++) {
			currentPrice = stockPricesYesterday[i];
			potentialProfit = currentPrice - lowestPrice;
			maxProfit = Math.max(maxProfit, potentialProfit);
			lowestPrice = Math.min(currentPrice, lowestPrice);
		}

		return maxProfit;
	}

    public static void main(String args[]) {
		int[] stockPricesYesterday = new int[] {10, 7, 5, 4, 2, 0};
        int maxProfit = getMaxProfit(stockPricesYesterday);
        System.out.println("Max profit is: " + maxProfit);
    }
}