public class Searching {
    public int linearSearching(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public int binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        int mid;
        //0,1,2,3,7,8,9,35,93,213 = (l+r)/2;
        while(l<=r){
            mid = (l+r)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
