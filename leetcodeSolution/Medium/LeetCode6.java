class LeetCode6 {
    public String convert(String s, int numRows) {
     if(numRows==1){
            return s;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            if(i==0 || i==numRows-1){
                for (int j = i; j < s.length();) {
                    sb.append(s.charAt(j));
                    j+= (numRows-1)*2;
                }
            }else{
                for (int j = i; j < s.length();) {
                    sb.append(s.charAt(j));
                    j += ((numRows-1)*2)-(i*2);
                    if(j>=s.length()){
                        break;
                    }
                    sb.append(s.charAt(j));
                    j += (i*2);

                }
            }

        }
        return sb.toString();
}
}
