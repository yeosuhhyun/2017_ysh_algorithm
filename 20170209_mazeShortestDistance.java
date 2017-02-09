import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 *  창의적 알고리즘 미로찾기 p.100
 *  [문제] 너비우선탐색 이용
 *  이 미로는 길과 벽으로 구성되어 있으며, 길은 ".", 
 *  벽은 "#"으로 구성되어 있으며, 
 *  시작위치 "S"와 도착위치 "G"가 존재한다.
 *  제시한 각 정보가 주어질 때, 
 *  S위치로부터 G위치까지의 최단 거리를 구하는 프로그램을 작성하시오.
 *  
 *  [입력]
5 5
#S###
#...#
#.#.#
#....
###G#
 * 
 * [출력]
 * 6
 */
public class Main {
   // 방문여부를 나타내는 배열
   private static int[][] visited;
   
   // S지점과 G지점, 입력값을 받는 변수
   private static int Sa, Sb, Ga, Gb, h, n;
   
   // 한칸씩 움직이기 위한 배열
   private static int dx[] = { 1, 0, -1, 0 };
   private static int dy[] = { 0, 1, 0, -1 };
   
   // 입력받는 값을 저장할 배열
   private static String[][] M;
   
   // 너비우선 탐색을 위한 큐
   private static Queue<Vertex> queue = new LinkedList<Vertex>();

   public static void main(String[] args) {
      //------입력 start
      Scanner scan = new Scanner(System.in);
      h = scan.nextInt();
      n = scan.nextInt();
      visited = new int[h][n];
      M = new String[h][n];
      String temp = "";
      scan.nextLine();
      for (int i = 0; i < h; i++) {
         temp = scan.nextLine();
         // 방문 노드 여부 배열 초기화
         Arrays.fill(visited[i], 0);
         for (int j = 0; j < n; j++) {
            M[i][j] = temp.substring(j, j + 1);

            if (M[i][j].equals("S")) {
               // S지점의 좌표값 저장
               Sa = i;
               Sb = j;
            } else if (M[i][j].equals("G")) {
               // G지점의 좌표값 저장
               Ga = i;
               Gb = j;
               M[i][j] = ".";
            }
         }

      }
      //------입력 end
      scan.close();
      
      // 너비우선 탐색을 사용한 해결 함수
      System.out.println(solve());

   }
   
   
   // 너비우선 탐색을 사용한 해결 함수
   private static int solve() {
      // 시작점 큐에 삽입
      queue.add(new Vertex(Sa, Sb));
      // 0으로 시작해서  점점 숫자를 늘려감.
      visited[Sa][Sb] = 0;
      
      // 큐가 비어있을 때까지 반복
      while (!queue.isEmpty()) {
         // 큐의 맨 앞에 있는 변수를 저장
         Vertex cur = new Vertex(queue.peek().a, queue.peek().b);
         // 삭제
         queue.poll();
         
         // G지점과 좌표가 같아지면 종료.
         if (cur.a == Ga && cur.b == Gb) {
            break;
         }
         
         // 4가지 방향으로 비교.
         for (int i = 0; i < 4; i++) {
            int a = cur.a + dx[i];
            int b = cur.b + dy[i];
            
            // a, b가 배열 밖으로 나가지 않기 위해 이프 조건문의 맨 앞에 위치하여 index 오류가 발생하지 않게 함.
            // 방문하지 않았어야 함.
            // M에는 #과 빈공간이 아닌 . 이 있는 공간이어야 함.
            if (safe(a, b) && visited[a][b] == 0 && M[a][b].equals(".")) {
               
               // 방문 횟수를 증가시켜 거리를 가늠하게 함.
               visited[a][b] = visited[cur.a][cur.b] + 1;
               
               // 새로운 값 큐에 삽입
               queue.add(new Vertex(a, b));
            }

         }

      }
      // 방문횟수 = 최단거리
      return visited[Ga][Gb];
   }
   
   // a,b가 배열 밖으로 나가지 않기 위한 함수
   private static boolean safe(int a, int b) {
      return (0 <= a && a < h) && (0 <= b && b < n);
   }
}

// queue에 두가지 정수를 저장하기 위한 클래스
class Vertex {
   int a;
   int b;

   Vertex(int a, int b) {
      this.a = a;
      this.b = b;
   }
}