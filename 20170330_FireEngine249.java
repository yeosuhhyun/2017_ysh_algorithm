package algorithm249;

import java.util.Scanner;

 
/**
 * @author suhyun yeo
 * â���� �˰��� �߱� p.249 
 * ��� �Լ��� �̿��� ��üŽ����
 * [����]
 * �ϳ��� �������� �ϳ��� �ҹ����� ����� �� �ִ�. ����ϴ� ȣ���� ���̴� �����ͼҹ��� ������ �Ÿ��̴�. 
 * �������� ��ġ�� �ҹ������� ��ġ�� �־��� �� ȣ�� ������ ���� �ּҷ� �ϸ鼭 �������� �ҹ����鿡 �����ϴ� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * [�Ϸ�]
 * ù° �ٿ��� ������ ���� ��Ÿ���� ���� p�� �ҹ����� ���� ��Ÿ���� f�� �־�����. 1 �� p �� 11�̰� 1 �� f �� 10�̸� p��f�̴�.
 * ��° �ٿ��� �������� ��ġ�� ��Ÿ���� ���� �ٸ� p���� ������ ������������ �־�����. 
 * ��° �ٿ��� �ҹ������� ��ġ����Ÿ���� ���� �ٸ� f���� ������ ������������ �־�����.
 * ������ �ҹ����� ���� ��ġ�� ���� ���� �ִ�. �־��� ������ ��� 1,000,000 ������ ����̴�
 * 
3 2
12 50 81
27 73
 *
 * [���]
 * ����ϴ� ȣ�� ������ ���� ����Ѵ�. ��� ����� 2^31 - 1�� ���� �ʴ´�.
 * 
 * 23
 */
public class FireEngine249 {
   // ���� ������ ���� �ִ� ����
   private static Pump[] pump;
   // �ҹ��� ������ ���� �ִ� ����
   private static int[] fireEngine;
   
   // ���� ��
   private static int pumpNum;
   // �ҹ��� ��
   private static int fireEngineNum;
   
   // ������ ū �� ����
   private static int sum = 999999999;
   
   public static void main(String[] args) {
      // �Է�
      input();
      
      // ��� �Լ� ȣ��
      for(int i=0; i<pumpNum; i++) {
         solve(0, i, 0);
      }
      
      // �ּҰ� ���
      System.out.println(sum);
   }
   
   /**
    * ��üŽ���� ���� �Լ�
    * @param num : �ҹ����� ������ �Ÿ��� ���ذ��� ����
    * @param pumpCount : ����
    * @param fireCount : �ҹ���
    */
   private static void solve(int num, int pumpCount, int fireCount) {
      // ��� �������� ���� �ּڰ����� ũ�ٸ� ����
      if(num > sum) {
         return;
      } 
      
      // �ϳ��� ����� ���� ���� ������ ��, �ּڰ��� �����ϰ� ����
      if(fireCount >= fireEngineNum) {
         sum = num;
         return;
      }
      
      // �Ÿ� ����ؼ� ����
      num = num + Math.abs(pump[pumpCount].getLocation()-fireEngine[fireCount]);
      pump[pumpCount].setVisited(1);
      // ����Լ� ȣ��
      for(int i = 0; i<pumpNum; i++) {
         // �湮���θ� ���� ������ ������ �������� ����
         if(pump[i].getVisited()==0) {
            solve(num, i, fireCount+1);
            pump[i].setVisited(0);
         }
      }
      
   }
   

   
   /**
    *  �Է��Լ�
    */
   private static void input() {
      Scanner scan = new Scanner(System.in);
      pumpNum = scan.nextInt();
      fireEngineNum = scan.nextInt();
      
      pump = new Pump[pumpNum];
      fireEngine = new int[fireEngineNum];
      
      scan.nextLine();
      
      Pump temp;
      for(int j=0; j < pumpNum; j++) {
         temp = new Pump(scan.nextInt(), 0);
         pump[j] = temp;
      }
      
      scan.nextLine();
      
      for(int i=0; i < fireEngineNum; i++) {
         fireEngine[i] = scan.nextInt();
      }
      
      scan.nextLine();
      
      scan.close();
            
   }

}

// Pump�� ��ġ�� �湮���θ� ��� ��ü
class Pump{
   private int location;
   private int visited;
   
   public Pump() {
      location = 0;
      visited = 0;
   }
   
   public Pump(int location, int visited) {
      super();
      this.location = location;
      this.visited = visited;
   }


   public int getLocation() {
      return location;
   }

   public void setLocation(int location) {
      this.location = location;
   }

   public int getVisited() {
      return visited;
   }

   public void setVisited(int visited) {
      this.visited = visited;
   }
   
}