class Solution {
    class TrieNode{
        TrieNode[]children;
        boolean eow;
        public TrieNode(){
            children=new TrieNode[26];
            eow=false;
        }
    }
    Map<Integer,List<String>> memo=new HashMap<>();
     TrieNode root=new TrieNode();
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict){
            TrieNode  curr=root;
            for(int i=0; i<str.length(); i++){
                int idx=str.charAt(i)-'a';
                if(curr.children[idx]==null){
                    curr.children[idx]=new TrieNode();
                }
                curr=curr.children[idx];
            }
            curr.eow=true;
        }
        return dfs(0,s);
    }
    public List<String> dfs(int start,String s){
        if(start==s.length()){
            List<String> baseRes=new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        if(memo.containsKey(start)){
            return memo.get(start);
        }
        List<String> validSentences=new ArrayList<>();
        TrieNode curr=root;
        for(int i=start; i<s.length(); i++){
            int idx=s.charAt(i)-'a';
            if(curr.children[idx]==null) break;
            curr=curr.children[idx];
            if(curr.eow){
            String currStr=s.substring(start,i+1);
            List<String> subSentences=dfs(i+1,s);
            for(String sub:subSentences){
                if(sub.isEmpty()){
                    validSentences.add(currStr);
                }else{
                    validSentences.add(currStr+" "+sub);
                }
            }
        }
        }
        
        memo.put(start,validSentences);
        return validSentences;
    }
}