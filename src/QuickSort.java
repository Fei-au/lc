public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        QuickSort qs = new QuickSort();
        qs.quickSort(arr,0,arr.length - 1);
        for (int num :
                arr) {
            System.out.println(num);
        }
    }

    public void quickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }

        int middle = partition(arr, start, end);
        quickSort(arr, start, middle-1);
        quickSort(arr, middle+1, end);
    }

    public int partition(int[] arr, int start, int end){
        int pivot = arr[start];
        int left = start + 1;
        int right = end;

        // 分区1
//        while (left < right){
//            if(arr[left] > pivot){
//                swap(arr, left, right);
//                right--;
//            }else{
//                left++;
//            }
//        }
//        if(pivot < arr[right]){
//            right --;
//        }
//        if(start != right){
//            swap(arr, start, right);
//        }
//        return right;

        // 双指针分区
        while (left < right){
            while(left < right && pivot >= arr[left]){ // 因为下面left可以++很多次，所以可能会大于right
                left++;
            }
            while (left < right && pivot < arr[right]){ // 因为下面right可以--很多次，所以可能会小于left
                right--;
            }
            if(left < right){ // 此时也要判断一下
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        if(pivot < arr[right]){
            right --;
        }
        if(start != right){
            swap(arr, start, right);
        }
        return right;

    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
