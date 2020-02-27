class LRUCache {
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
        
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    int capacity;
    int size;
    Map<Integer,Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(key);
            addHead(key,node.val);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int val) {
        if(map.containsKey(key)){
            remove(key);
            addHead(key,val);
        }else{
            addHead(key,val);
        }
    }
    
    private void remove(int key){
        Node cur = map.get(key);
        Node pre = cur.prev;
        Node next = cur.next;
        pre.next = next;
        next.prev = pre;
        size--;
        map.remove(key);
        
    }
    private void addHead(int key, int val){
        Node node = new Node(key,val);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        size++;
        map.put(key,node);
        
        if(size > capacity){
            Node preTail = tail.prev;
            remove(preTail.key);
        }
    }
    
  }
  
  
  /**
  * Your LRUCache object will be instantiated and called as such:
  * LRUCache obj = new LRUCache(capacity);
  * int param_1 = obj.get(key);
  * obj.put(key,value);
  */