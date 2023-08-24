package DSA;

import Trying.HSM;

public class Try {
    
    public static void main(String[] args){
        HSM<String, Integer> map=new HSM<>(2);
        map.put("India", 140);
        map.put("china", 136);
        map.put("turkey", 10);
        System.out.println(map.size());
        map.put("pak", 89);
        map.put("sri",23);
        map.put("dawn", 45);
        map.put("chwina", 56);
        System.out.println(map.size());
        for(int i=0; i<map.keySet().size(); i++){
            System.out.println(map.keySet().get(i)+" "+map.get(map.keySet().get(i)));
        }

    }
    
}

