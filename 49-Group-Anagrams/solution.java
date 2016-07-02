public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> groupMap = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>(); 
        
        for (String str : strs){
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            //String strStr = strChar.toString();
            String strstr = new String(strChar);
            if (!groupMap.containsKey(strChar)){
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                groupMap.put(strStr, newList);
            }
            else {
                groupMap.get(strStr).add(str);
            }
        }
        
        for (Map.Entry<String, List<String>> entry : groupMap.entrySet()){ 
            Collections.sort(entry.getValue()); 
        }
        
        result.addAll(groupMap.values());
        
        return result;
    }
}