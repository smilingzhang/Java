package Javademo1;

public class numSort {
	private static void print(int[] a) {
		// TODO �Զ����ɵķ������
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		
	}
	private static void sortNum(int[] a) {
		int i,j,t;
		// TODO �Զ����ɵķ������
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
		// TODO �Զ����ɵĹ��캯�����
	}
	public static void main(String[] args) {
		int a[]=new int[args.length];
		for(int i=0;i<args.length;i++) {
			a[i]=Integer.parseInt(args[i]);//���ַ�������ת��������
		}
		sortNum(a);
		print(a);
	}


}
