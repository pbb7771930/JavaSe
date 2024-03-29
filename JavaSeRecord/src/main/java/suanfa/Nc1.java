package suanfa;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Author pbb
 * @Description 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * 数据范围：len(s),len(t)≤100000，字符串仅由'0'~‘9’构成
 * 要求：时间复杂度 O(n)
 * @Date 2022/1/19 17:11
 */
public class Nc1 {

/**
 * @Author pbb
 * @Description 方法一
 * @Date 2022/1/19 17:07 
 * @params 
 * @Return string
 *
 */
    public String solve1 (String s, String t) {
        // write code here
        int slen = s.length()-1;
        int tlen = t.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(slen>=0||tlen>=0||carry>0){
            int snum = slen>=0?s.charAt(slen)-'0':0;
            int tnum = tlen>=0?t.charAt(tlen)-'0':0;
            int num = (snum+tnum+carry)%10;
            carry = (snum+tnum+carry)/10;
            sb.append(num);
            slen--;
            tlen--;
        }
        System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }

    /**
     * @Author pbb
     * @Description 方法二：使用BigInteger
     * @Date 2022/1/19 17:09
     * @params
     * @return: return
     */
    public String solve2 (String s, String t) {
        // write code here
        BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);
        System.out.println(bigInteger1.add(bigInteger2).toString());
        return bigInteger1.add(bigInteger2).toString();
    }

    /**
     * @Author pbb
     * @Description 方法三：使用BigDecimal
     * @Date 2022/1/19 17:09
     * @params
     * @return String
     */
    public String solve3 (String s, String t) {
        // write code here
        BigDecimal bigDecimal1 = new BigDecimal(s);
        BigDecimal bigDecimal2 = new BigDecimal(t);
        System.out.println(bigDecimal1.add(bigDecimal2).toString());
        return bigDecimal1.add(bigDecimal2).toString();
    }

    public static void main(String[] args) {
        //new Nc1().solve1("448445.4","56946513.6");
        //new Nc1().solve2("448445","56946513");
        new Nc1().solve3("448445.4","56946513.6");
    }
}

