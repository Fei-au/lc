import java.util.Random;

public class md912SortanArray {
    public static void main(String[] args) {

    }
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] arr, int start, int end){
        if(start >= end) return;

        int middle = partition(arr, start, end);

        quickSort(arr, start, middle-1);
        quickSort(arr, middle+1, end);
    }

    public int partition(int[] arr, int start,int end){
        Random rm = new Random();
        int index = rm.nextInt(end-start+1) + start;
        swap(arr, index, start);
        int pivot = arr[start];

        int left = start + 1;
        int right = end;

        while(left < right){
            while(left < right && arr[left] <= pivot){
                left++;
            }
            while(left < right && arr[right] > pivot){
                right--;
            }
            if(left < right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        if(arr[right] > pivot){
            right--;
        }
        swap(arr, start, right);
        return right;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
