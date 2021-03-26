package company.bht;

import java.util.HashMap;

public class HashMapScenario {
    static class Key {
        String keyValue;

        public Key(String keyValue) {
            this.keyValue = keyValue;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> stringKeyHashMap = new HashMap<>();
        stringKeyHashMap.put("A", Integer.valueOf(1));
        stringKeyHashMap.put("A", Integer.valueOf(2));
        HashMap<Key, Integer> customKeyHashMap = new HashMap<Key, Integer>();

        Key key1A = new Key("A");
        Key key2A = new Key("A");

        customKeyHashMap.put(key1A, Integer.valueOf(1));
        customKeyHashMap.put(key2A, Integer.valueOf(2));

        System.out.println(String.format("stringKey: %s; customKey: %s", stringKeyHashMap.get("A"), customKeyHashMap.get(key1A)));

    }
}
