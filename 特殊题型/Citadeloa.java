import java.awt.List;
// leetcode 829d
public class Citadeloa {
    public static int droppedRequests(List<Integer> requestTime) {
        int request = 0, res = 0;
        for (int i = 0; i < requestTime.size(); i++) {
           while (i < requestTime.size() && requestTime.get(i) == 1) {
               i++;
               request++;
               if (request > 3) {
                   res++;
               }
           }
           while (i < requestTime.size() && requestTime.get(i) < 10) {
               i++;
               request++;
               if (request > 20) {
                   res++;
               }
           }
           while (i < requestTime.size() && requestTime.get(i) < 60) {
            i++;
            request++;
            if (request > 60) {
                res++;
            }
        }
        }
        return res;

    }
    
}