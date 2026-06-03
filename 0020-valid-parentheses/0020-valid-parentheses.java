class Solution {
    Stack <Character> st;
    public boolean isValid(String s) {
        st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='[' || ch=='{' || ch=='(')
            {
                st.push(ch);
            }
            else
            {
                if(st.isEmpty())
                {
                    return false;
                }
                if(st.peek()=='(' && ch==')')
                {
                    st.pop();
                }
                else if(st.peek()=='{' && ch=='}')
                {
                    st.pop();
                }
                 else if(st.peek()=='[' && ch==']')
                {
                    st.pop();
                }
                else
                {
                return false;
                }
            }
        }
        if(st.isEmpty())
        {
              return true;
        }
        return false;
    }
}