package Program;

import java.util.HashMap;
//给定一个字符串,找出不含有重复字符的最长子串的长度  
public class LongestSingleSubstring
{
    public static void main(String[] args)
    {
        System.out.println(findLongestSubstringLength("arabcacfr")); //4
        System.out.println(findLongestSubstringLength("bbb")); //1
        System.out.println(findLongestSubstringLength("")); //0
    }

    private static int findLongestSubstringLength(String string)
    {
        if (string == null || string.equals("")) return 0;
        int maxLength = 0;
        int curLength = 0;
       HashMap<Character, Integer> postions=new HashMap<Character, Integer>();
        for (int i = 0; i < string.length(); i++)
        {
            char curChar = string.charAt(i) ;          
            Integer prePosition = postions.get(curChar);
            if(prePosition==null) {
            	prePosition=-1;
            }          
            //当前字符与它上次出现位置之间的距离            
            int distance = i - prePosition;
            
            //prePosition ==null 表示当前字符第一次出现
            //distance > curLength表示前一个非重复子字符串中没有包含当前字符
            if (prePosition ==null || distance > curLength)
            {
                curLength++;
            } 
            else
            {
                //更新最长非重复子字符串的长度
                if (curLength > maxLength)
                {
                    maxLength = curLength;
                }
                curLength = distance;
            }
           //更新字符出现的位置
            postions.put(curChar, i);
        }
      //更新最长非重复子字符串的长度
        if (curLength > maxLength)
        {
            maxLength = curLength;
        }
        return maxLength;
    }
}

