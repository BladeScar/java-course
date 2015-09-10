import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MethodsNeeded {

	private int value;
	Scanner input = new Scanner(System.in, "UTF-8");

	public MethodsNeeded() {
		super();
	}

	public MethodsNeeded(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int[][] fillMatrix(int length) {
		int[][] matrix = new int[length][length];

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.format("Matrix[%d][%d] = ", i, j);
				matrix[i][j] = input.nextInt();
				input.nextLine();
			}
		}

		return matrix;
	}

	public void printMatrix(int[][] matrix, int length) {
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.format("%d ", matrix[i][j]);
			}
			System.out.println();
		}
	}

	private static void transpose(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int x = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = x;
			}
		}
	}

	private static void swapRows(int[][] matrix) {
		for (int i = 0, k = matrix.length - 1; i < k; ++i, --k) {
			int[] x = matrix[i];
			matrix[i] = matrix[k];
			matrix[k] = x;
		}
	}

	public static int[][] rotateMatrix(int[][] matrix) {
		swapRows(matrix);
		transpose(matrix);
		return matrix;
	}

	public void writeInFile(int[][] matrix, String fileName) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		BufferedWriter writer = new BufferedWriter(fileWriter);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				writer.write(matrix[i][j] + " ");
			}
			writer.newLine();
		}

		writer.close();
	}

	public static int[] getRows(int[][] matrix, int length) {
		int sum[] = new int[length];
		int largest = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] > largest) {
					largest = matrix[i][j];
				}
			}

			sum[i] = largest;
		}

		return sum;
	}

	public static int[] getCols(int[][] matrix, int length) {
		int sum[] = new int[length];
		int largest = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[j][i] > largest) {
					largest = matrix[j][i];
				}
			}

			sum[i] = largest;
		}
		return sum;
	}

	public static int[] getDiagonal(int[][] matrix, int length) {
		int sum[] = new int[length];
		int largest = matrix[0][0];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] > largest) {
					if (i == j) {
					largest = matrix[i][j];
					}
				}
			}
			sum[i] = largest;
		}

		return sum;
	}

	public static int diagonal1(int[][] matrix, int length) {
		int [] arr = getDiagonal(matrix, length);
		int largest = arr[0];
		int total = 0;
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}
		total = largest;
		
		return total;
	}
	
	public static int diagonal2(int[][] matrix, int length) {
		matrix = rotateMatrix(matrix);
		int [] array = getDiagonal(matrix, length);
		int largest = array[0];
		int total = 0;
		
		for (int i = 1; i < array.length; i++) {
			if (array[i] > largest) {
				largest = array[i];
			}
		}
		total = largest;
		
		return total;
	}

	public int totalSum(int[][] matrix, int length) {
		int[] row = getRows(matrix, length);
		int[] cols = getCols(matrix, length);
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = diagonal1(matrix, length);
		int sum4 = diagonal2(matrix, length);
		for (int i = 0; i < row.length; i++) {
			sum1 += row[i];
		}

		for (int i = 0; i < cols.length; i++) {
			sum2 += cols[i];
		}

		int total = sum1 + sum2 + sum3 + sum4;
		return total;
	}

}
