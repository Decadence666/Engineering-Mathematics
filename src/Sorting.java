public class Sorting {
    public void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = 0;
            while(arr[j] < arr[i]){
                j++;
            }
            int temp = arr[i];
            for(int k = 0; k < i-j; k++){
                arr[i-k] = arr[i-k-1];
            }
            arr[j] = temp;
        }
    }
}
