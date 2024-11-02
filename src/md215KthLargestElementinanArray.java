import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class md215KthLargestElementinanArray {

    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
//        pq.offer(1);
//        pq.offer(12);
//        pq.offer(11);
//        pq.offer(7);
//
//        if(pq.size() > 3){
//            pq.poll();
//        }
//
//        for (Integer num :
//                pq) {
//            System.out.println(num);
//        }
//        System.out.println("pq size: "+ pq.size());

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        md215KthLargestElementinanArray test= new md215KthLargestElementinanArray();
        int result = test.findKthLargest(nums,k);
        System.out.println(result);

    }

    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];

//        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
//        for (int num :
//                nums) {
//            pq.offer(num);
//            if(pq.size() > k){
//                pq.poll();
//            }
//        }
//        return pq.peek();

        int target = nums.length - k;
//        return quickSort(nums, 0, nums.length - 1, target);

        int left = 0;
        int right = nums.length - 1;
        while (true){
            int middle = partition(nums, left, right);
            if(middle == target){
                return nums[middle];
            }else if(middle > target){
                right = middle-1;
            }else{
                left = middle+1;
            }
        }


    }

    public int quickSort(int[] arr, int start, int end, int target){

        int middle = partition(arr, start, end);
        if(middle == target){
            return arr[middle];
        }else if(middle > target){
            return quickSort(arr, start, middle - 1, target);
        }else{
            return quickSort(arr, middle + 1, end, target);
        }
    }

    public int partition(int[] arr, int start, int end){
        Random rm = new Random();
        int idx = rm.nextInt(end - start + 1) + start;
        swap(arr, start, idx);
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        while (left < right){
            while(left < right && arr[left] <= pivot)left++;
            while(left < right && arr[right] > pivot)right--;
            if(left < right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        if(left==right && arr[right] > pivot)right--;
        swap(arr,start,right);
        return right;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
