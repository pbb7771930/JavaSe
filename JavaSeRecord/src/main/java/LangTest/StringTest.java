package LangTest;
/*
string相关方法的测试总结
 */
public class StringTest {
    public static void main(String[] args){
        //new StringTest().splitTest();
        new StringTest().charAtTest();



    }

    /*
    split(String regex) 将此字符串拆分为给定的regular expression的匹配,此方法返回的数组包含此字符串的每个子字符串
    split(String regex, int limit)
    regex：切割正则匹配
    limit：
    当limit>0时，切割次数=limit-1,因此当limit=1时，不切割，原字符串输出。
    当limit=0与不写limit一致：不限制切割次数，出现几次匹配切割几次；但是去除最后空字符串。
    当limit<0，不限制切割次数，出现几次匹配切割几次，不去除最后空字符串。
    limit=-1：根据String[].length-1=切割次数
     */
    public void splitTest(){
        String a = "+1+2+3+4+5++6+7+8";
        String[] sp1 = a.split("\\+",1); //输出 {+1+2+3+4+5++6+7+8}
        String[] sp2 = a.split("\\+",2); //输出 {1+2+3+4+5++6+7+8}
        String[] sp3 = a.split("\\+",3); //输出{"",1,2+3+4+5++6+7+8}
        String[] sp4 = a.split("\\+"); //输出{"",1,2,3,4,5,"",6,7,8}
        String[] sp5 = a.split("\\+",0); //输出{1,2,3,4,5,"",6,7,8}
        String[] sp6 = a.split("\\+",-1); //输出 {"",1,2,3,4,5,"",6,7,8}
        for(String str : sp4){
            System.out.println(str);
        }
    }

    public void charAtTest(){
        String a = "pwrtcufkgj";
        System.out.println("指定位置的字符是:" + a.charAt(2)); //输出为r，下标从0开始

    }





}
