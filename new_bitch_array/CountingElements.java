//time: o(n)
//space: o(n)
public class CountingElements {
    int count = 0;
        if(arr == null || arr.length == 0) return count;
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        
        for(int i = 0; i < arr.length; i++){
            if(set.contains(arr[i] +1)) count++;
        }
        return count;
}