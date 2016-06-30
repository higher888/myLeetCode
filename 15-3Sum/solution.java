public class Solution {
    public List<List<Integer>> threeSum(int[] numbers) {
        
        Arrays.sort(numbers);
        List<List<Integer>> resultArList = new ArrayList<List<Integer>>();
        for (int i = 0; i < numbers.length - 2; i++){
            if (i == 0 || numbers[i] > numbers[i - 1]){
                int j = i + 1;
                int k = numbers.length - 1;
                while (j < k){
                    int sum = numbers[i] + numbers[j] + numbers[k];
                    if (sum == 0){
                        /* because everytime if I clear this small arraylist, the corresponding arrylist in the large one is also cleared*/
                        /* If i need many arraylist, I need to "new" many times*/
                        /* whether this would be problem if the name of new ArrayList is the same ---- no problem */
                        List<Integer> numArList = new ArrayList<Integer>();
                        numArList.add(numbers[i]);
                        numArList.add(numbers[j]);
                        numArList.add(numbers[k]);
                        if (!resultArList.contains(numArList)){
                            resultArList.add(numArList);
                        }
                        k--;
                    }
                    else if (sum < 0){
                        j++;
                    }
                    else {
                        k--;
                    }
                }
            }
        }
        return resultArList;
    }
}