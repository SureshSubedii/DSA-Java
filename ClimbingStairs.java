class ClimbingStairs {
    Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        return fib(n);
        
    }
    public int fib(int n){
        if(n == 0 || n == 1) return 1;
      
        if(map.containsKey(n)) return map.get(n);
      
        map.put(n, fib(n - 1) + fib(n - 2));
      
        return map.get(n);
    }
}