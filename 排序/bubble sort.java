class Solution {

    public int[] bubbleSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }

        int len = nums.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len - i - 1; j++){
                if(nums[j] <= nums[j+1]){
                    continue;
                }

                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15}; 

        nums = new Solution().bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}