class Solution {
    public boolean isVowel(char ch)
    {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        {
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int ws=0,we=0,max=0,vc=0;
        for(we=0;we<s.length();we++)
        {
            if(isVowel(s.charAt(we)))
            {
                vc++;
            }
            if(we>=k)
            {
                if(isVowel(s.charAt(ws)))
                {
                    vc--;
                }
                ws++;
            }
             max=Math.max(vc,max);
        }
          return max;
    }
}
