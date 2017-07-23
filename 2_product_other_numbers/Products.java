import java.util.Arrays;

public class Products {

	//simple brute force solution
	// private static int[] getProductsOfAllIntsExceptAtIndex(int[] numbers) {
	// 	int[] products = new int[numbers.length];
	// 	for(int i = 0; i < numbers.length; i++) {
	// 		int current_product = 1;
	// 		for(int j = 0; j < numbers.length; j++) {
	// 			if (i != j) {
	// 				current_product *= numbers[j];
	// 			}
	// 		}
	// 		products[i] = current_product;
	// 	}
	// 	return products;
	// }


	//ideas
	//multiply all the numbers before, by all the numbers after
	// O(3n) ~ O(n)
	private static int[] getProductsOfAllIntsExceptAtIndex(int[] numbers) {
		int length = numbers.length;
		int[] products = new int[length];
		int[] productsBefore = new int[length];
		int[] productsAfter = new int[length];

        //create products before array
		productsBefore[0] = 1;
		for (int i = 1; i < length; i++) {
			productsBefore[i] =  productsBefore[i - 1] * numbers[i - 1];
		}

		//create after array
		productsAfter[length - 1] = 1;
		for (int i = 2; i < length + 1; i++) {
			productsAfter[length - i] = productsAfter[length - i + 1] * numbers[length - i + 1];
		}

		//multiply them
		for (int i = 0; i < length; i++) {
			products[i] = productsAfter[i] * productsBefore[i];
		}
		return products;
	}
	public static void main(String[] args) {
		int[] inputs = new int[] {1,2,3,4,5};
		int[] products = getProductsOfAllIntsExceptAtIndex(inputs);
		System.out.println(Arrays.toString(products));
	}
}