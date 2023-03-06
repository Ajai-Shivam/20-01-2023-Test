 public String LeetCode12(int num) {
       Map<Integer,String> mapping = new HashMap<>();
        mapping.put(1,"I");
        mapping.put(4,"IV");
        mapping.put(5,"V");
        mapping.put(9,"IX");
        mapping.put(10,"X");
        mapping.put(40,"XL");
        mapping.put(50,"L");
        mapping.put(90,"XC");
        mapping.put(100,"C");
        mapping.put(400,"CD");
        mapping.put(500,"D");
        mapping.put(900,"CM");
        mapping.put(1000,"M");
        String ans = "";
        while (num>0){
            if(num==4){
                ans+=mapping.get(4);
                num-=4;
            }else if(num>=1 && num<4){
                    ans += mapping.get(1);
                    num-=1;
            } else if (num == 9) {
                ans+=mapping.get(9);
                num-=9;
            } else if (num>=5 && num<9) {
                    ans += mapping.get(5);
                    num-=5;

            } else if (num>=40 && num<50) {
                ans+=mapping.get(40);
                num-=40;
            } else if (num>=10 && num<40) {
                    ans += mapping.get(10);
                    num-=10;
            } else if (num >=90 && num<100) {
                ans+=mapping.get(90);
                num-=90;
            }else if (num>=50 && num<90) {
                    ans += mapping.get(50);
                    num-=50;
            } else if (num>=400 &&num<500) {
                ans+=mapping.get(400);
                num-=400;
            } else if(num>=100 && num<400){
                ans+= mapping.get(100);
                num-=100;
            } else if (num>=500 && num<900) {
                ans+=mapping.get(500);
                num-=500;
            } else if (num>=900 && num<1000) {
                ans+=mapping.get(900);
                num-=900;
            }else{
                ans+=mapping.get(1000);
                num-=1000;
            }
        }
    return ans;
    }
