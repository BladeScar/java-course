import java.util.Scanner;

public class findTheHighestNumberOf5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in, "UTF-8");
		System.out.println("Enter 5 numbers, please.");
		int number;
		int temp = 0;
		
		for (int i = 1; i <= 5; i++) {
		System.out.print("Number: ");
		number = input.nextInt();
			if (number > temp) {
				temp = number;
			}
		}
		 System.out.print("Highest value: " + temp);
		 input.close();
	}

}
