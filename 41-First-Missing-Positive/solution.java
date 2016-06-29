public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A.length == 0){
            return 1;
        }
        int i = 0;
        while (i < A.length){
            if (A[i] != i + 1 && A[i] > 0 && A[i] <= A.length){
                if (A[i] != A[A[i] - 1]){
                    swap (A, i); 
                    continue;
                }
            }                   
            i++;
        }
        for (int j = 0; j < A.length; j++){
            if (A[j] != j + 1){
                return j + 1;
            }
        }
        return A.length + 1;
    }
    
    public void swap (int[] A, int i){
        int temp = A[i];
        A[i] = A[temp-1]; 
        A[temp - 1] = temp;
    }
}