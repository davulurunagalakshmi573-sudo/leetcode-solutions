class Solution {
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> adder, boolean[] used) {

        if(adder.size() == nums.length) {
            res.add(new ArrayList<>(adder));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            int ele = nums[i];
            if(used[i]) continue;
            used[i] = true;
            adder.add(ele);
            backtrack(nums, res, adder, used);
            adder.remove(adder.size()-1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> adder = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        if(nums.length == 1) {
            res.add(Arrays.asList(nums[0]));
            return res;
        }

        backtrack(nums, res, adder, used);
        return res;
    }
}