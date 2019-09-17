public class LengthofLastWord {
    /**
     * For example,
     Given s = "Hello World",
     return 5.

     time : O(1)
     space : O(1)

     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
