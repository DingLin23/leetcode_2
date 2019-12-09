//time:O(Nlogk)
//space:O(k)

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // int [][] res = new int[K][2];
        // if(points == null || points.length == 0 || points[0].length == 0) return null;
        Queue<int []> pq = new PriorityQueue<>((a,b) -> 
        (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));
        
        for(int[] p : points){
            pq.offer(p);
            if(pq.size() > K){
                pq.poll();
            }
        }
        // while(!pq.isEmpty()){
        //     res[K-1] = pq.poll();
        //     K--;
        // }
        // return res;
        return pq.toArray(new int[K][2]);
    }
}