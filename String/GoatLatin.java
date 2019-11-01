//time: o(n)
//space: o(n)

class Solution{
    public String toGoatLatin(String S){
        //corner case
        if(S == null || S.length() == 0) return "";

        //StringBuilder to append.
        StringBuilder sb = new StringBuilder();
        String [] s = S.split(" ");// input of String with space "i speak english"
        String a = "";
        for(int i = 0; i < s.length; i++){
            String cur = s[i];
            a += 'a';
            //case 1 vowel a e i o u
            if(isVowel(cur.charAt(0))){
                sb.append(cur + "ma" + a);
            }
            //case 2 not vowel
            if(!isVowel(cur.charAt(0))){
                sb.append(cur.substring(1) + cur.charAt(0) + a);

            }

            //sb.append gives "dsahdsajhdvasjh" without space, if we dont put space between.
            sb.append(" "); // this will cause the last string in that sb array has space at the end.


        }
        return sb.toString().trim();// trim to remove the last space.

    }

    private boolean isVowel(char c){
        char new_C = Character.toLowerCase(c); //排除大小写区别，全部改小写。
        if(new_C == 'a' || new_C == 'e' || new_C == 'i'  || new_C == 'o'  || new_C == 'u' ) return true;
        return false;
    }
    }
}