//time: O(n^2)
//space: o(n)

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        // 为每一个单元开辟一个array去存
        int n = transactions.length;
        String [] name = new String[n];
        int [] time = new int[n];
        int [] amount = new int[n];
        String[] city = new String[n];
        
        for(int i = 0; i < n; i++){ 
            String[] item = transactions[i].split(","); //separate 逗号
            name[i] = item[0];//分装入库
            time[i] = Integer.parseInt(item[1]);
            amount[i] = Integer.parseInt(item[2]);
            city[i] = item[3];
        }
        boolean [] isInvalid = new boolean[n];
        for(int i = 0; i < n; i++){ // invalid条件
            if(amount[i] >= 1000) isInvalid[i] = true;
            for(int j = i+1; j < n; j++){
                if(name[i].equals(name[j]) && !city[i].equals(city[j]) && Math.abs(time[i] - time[j]) <= 60){
                    isInvalid[j] = true;
                    isInvalid[i] = true;
                }
            }
        }
        
        List<String> res = new ArrayList<>(); // res array to store invalid transactions.
        for(int i = 0; i< n; i++){
            if(isInvalid[i]){
                res.add(transactions[i]);
            }
        }
        return res;
    }
}