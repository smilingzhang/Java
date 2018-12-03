package Javademo1;

import java.util.Arrays;

public class Array {

	public Array() {
		// TODO 自动生成的构造函数存根
	}
    public static void main(String[] args) {
    	//2.Arrays中的copyOf  fill sort方法
    			//（1）sort对整个数组或者部分数组进行排序，默认是升序
    			//int arr[]={6,5,1,9,78,25,31,7};
    			//Arrays.sort(arr);
    			/*for(int i=0;i<arr.length;i++) {
    				System.out.println(arr[i]);
    			}*/
    			/*Arrays.sort(arr,1,5);//将数组从arr[1]到arr[5-1]排序
    			for(int i=0;i<arr.length;i++) {
    				System.out.print(arr[i]+" ");
    			}*/
    			//(2)Arrays.equals(arr1,arr2)判断两个数组是否相等
    			//（3）copyOf()
    			String arr1[]= {"123","234","345","456","789"};
    			String arr2[]=Arrays.copyOf(arr1, 3);//3代表要复制的长度
    			arr1.equals(arr2);
    			for(int i=0;i<arr2.length;i++) {
    				System.out.println(arr2[i]);
    			}
    			//(3)fill的用法
    			/*int arr3[]=new int[8];
    			Arrays.fill(arr3,1,3,6);
    			for(int k=0;k<8;k++) {
    				System.out.print(" "+arr3[k]);
    			}*/
    			
    }
}
