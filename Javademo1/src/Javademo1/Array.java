package Javademo1;

import java.util.Arrays;

public class Array {

	public Array() {
		// TODO �Զ����ɵĹ��캯�����
	}
    public static void main(String[] args) {
    	//2.Arrays�е�copyOf  fill sort����
    			//��1��sort������������߲��������������Ĭ��������
    			//int arr[]={6,5,1,9,78,25,31,7};
    			//Arrays.sort(arr);
    			/*for(int i=0;i<arr.length;i++) {
    				System.out.println(arr[i]);
    			}*/
    			/*Arrays.sort(arr,1,5);//�������arr[1]��arr[5-1]����
    			for(int i=0;i<arr.length;i++) {
    				System.out.print(arr[i]+" ");
    			}*/
    			//(2)Arrays.equals(arr1,arr2)�ж����������Ƿ����
    			//��3��copyOf()
    			String arr1[]= {"123","234","345","456","789"};
    			String arr2[]=Arrays.copyOf(arr1, 3);//3����Ҫ���Ƶĳ���
    			arr1.equals(arr2);
    			for(int i=0;i<arr2.length;i++) {
    				System.out.println(arr2[i]);
    			}
    			//(3)fill���÷�
    			/*int arr3[]=new int[8];
    			Arrays.fill(arr3,1,3,6);
    			for(int k=0;k<8;k++) {
    				System.out.print(" "+arr3[k]);
    			}*/
    			
    }
}
