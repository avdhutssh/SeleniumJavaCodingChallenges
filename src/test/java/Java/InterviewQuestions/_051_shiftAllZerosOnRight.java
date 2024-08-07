package Java.InterviewQuestions;

import java.util.Arrays;
import java.util.stream.IntStream;

public class _051_shiftAllZerosOnRight {

	public static void main(String[] args) {
		int[] arr1 = { 1, 0, 2, 0, 3, 0, 0, 0 }; // 1, 2, 3, 0, 0, 0, 0, 0
		int[] arr2 = { 1, 0, 2, 0, 3, 0, 0, 0 }; // 1, 2, 3, 0, 0, 0, 0, 0

		System.out.println("Using Brute Force Approach: " + Arrays.toString(_01_Using_BruteForceApproach(arr1)));
		System.out.println("Using In Place Approach: " + Arrays.toString(_02_Using_InPlaceApproach(arr1)));
		System.out.println("Using In Stream: " + Arrays.toString(_03_Using_Stream(arr2)));
	}

	private static int[] _01_Using_BruteForceApproach(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		int index = 0;
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				result[index++] = arr[i];
			}

		}
		return result;
	}

	private static int[] _02_Using_InPlaceApproach(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(1)
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index++] = arr[i];
			}

		}
		while (index < arr.length) {
			arr[index++] = 0;
		}
		return arr;
	}

	private static int[] _03_Using_Stream(int[] arr) {
		// Time Complexity: O(n)
		// Space Complexity: O(n)
		int[] nonZeros = Arrays.stream(arr).filter(num -> num != 0).toArray();
		int[] zeros = new int[arr.length - nonZeros.length];
		return IntStream.concat(Arrays.stream(nonZeros), Arrays.stream(zeros)).toArray();
	}
}
