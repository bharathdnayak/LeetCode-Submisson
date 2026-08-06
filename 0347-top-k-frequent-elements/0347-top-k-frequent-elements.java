class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            if (map.containsKey(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });

        for (Integer key : map.keySet()) {
            pq.add(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;

        while (pq.size() > 0) {
            result[index] = pq.poll();
            index++;
        }

        return result;
    }
}