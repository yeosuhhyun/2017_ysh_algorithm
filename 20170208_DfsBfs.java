import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.acmicpc.net/problem/1260
 *  DFS와 BFS 탐색한 결과를 출력하라.
 */
public class Main {

	// 방문여부 배열
	static boolean[] isVisit;
	// 인접행령
	static int[][] graph;
	// 정점의 수
	static int vertex;
	// 간선의 수
	static int edge;
	
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		vertex = scan.nextInt();
		edge = scan.nextInt();
		// 시작할 정점
		int startEdge = scan.nextInt();
		scan.nextLine();
		
		queue = new LinkedList<Integer>();
		isVisit = new boolean[vertex];
		graph = new int[vertex][vertex];

		// 초기화
		Arrays.fill(isVisit, false);
		for (int i = 0; i < vertex; i++) {
			Arrays.fill(graph[i], 0);
		}

		// 인접행령에 간선 값 저장
		for (int i = 0; i < edge; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();
			graph[start - 1][end - 1] = 1;
			graph[end - 1][start - 1] = 1;
			scan.nextLine();
		}
		scan.close();


		// DFS 검사
		StringBuffer resultDfs = new StringBuffer();
		resultDfs.append(startEdge);
		dfs(startEdge, resultDfs);
	
		// 방문 행렬 초기화 
		Arrays.fill(isVisit, false);
		
		// BFS 검사
		StringBuffer resultBfs = new StringBuffer();
		resultBfs.append(startEdge);
		bfs(startEdge, resultBfs);
		
		System.out.println(resultDfs);
		System.out.println(resultBfs);
	}

	 public static void bfs(int v, StringBuffer resultBfs){
	        isVisit[v-1] = true;
	        queue.add(v); // Enqueue
	        
	        while(!queue.isEmpty()){
	            v = (int) queue.poll(); // Dequeue
	            for(int i=1;i<=vertex;i++){
	                if(graph[v-1][i-1] == 1 && !isVisit[i-1]){
	                    resultBfs.append(" "+String.valueOf(i));
	                    isVisit[i-1] = true;
	                    queue.add(i); // Enqueue
	                }
	            }
	             
	        }
	 }

	public static void dfs(int v, StringBuffer result) {
		isVisit[v - 1] = true;
		for(int i=1; i<=vertex; i++) {
			if(graph[v-1][i-1]==1 && !isVisit[i-1]) {
				result.append(" "+String.valueOf(i));
				dfs(i, result);
			}
		}
	}
}