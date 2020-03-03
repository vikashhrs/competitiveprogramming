public class Traversal{
    public static void main(String args[]){
        int arr[] = {1,2,3,4,5,6,7,8,9,0};
        randomOrderTraversal(arr, arr.length - 1);
    }

    public static void randomOrderTraversal(int arr[], int lastIndex){
        if(lastIndex != 0){
            double randomDouble = Math.random();
            randomDouble = randomDouble * lastIndex + 1;
            int index = (int)randomDouble;
            System.out.print("Index = "+index+" value = ");
            System.out.println(arr[index]);
            int temp = arr[index];
            arr[index] = arr[lastIndex];
            arr[lastIndex] = temp;
            randomOrderTraversal(arr, lastIndex - 1);
        }else{
            System.out.print("Index = "+lastIndex+" value = ");
            System.out.println(arr[lastIndex]);
        }
    }
}