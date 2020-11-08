package Problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        // homework

        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }
    private static void permute(int[] nums, int position, List<List<Integer>> result) {
        //stopping condition
        if (nums.length == 0) {
            result.add(new ArrayList<>());
        }
        if (position == nums.length - 1) {
            List<Integer> oneResult = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                oneResult.add(nums[i]);
            }
            result.add(oneResult);

            return;
        }
        for (int i = position; i < nums.length; i++){
            int temp = nums[position];
            //put number in the front
            nums[position] = nums[i];
            nums[i] = temp;
            //call permute with position + 1
            permute(nums, position + 1, result);
            //put number back to original position
            nums[i] = nums[position];
            nums[position] = temp;
        }
    }
}
