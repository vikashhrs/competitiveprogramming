public class Solution{
    public static void main(String args[]){
        // sort012s();
        sort01s();
    }

    public static void sort012s(){
        int arr[] = {1, 0, 2, 0, 1, 0, 2, 0, 0, 1, 0};
        int left = 0, mid = 0, right = arr.length - 1;
        while(mid <= right){
            if(arr[mid] == 0){
                int temp = arr[mid];
                arr[mid] = arr[left];
                arr[left] = temp;
                left++;
                mid++;
            }else if(arr[mid] == 2){
                int temp = arr[mid];
                arr[mid] = arr[right];
                arr[right] = temp;
                right--;
            }else{
                mid++;
            }
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print("\t"+arr[i]);
        }
    }

    public static void sort01s(){
        int arr[] = {0,1,0,1,1,0,0,1,0};
        int left = 0, right = arr.length - 1;
        while(left < right){
            if(left == 1){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                right--;
            }else if(left == 0){
                left++;
            }
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print("\t"+arr[i]);
        }
    }
}