
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		
		int numOfBuildings = sc.nextInt();

		
		int time[] = new int[500 + 1];
		int result[] = new int[500 + 1];
		int indegrees[] = new int[500 + 1];
		
		
		List<List<Integer>>adjList = new ArrayList<List<Integer>>();
		for(int i = 0 ; i <= numOfBuildings + 1 ; i++){
			List<Integer> list = new ArrayList<Integer>();
			adjList.add(list);
		}
		
		for(int i = 1 ; i <= numOfBuildings ; i++){
			
			time[i] = sc.nextInt();
			while(true){
				
				int minus = sc.nextInt();
				if(minus == -1){
					break;
				}
				adjList.get(minus).add(i);
//				map[minus][i]++;
				indegrees[i]++;
			}
		}
		
		sc.close();
		
//		int count = 0;
		Queue <Integer>queue = new LinkedList<Integer>();
		for(int i = 1 ; i <= numOfBuildings ; i++){
			if(indegrees[i] == 0){
				
				result[i] = time[i];
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()){
			
			int here = queue.peek();
			queue.poll();
			List <Integer>temp = adjList.get(here);
			for(int there : temp){
				indegrees[there]--;
				result[there] = Math.max(result[there], result[here] + time[there]);
				if(indegrees[there] == 0){
					queue.offer(there);
				}
			}
		}
		
		for(int i = 1 ; i <= numOfBuildings ; i++){
			System.out.println(result[i]);
		}

		
	}

}
