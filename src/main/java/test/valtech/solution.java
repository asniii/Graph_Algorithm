package test.valtech;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class solution {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        Map<Character,Integer> map1 = new HashMap<>();
        Map<Integer,Character> map2 = new HashMap<>();
        for(int i = 0;i<26;i++){
            map1.put((char) (65+i),i);
            map2.put(i,(char)(65+i));
        }
        for(int i = 0;i<26;i++){
            map1.put((char)(97+i),i+26);
            map2.put(i+26,(char)(97+i));
        }
        for(int i = 0;i<10;i++){
            map1.put((char)(48+i),i+52);
            map2.put(i+52,(char)(48+i));
        }
        map1.put('+',62);
        map1.put('/',63);
        map2.put(62,'+');
        map2.put(63,'/');

        for(int z = 0;z<t;z++){
            int size = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            int sum = 0;
            for(int i = str.length()-1;i>=0;i--){
                if((str.length()-i-1)%2 ==0){
                    char ch = str.charAt(i);
                    int temp = map1.get(ch) *2;
                    int j;
                    if(temp>=64){
                        j = temp/64;
                        temp = temp%64;
                        sum += (j+temp);
                    } else {
                        sum += temp;
                    }
                } else {
                    sum += map1.get(str.charAt(i));
                }
            }

//            int arr[] = new int[size];
//
//            for(int i = 0;i<str.length();i++){
//                arr[i] = map1.get(str.charAt(i));
//            }
//
//            for(int i = str.length()-1;i>=0;i = i-2){
//                int temp = arr[i] *2;
//                int j;
//                if(temp >=64){
//                    j = temp/64;
//                    temp = temp%64;
//                    arr[i] = j+temp;
//                }else {
//                    arr[i] = temp;
//                }
//            }
//
//            int sum = 0;
//            for(int i = 0;i<str.length();i++){
//                sum +=arr[i];
//            }

            int k = sum %64;
            if(k !=0){
                k = 64-k;
            }

            System.out.println(map2.get(k));

        }
    }
}
