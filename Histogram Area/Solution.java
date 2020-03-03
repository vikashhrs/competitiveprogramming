import java.io.*; 
import java.util.*; 
public class Solution{
    public static void main(String args[]){
        int arr[] = {6,5,5,5,6,8,9};
        int maxArea = -1;
        Stack<Integer> st = new Stack<Integer>();
        int i = 0 ;
        while(i<arr.length){
            if(st.isEmpty() || arr[i] >= arr[st.peek()])
                st.push(i++);
            else{
                int tp = st.peek();
                st.pop();
                int area = arr[tp]*(st.isEmpty() ? i : i - tp - 1);
                if(maxArea < area)
                    maxArea = area;
            }
        }
        while(!st.isEmpty()){
            int tp = st.peek();
            st.pop();
            int area = arr[tp]*(st.isEmpty() ? i : i - tp - 1);
            if(maxArea < area)
                maxArea = area;
        }
        System.out.println("Max Area = "+maxArea);
    }
}