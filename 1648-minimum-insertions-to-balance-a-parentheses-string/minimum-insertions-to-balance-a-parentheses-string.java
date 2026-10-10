class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int ans =0;
        Stack<Character> st = new Stack<>();
        
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.add(ch);
            }else{
                if(st.isEmpty()){
                    if(i<n-1 && s.charAt(i+1)==')'){
                        ans += 1;
                        i+=1;
                    }else{
                        ans+=2;
                    }
                }else{
                    if(i<n-1 && s.charAt(i+1)!=')'){
                        ans += 1;
                        st.pop();
                    }else if(i<n-1 && s.charAt(i+1)==')'){
                        st.pop();
                        i+=1;
                    }else if(i==n-1 && ch==')'){
                        ans++;
                        st.pop();
                    }
                }
            }
        }
        ans += st.size()*2;
        return ans;
    }
}