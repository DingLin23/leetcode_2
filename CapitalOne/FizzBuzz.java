//time: o(n)
//space:o(n)

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <=n; i++){
            if(i % 3 == 0  && i % 5 ==0){ // have to put as first condition. otherwise fizzbuzz will not been add to list. // if(true) excute, if (true excute) ; if(t) excute, else if()not gonna excute if(t);
                list.add("FizzBuzz");
            }
            else if(i % 3 == 0){
                list.add("Fizz");
            }
            else if(i % 5 == 0){
                list.add("Buzz");
            }
            
            else{
                list.add(i + "");
            }
        }
        return list;
        
    }
}