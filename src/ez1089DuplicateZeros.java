public class ez1089DuplicateZeros {

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,0,7};

        ez1089DuplicateZeros t = new ez1089DuplicateZeros();
        t.duplicateZeros(arr);
    }

    public void duplicateZeros(int[] arr) {

        if(arr.length == 1){
            System.out.println(arr[0]);
            return;
        }

        int leftShift = 0;
        boolean isZeroEndButNotDouble = false;
        for(int i = 0; i < arr.length - leftShift; i++){
            if(arr[i] == 0){
                if(i == arr.length - leftShift - 1){
                    isZeroEndButNotDouble = true;
                    break;
                }
                leftShift++;
            }
        }

        for(int j = arr.length - 1; j >= 0; j--){
            if(j == arr.length - 1 && isZeroEndButNotDouble){
                arr[j] = 0;
                continue;
            }
            if(arr[j - leftShift] == 0){
                arr[j] = 0;
                leftShift--;
                j--;
                arr[j] = 0;
            }else{
                arr[j] = arr[j - leftShift];
            }
        }



        for(int k : arr){
            System.out.println(k);
        }
    }
}
