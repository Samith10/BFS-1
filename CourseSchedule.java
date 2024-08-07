// Time Complexity : O(v+e)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Your code here
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        ArrayList<Integer> list;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            indeg[prerequisites[i][0]]++;
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0 && map.containsKey(i)) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.remove();
            if (map.containsKey(cur)) {
                list = map.get(cur);

                for (int l : list) {
                    indeg[l]--;
                    if (indeg[l] == 0) {
                        q.add(l);
                    }
                }
            }
        }

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] != 0)
                return false;
        }
        return true;
    }
}