public class Solution {
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return nums.length;
        }
        int positionPointer = 1;
        int oldPointer = 0;
        int newPointer = oldPointer + 1;
        while (newPointer < nums.length){
            if (nums[oldPointer] != nums[newPointer]){
                nums[positionPointer] = nums[newPointer];
                oldPointer = newPointer;
                positionPointer++;
            }
            newPointer++;
        }
        return positionPointer;
    }
}