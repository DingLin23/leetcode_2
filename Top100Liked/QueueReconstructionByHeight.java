//time: o(n^2)
//space:o(n)

class Solution {
    //input:[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (n1, n2) -> (n2[0] == n1[0])?  n1[1] - n2[1] : n2[0] - n1[0]); // 完成排序[[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
    List<int[]> res = new LinkedList<>();
    for(int[] p : people) {
        //根据人头排应该在index的什么位置。
        res.add(p[1],p);
    }
    return res.toArray(new int[people.length][2]);
    }
}