package codecheck;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class App {

    private static String ENCODE = "encode";
    private static String DECODE = "decode";
    private static String ALIGN = "align";
    private static int SHIN_10 = 10;
    private static int SHIN_9 = 9;

    public static void main(String[] args) {
        String CMD = null;
        String NUM = null;
        for (int i = 0, l = args.length; i < l; i++) {
            //String output = String.format("argv[%s]: %s", i, args[i]);
            if (i == 0) {
                CMD = args[i].toString();
            } else {
                NUM = args[i].toString();
            }
        }
        String output = answer(CMD, NUM);
        System.out.println(output);
    }

    public static String answer(String CMD, String NUM) {
        String str = null;
        String cmd = CMD;
        String num = NUM;

        //処理
        if (ENCODE.equals(cmd)) {
            return encode(num, SHIN_9);
        } else if (DECODE.equals(cmd)) {
            return decode(num, SHIN_9);
        } else if (ALIGN.equals(cmd)) {
            return align(num);
        }
        return null;
    }

    public static String encode(String A, int B) {
        int str = Integer.parseInt(A);
        int radix = B;
        int tmp =0;
        String output =null;
        ArrayList<Integer> numlist = new ArrayList<>();
        int[] num = null;
        String result = null;
        int i=0;
        int last = 0;
        while (str >= 9 ) {
            numlist.add(str%9);
            str = str/9;
            i++;
        }
        numlist.add(str);
        int length = numlist.size();
        String[] array = null;
        int count = 0;
        for (int b=length-1; b >= 0; b--) { //(int i = 0; i < array.length; i++)
            String input = numlist.get(b).toString();
            String a = replaceEncode(input);
            if (b == length-1) {
                output = a;
            } else {
                output += a;
            }
        }
        return output;
    }

    public static String decode(String A, int B) {
        String str = A;
        int radix = B;
        int result = 0;
        int output = 0;
        int beki = 0;
        String[] array = null;
        int[] arrayNum = null;
        array = str.split("");
        //System.out.println(String.valueOf("1:"+array[0].toString()));
        int k = array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
            String tmp = replaceDecode(array[i].toString());
            beki = (int) Math.pow(9,Integer.valueOf(array.length-i-1));
            if ((array.length-1-i) > 0) {
                result = (Integer.valueOf(tmp).intValue() * (beki));
            } else if ((array.length-1-i) == 0) {
                result = Integer.valueOf(tmp).intValue();
            }
            output += result;
        }
        return String.valueOf(output);
    }

    public static String align(String A) {
        String result = null;
        String output = null;
        String str = A;
        str = decode(str, SHIN_9);
        int input = Integer.valueOf(str);
        //System.out.println("1:"+input);

        if (input == 0) {
            System.out.println("50:" + encode(String.valueOf(7), SHIN_9));
            return  encode(String.valueOf(7), SHIN_9);
        }
        
        
        int a = String.valueOf(input).length();
        int x = 10;
        ArrayList<Integer> base = new ArrayList<>();
        for (int i =a-1; a==0; a-- ) {
            base.add((int) Math.pow(7, Integer.valueOf(i)));
        }
        int resultInt = 0;
        for (int k=0; k<base.size(); k++){
            resultInt += base.get(k);
            System.out.println("55:" + resultInt);
        }

        //System.out.println("55:" + a);
        //System.out.println("56:" + base);
        /*
        while ((input+base)%7 != 0){
            if ((input+base)%10 !=7 && (input+base)%10 !=0 ) {
                base++;
            }
        }*/


        //System.out.println("3:"+x);
        result = encode(String.valueOf(x), SHIN_9);
        //System.out.println("9:"+result);
        output = encode(String.valueOf(input + x),SHIN_9);
        //System.out.println("99:"+output);
        result = A +" + " + result + " = " + output;
        return result;
    }

    public static boolean isNumber(String num){
        if(Pattern.matches("^[1-9]?[0-9]+$", num)){
            return true;
        }
        return false;
    }




    public static String replaceDecode(String str) {
        String result = null;
        //StringBuilder result = new StringBuilder();
        switch(str) {
            case "A":
                result = str.replaceAll("A","0");
                break;
            case "B":
                result = str.replaceAll("B","1");
                break;
            case "C":
                result = str.replaceAll("C","2");
                break;
            case "D":
                result = str.replaceAll("D","3");
                break;
            case "E":
                result = str.replaceAll("E","4");
                break;
            case "F":
                result = str.replaceAll("F","5");
                break;
            case "G":
                result = str.replaceAll("G","6");
                break;
            case "H":
                result = str.replaceAll("H","7");
                break;
            case "I":
                result = str.replaceAll("I","8");
                break;
        }
        return result.toString();
    }
    public static String replaceEncode (String str) {
        String result = null;
        //StringBuilder result = new StringBuilder();
        switch(str) {
            case "0":
                result = str.replaceAll("0","A");
                break;
            case "1":
                result = str.replaceAll("1","B");
                break;
            case "2":
                result = str.replaceAll("2","C");
                break;
            case "3":
                result = str.replaceAll("3","D");
                break;
            case "4":
                result = str.replaceAll("4","E");
                break;
            case "5":
                result = str.replaceAll("5","F");
                break;
            case "6":
                result = str.replaceAll("6","G");
                break;
            case "7":
                result = str.replaceAll("7","H");
                break;
            case "8":
                result = str.replaceAll("8","I");
                break;
        }
        return result.toString();
    }
}
