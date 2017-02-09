import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *  â���� �˰��� �̷�ã�� p.100
 *  [����] �ʺ�켱Ž�� �̿�
 *  �� �̷δ� ��� ������ �����Ǿ� ������, ���� ".", 
 *  ���� "#"���� �����Ǿ� ������, 
 *  ������ġ "S"�� ������ġ "G"�� �����Ѵ�.
 *  ������ �� ������ �־��� ��, 
 *  S��ġ�κ��� G��ġ������ �ִ� �Ÿ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
 *  
 *  [�Է�]
5 5
#S###
#...#
#.#.#
#....
###G#
 * 
 * [���]
 * 6
 */
public class Main {
   // �湮���θ� ��Ÿ���� �迭
   private static int[][] visited;
   
   // S������ G����, �Է°��� �޴� ����
   private static int Sa, Sb, Ga, Gb, h, n;
   
   // ��ĭ�� �����̱� ���� �迭
   private static int dx[] = { 1, 0, -1, 0 };
   private static int dy[] = { 0, 1, 0, -1 };
   
   // �Է¹޴� ���� ������ �迭
   private static String[][] M;
   
   // �ʺ�켱 Ž���� ���� ť
   private static Queue<Vertex> queue = new LinkedList<Vertex>();

   public static void main(String[] args) {
      //------�Է� start
      Scanner scan = new Scanner(System.in);
      h = scan.nextInt();
      n = scan.nextInt();
      visited = new int[h][n];
      M = new String[h][n];
      String temp = "";
      scan.nextLine();
      for (int i = 0; i < h; i++) {
         temp = scan.nextLine();
         // �湮 ��� ���� �迭 �ʱ�ȭ
         Arrays.fill(visited[i], 0);
         for (int j = 0; j < n; j++) {
            M[i][j] = temp.substring(j, j + 1);

            if (M[i][j].equals("S")) {
               // S������ ��ǥ�� ����
               Sa = i;
               Sb = j;
            } else if (M[i][j].equals("G")) {
               // G������ ��ǥ�� ����
               Ga = i;
               Gb = j;
               M[i][j] = ".";
            }
         }

      }
      //------�Է� end
      scan.close();
      
      // �ʺ�켱 Ž���� ����� �ذ� �Լ�
      System.out.println(solve());

   }
   
   
   // �ʺ�켱 Ž���� ����� �ذ� �Լ�
   private static int solve() {
      // ������ ť�� ����
      queue.add(new Vertex(Sa, Sb));
      // 0���� �����ؼ�  ���� ���ڸ� �÷���.
      visited[Sa][Sb] = 0;
      
      // ť�� ������� ������ �ݺ�
      while (!queue.isEmpty()) {
         // ť�� �� �տ� �ִ� ������ ����
         Vertex cur = new Vertex(queue.peek().a, queue.peek().b);
         // ����
         queue.poll();
         
         // G������ ��ǥ�� �������� ����.
         if (cur.a == Ga && cur.b == Gb) {
            break;
         }
         
         // 4���� �������� ��.
         for (int i = 0; i < 4; i++) {
            int a = cur.a + dx[i];
            int b = cur.b + dy[i];
            
            // a, b�� �迭 ������ ������ �ʱ� ���� ���� ���ǹ��� �� �տ� ��ġ�Ͽ� index ������ �߻����� �ʰ� ��.
            // �湮���� �ʾҾ�� ��.
            // M���� #�� ������� �ƴ� . �� �ִ� �����̾�� ��.
            if (safe(a, b) && visited[a][b] == 0 && M[a][b].equals(".")) {
               
               // �湮 Ƚ���� �������� �Ÿ��� �����ϰ� ��.
               visited[a][b] = visited[cur.a][cur.b] + 1;
               
               // ���ο� �� ť�� ����
               queue.add(new Vertex(a, b));
            }

         }

      }
      // �湮Ƚ�� = �ִܰŸ�
      return visited[Ga][Gb];
   }
   
   // a,b�� �迭 ������ ������ �ʱ� ���� �Լ�
   private static boolean safe(int a, int b) {
      return (0 <= a && a < h) && (0 <= b && b < n);
   }
}

// queue�� �ΰ��� ������ �����ϱ� ���� Ŭ����
class Vertex {
   int a;
   int b;

   Vertex(int a, int b) {
      this.a = a;
      this.b = b;
   }
}