import java.util.*;
class Indexes{
    int x;
    int y;
    public Indexes(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Solution{
    public static void main(String args[]){
        int arr[] = {1, 5, 1, 0, 6, 0};
        int totalSum = 2;
        // Pair index visualiser
        // for(int i = 0;i<arr.length;i++){
        //     for(int j = i + 1;j<arr.length;j++){
        //         System.out.print("\t" + i + " " + j);
        //     }
        //     System.out.println();
        // }
        System.out.println(checkIfExists(arr, totalSum));
    }

    public static boolean checkIfExists(int arr[], int totalSum){
        HashMap<Integer, ArrayList<Indexes>> map = new HashMap<Integer, ArrayList<Indexes>>();
        for(int i = 0;i<arr.length - 1;i++){
            for(int j = i + 1;j<arr.length;j++){
                int rem = totalSum - (arr[i] + arr[j]);
                Indexes indexes = new Indexes(i, j);
                // System.out.println(" i = "+i+" j = "+j);
                if(map.containsKey(rem) == true){
                    // System.out.println("rem = "+rem);
                    ArrayList<Indexes> list = map.get(rem);
                    for(Indexes index : list){
                        // System.out.println(" i = "+index.x+" j = "+index.y);
                        HashSet<Integer> set = new HashSet<Integer>();
                        // set.add(i);set.add(j);set.add(index.x);set.add(index.y);
                        // if(set.size() == 4){
                        //     return true;
                        // }
                        if(i != index.x && j != index.y && i != index.y && j != index.x){
                            System.out.println(" i = "+index.x+" j = "+index.y);
                            System.out.println(" i = "+i+" j = "+j);
                            return true;
                        }
                    }
                }
                ArrayList<Indexes> list = map.get(arr[i] + arr[j]);
                if(list == null){
                    list = new ArrayList<Indexes>();
                }
                list.add(indexes);
                map.put(arr[i]+arr[j], list);
            }
        }
        // Map item visualiser
        // for (Map.Entry mapElement : map.entrySet()) { 
        //     int key = (Integer)mapElement.getKey(); 
  
        //     ArrayList<Indexes> list = (ArrayList<Indexes>)mapElement.getValue(); 
        //     System.out.print("\n"+key + " : "); 

        //     for(Indexes index : list){
        //         System.out.print("\t"+index.x + " - " + index.y);
        //     }
        // }
        // System.out.println();  
        return false;
    }
}