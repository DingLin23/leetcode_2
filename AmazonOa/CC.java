import java.util.List;
import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution
{       
    boolean[] v;
    int[] depth, low, parent;
    int time;
    List<List<Integer>> list;
    List<PairInt> res;
    
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    List<PairInt> criticalConnections(int numOfWarehouses, int numOfRoads, 
                                      List<PairInt> roads)
    {
        time=0;
        map = new ArrayList<>();
        res = new ArrayList<>();
        v = new boolean[numOfWarehouses];
        for(int i =0; i<numOfWarehouses ; i++){
            list.add(new ArrayList<>());
        }
        for (PairInt cur : roads){
            int a1= cur.first;
            int a2 = cur.second;
            list.get(a1 - 1).add(a2);
            list.get(a2 - 1).add(a1);
        }
        depth = new int[numOfWarehouses];
        low = new int[numOfWarehouses];
        parent = new int [numOfWarehouses];
        dfs(0);
        return res;       
    }  
    void dfs(int pre){
        v[pre] = true;
        depth[pre] += ++time;
        low[pre] += time;
        for (int cur: list.get(pre)){
            parent[cur - 1] = pre ;
            if (!v[cur - 1]){
                dfs(cur - 1);
                low[pre] = Math.min(low[pre],low[cur - 1]);
                if(low[cur - 1]> depth[pre]){
                    PairInt tmp = new PairInt(pre + 1, cur);
                    res.add(tmp);                   
                }
                
            }else{
                if (cur != parent[pre]){
                    low[pre] = Math.min(low[pre], depth[cur-1]);
                }
            }
        }
    }
    
    
    
    
    // METHOD SIGNATURE ENDS
}
