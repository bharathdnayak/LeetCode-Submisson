class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
         for (int j = i+1; j < n ; j++) {

                if (j > i+1 && nums[j] == nums[j - 1]) continue;

            int left = j + 1;
            int rigth = n - 1;
            

            while (left < rigth) {
                long sum = (long) nums[i] + nums[j] + nums[left] + nums[rigth];


                if (sum ==target) {
                    ans.add(Arrays.asList(nums[i], nums[j],nums[left], nums[rigth]));

                    while (left < rigth && nums[left] == nums[left + 1]) left++;

                    while (left < rigth && nums[rigth] == nums[rigth - 1]) rigth--;
                    
        

                                
                    left++;
                    rigth--;
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    rigth--;
                }
            }
              }
      }
      return ans;
        }
        
        
    }

