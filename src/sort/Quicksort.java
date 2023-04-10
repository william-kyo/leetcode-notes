package sort;

import utils.MyArrayUtil;

import java.util.Random;

public class Quicksort {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            nums[i] = random.nextInt(100);
        }
        System.out.println("Array : ");
        MyArrayUtil.printArray(nums);

        quicksort(nums);
        System.out.println("Sorted : ");
        MyArrayUtil.printArray(nums);
    }

    private static void quicksort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
    }

    private static void quicksort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(nums, low, high);
        quicksort(nums, low, pivotIndex - 1);
        quicksort(nums, pivotIndex + 1, high);

    }

    private static int partition(int[] nums, int low, int high) {
        int pivotIndex = new Random().nextInt(high - low) + low;
        swap(nums, pivotIndex, high);
        int pivot = nums[high];
        int left = low;
        int right = high - 1;
        while (left < right) {
            while (nums[left] <= pivot && left < right) {
                left++;
            }
            while (nums[right] >= pivot && left < right) {
                right--;
            }
            swap(nums, left, right);
        }
        swap(nums, left, high);
        return left;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
