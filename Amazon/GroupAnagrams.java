// Given an array of strings, group anagrams together.

// Example:

// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:

// All inputs will be in lowercase.
// The order of your output does not matter.


algo: 1.we gonna change the str in str change into char array in order to sort it and  change it back to String type put it to hashmap 
      2. check if hashmap contains same sorted str then we add the original string to the sublist which the same one located
      3. else we create a new list to store original string and add this list into res list.

//Time Complexity: O(MNlogN) M is the length of strs, and N is the maximum length of a string in strs
//space: O(MN)
public List<List<String> groupAnagrams (String[] strs){
    List<List<String>> res =  new ArrayList<>();
    //base case
    if(strs == null || strs.length == 0) return res;

    Map <String,Integer> map = new HashMap <>();
    for(String str : strs){
        char[] c = str.toCharArray();
        Arrays.sort(c);
        String s = new String(ch);
        if(map.containsKey(s)){
            List<String> list = res.get(map.get(s));
            list.add(str);
        }else{
            List<String> list = new ArrayList<>();
            list.add(str);
            map.put(s,res.size());
            res.add(list);
        }
    }
    return res;
}
