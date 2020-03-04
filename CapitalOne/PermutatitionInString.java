class Solution{
    public boolean checkInclusion(String s1, String s2){
        int len1 = s1.length(), len2 = s2.length();
        if(len1 > len2) return false;
        
        int count[] = new int[26];

        // checking if has same length for both str
        for(int i = 0; i < len1; i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        if(allZero(count)) return true;

        //if not found at case 1,checking rest length of s2, and reset to zero;
        for(int i = len1; i < len2; i++){
            count[s2.charAt(i)-'a']--;// only if has the same char set to 0;
            count[s2.charAt(i-len1)-'a']++; // if dont have the same value reset to zero.
            if(allZero(count)) return true;
        }



        return false;
    }

        private boolean allZero(int[] count){
            for(int i = 0; i <count.length; i++){
                if(count[i] != 0) return false;
            }
            return true;
        }
}