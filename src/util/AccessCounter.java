package util;

import java.util.HashMap;

public class AccessCounter {
    
    private final HashMap<String, Integer> accesses = new HashMap();
    private final static AccessCounter INSTANCE = new AccessCounter();

    private AccessCounter() {
    }
    
    public static AccessCounter getInstance(){
        return INSTANCE;
    }
    
    public Integer increment(String name){
        final Integer count;
        if(this.accesses.containsKey(name)){
            count = this.accesses.get(name);
        }else{
            count = 1;
        }
        this.accesses.put(name, count);
        return count;
    }
    
    
}