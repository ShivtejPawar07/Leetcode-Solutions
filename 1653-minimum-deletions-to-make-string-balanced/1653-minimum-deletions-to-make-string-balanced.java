class Solution {
    public int minimumDeletions(String s) {
        int countB=0;
        int deletion=0;

        for(char ch:s.toCharArray()){
            if(ch=='b')
                countB++;
            else// ch == 'a'
                deletion=Math.min(deletion+1,countB);
        }
        return deletion;
    }
}