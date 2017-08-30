package topological_sort_1766;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
//		1번 문제가 가장 쉬운 문제이고 N번 문제가 가장 어려운 문제가 된다.
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int goodNum = sc.nextInt();
		
		List<List<Integer>> adjList = new ArrayList<List<Integer>>();
		PriorityQueue <Integer>queue = new PriorityQueue<Integer>();
		
		
		for(int i = 0 ; i <= N + 1 ; i++){
			List<Integer>list = new ArrayList<Integer>();
			adjList.add(list);
		}
		
		int indegrees[] = new int[N+1];
		
		for(int i = 0 ; i < goodNum ; i++){
			
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjList.get(src).add(dest);
			indegrees[dest]++;
		}
		
		for(int i = 1 ; i <= N ;i++){
			if(indegrees[i] == 0){
				queue.offer(i);
			}
		}

		List<Integer>problemList = new ArrayList<Integer>();
		
		while(!queue.isEmpty()){
			
			int here = queue.poll();
			problemList.add(here);
			List <Integer>temp = adjList.get(here);
			for(int there : temp){
				
				indegrees[there]--;
				if(indegrees[there]== 0){
//					problemList.add(there);
					queue.offer(there);
				}
				
			}
		
		}
		
		for(int value : problemList){
			System.out.print(value + " ");
		}
		
		
		

	
	}

}
