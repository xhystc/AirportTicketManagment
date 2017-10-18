package com.xhystc.airport.bean;
import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] res = sovle(str.toCharArray());
		for(Character c : res){
			System.out.print(c);
		}
	}
	public static char[] sovle(char[] array){
		int endPtr = array.length-1;
		while(endPtr>0){
			if(array[endPtr]>='A' &&array[endPtr]<='Z' ){
				endPtr--;
				continue;
			}
			int changePtr=endPtr-1;
			while(array[changePtr]>='a' &&array[changePtr]<='z' ){
				changePtr--;
				if(changePtr<0)
					return array;
			}
			char c = array[changePtr];
			for(int i=changePtr;i<endPtr;i++){
				array[i]=array[i+1];
			}
			array[endPtr]=c;
			endPtr--;
		}
		return array;
	}

}