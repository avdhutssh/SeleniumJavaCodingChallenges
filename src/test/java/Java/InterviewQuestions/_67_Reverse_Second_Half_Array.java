package Java.InterviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class _67_Reverse_Second_Half_Array {

	public static void main(String[] args) {
		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7 }; // {1, 2, 3, 4, 7, 6, 5 }
		int[] arr2 = new int[] { 1, 2, 3, 4, 5, 6 }; // {1, 2, 3, 6, 5, 4 }

		System.out.println("Using BFA : " + Arrays.toString(_01_Using_BruteForceApproach(arr1)));
		System.out.println("Using BFA : " + Arrays.toString(_01_Using_BruteForceApproach(arr2)));

		System.out.println("Using Simple loop with temp : " + Arrays.toString(_02_Using_Simple_Iteration_Temp(arr1)));
		System.out.println("Using Stack : " + Arrays.toString(_03_Using_Stack(arr2)));
	}

	private static int[] _01_Using_BruteForceApproach(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		int[] result = new int[arr.length];
		int mid = arr.length / 2;
		int j = mid;
		for (int i = arr.length - 1; i >= mid; i--) {
			result[j++] = arr[i];

		}
		for (int i = 0; i < mid; i++) {
			result[i] = arr[i];

		}
		return result;
	}

	private static int[] _02_Using_Simple_Iteration_Temp(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		int mid = arr.length / 2;
		int j = mid;
		for (int i = arr.length - 1; i > mid; i--) {
			int temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			j++;

		}
		return arr;
	}

	private static int[] _03_Using_Stack(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		Stack<Integer> stack = new Stack<Integer>();
		int mid = arr.length / 2;
		for (int i = mid; i < arr.length; i++) {
			stack.push(arr[i]);
		}
		for (int i = mid; i < arr.length; i++) {
			arr[i] = stack.pop();
		}
		return arr;
	}
}
