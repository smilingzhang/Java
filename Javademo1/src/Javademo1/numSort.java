package Javademo1;

public class numSort {
	private static void print(int[] a) {
		// TODO 自动生成的方法存根
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
	private static void sortNum(int[] a) {
		int i,j,t;
		// TODO 自动生成的方法存根
		for( i=0;i<a.length-1;i++) {
			for(j=0;j<a.length-1-i;j++) {
				if(a[j]>a[j+1]) {
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
		
	}

	public numSort() {
		// TODO 自动生成的构造函数存根
	}
	public static void main(String[] args) {
		int a[]=new int[args.length];
		for(int i=0;i<args.length;i++) {
			a[i]=Integer.parseInt(args[i]);//把字符串类型转换成整型
		}
		sortNum(a);
		print(a);
	}


}
