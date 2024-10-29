package org.mypro.study.algorithms.sort;

import java.util.Random;

/**
 * 比较排序
 */
public class CompareSort {

	public static int[] randomArr(int num) {
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(arr.length);
		}
		System.out.println("排序前:" + toString(arr));
		return arr;
	}

	public static String toString(int[] arr) {
		StringBuffer buffer = new StringBuffer();
		//
		buffer.append("[");
		//
		for (int i = 0; i < arr.length; i++) {
			buffer.append(arr[i]);
			if (i < arr.length - 1) {
				buffer.append(",");
			}
		}
		buffer.append("]");
		//
		return buffer.toString();
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[j];
		arr[j] = arr[i];
		arr[i] = tmp;
	}

	public static void main(String[] args) {

		CompareSort sort = new CompareSort();

		System.out.println("冒泡排序算法:" + toString(sort.bubbleSort(randomArr(10))));
		System.out.println();
		System.out.println("选择排序算法:" + toString(sort.selectSort(randomArr(10))));
		System.out.println();
		System.out.println("插入排序算法:" + toString(sort.insertSort(randomArr(10))));
		System.out.println();
		int[] arr = randomArr(10);
		System.out.println("快速排序算法:" + toString(sort.quickSort(arr, 0, arr.length - 1)));
		System.out.println();
		int[] arr2 = randomArr(10);
		System.out.println("归并排序算法:" + toString(sort.margeSort(arr2, 0, arr2.length - 1)));
	}

	/**
	 * 快速排序，分治思想， 确定一个基准pivot，就能确定其左右元素，
	 * 
	 * @param arr
	 * @return
	 */
	public int[] quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int prvotIndex = partition(arr, left, right);
			quickSort(arr, left, prvotIndex - 1);
			quickSort(arr, prvotIndex + 1, right);
		}

		return arr;
	}

	private int partition(int[] arr, int left, int right) {
		// 定义基准及基准应该在的位置
		int pivot = arr[right];
		int i = left - 1;

		// 将比pivot小的元素放在前面
		for (int j = left; j < right; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		// 将pivot放在应该在的位置
		swap(arr, i + 1, right);
		//
		return i + 1;
	}

	/**
	 * 归并排序算法 分治思想，将素组分成两部分然后，分别递归至两个元素做比较，再然后向上组装，最后再合并成一个数组返回
	 * 
	 * @return
	 */
	public int[] margeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			margeSort(arr, left, mid); // 递归右边排序
			margeSort(arr, mid + 1, right); // 递归左边排序
			// 合并
			marge(arr, left, mid, right);
		}
		return arr;
	}

	private void marge(int[] arr, int left, int mid, int right) {
		int[] tmp = new int[right - left + 1];
		int i = left, j = mid + 1, k = 0;

		//
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
			}
		}
		//
		while(i <= mid) {
			tmp[k++] = arr[i++];
		}
		//
		while(j <= right){
			tmp[k++] = arr[j++];
		}
		//
		System.arraycopy(tmp, 0, arr, left, tmp.length);

	}

	/**
	 * 插入排序 整行中选择最小的放在数组头，循序递进
	 * 
	 * @param arr
	 * @return
	 */
	public int[] insertSort(int[] arr) {
		int n = arr.length;
		//
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				// 往右移动一位
				arr[j + 1] = arr[j];
				j -= 1;
			}
			// 插入key
			arr[j + 1] = key;
		}

		return arr;
	}

	/**
	 * 选择排序 整行找出最大的，放到数组头，循序递进
	 * 
	 * @param arr
	 * @return
	 */
	public int[] selectSort(int[] arr) {
		int n = arr.length;
		//

		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			// 最小的minIndex和i换位置
			swap(arr, i, minIndex);
		}

		//
		return arr;
	}

	/**
	 * 冒泡排序时间 两元素相比，交换位置，直到放到数组尾
	 * 
	 * @param arr
	 * @return
	 */
	public int[] bubbleSort(int[] arr) {
		//
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			boolean swapped = false; //
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					//
					swap(arr, j, j + 1);
					//
					swapped = true;
				}
			}
			if (!swapped)
				break;
		}
		//
		return arr;
	}

}
