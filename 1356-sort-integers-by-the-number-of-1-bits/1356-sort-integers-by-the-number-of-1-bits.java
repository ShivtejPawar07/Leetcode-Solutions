import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] temp = new Integer[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        
        Arrays.sort(temp, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if(countA == countB){
                return a - b;
            }
            return countA - countB;
        });
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = temp[i];
        }
        
        return arr;
    }
}