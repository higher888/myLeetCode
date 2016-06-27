public class Solution {
    public int removeElement(int[] nums, int val) {
        int startP = 0;
        int endP = nums.length - 1;
        while (startP <= endP){
            if (nums[startP] == val){
                nums[startP] = nums[endP];
                endP--;
            }
            else{
                startP++;
            }
        }
        return endP + 1;
    }
}