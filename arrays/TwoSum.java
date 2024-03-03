package arrays;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int [] arr={3,2,4};
        int target=6;
        System.out.println(Arrays.stream(twoSum(arr,target)).toArray());

    }
    public static int[] twoSum(int[] nums, int target) {
        int arrSum[]=new int[2];
        for(int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    arrSum[0]=i;
                    arrSum[1]=j;
                }
            }
        }
        return arrSum;
    }
}
