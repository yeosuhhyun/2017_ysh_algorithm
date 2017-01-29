import java.util.Scanner;
/*
    https://www.acmicpc.net/problem/1924
    ������ 2007�� 1�� 1�� �������̴�. �׷��ٸ� 2007�� x�� y���� ���� �����ϱ�? �̸� �˾Ƴ��� ���α׷��� �ۼ��Ͻÿ�
    ù° �ٿ� �� ĭ�� ���̿� �ΰ� x(1��x��12)�� y(1��y��31)�� �־�����. ����� 2007�⿡�� 1, 3, 5, 7, 8, 10, 12���� 31�ϱ���, 4, 6, 9, 11���� 30�ϱ���, 2���� 28�ϱ��� �ִ�.
    ù° �ٿ� x�� y���� ���� ���������� ���� SUN, MON, TUE, WED, THU, FRI, SAT�� �ϳ��� ����Ѵ�.
    
*/
public class Main{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();
        int sum =0;
        for(int i = 1; i< a; i++) {
        	if( i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) {
        		sum += 31;
        	} else if( i==2 ){
        		sum += 28;
        	} else if( i==4 || i==6 || i==9 || i==11 ){
        		sum +=30;
        	}
        }
        
        sum += b;
        String print = "";
        switch(sum%7){
        case 0:
        	print = "SUN";
        	break;
        case 1:
        	print = "MON";
        	break;
        case 2:
        	print = "TUE";
        	break;
        case 3:
        	print = "WED";
        	break;
        case 4:
        	print = "THU";
        	break;
        case 5:
        	print = "FRI";
        	break;
        case 6:
        	print = "SAT";
        	break;
        	
        }
       
        System.out.println(print);
        
        
    }
}