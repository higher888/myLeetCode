public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int[] temp = new int[nums.length];
        //scan from left to right and then scan from right to left
        output[0] = 1;
        output[1] = nums[0];
        int i;
        for (i = 2; i < nums.length; i++){
            output[i] = nums[i - 1] * output[i - 1];
        }
        temp[nums.length - 1] = 1;
        temp[nums.length - 2] = nums[nums.length - 1];
        for (i = nums.length - 3; i >= 0; i--){
            temp[i] = nums[i + 1] * temp[i + 1];
        }
        for (i = 0; i < nums.length - 1; i++){
            output[i] *= temp[i];
        }
        return output;
    }
}