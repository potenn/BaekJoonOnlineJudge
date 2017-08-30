package topological_2623;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List <Integer>[]infoList = new ArrayList[N+1];
		
		List <Integer>[]adjList = new ArrayList[N+1];
		for(int i = 1 ; i <=N ; i++){
			adjList[i] = new ArrayList<Integer>();
		}
		int indegrees[] = new int[N+1];
		
		
		for(int i = 1 ; i <= M ; i++){
			
			int numOfRule = sc.nextInt();
			int prev = 0;
			
			List <Integer>list = new ArrayList<Integer>();
			for(int j = 0 ; j < numOfRule ; j++){
				int id = sc.nextInt();
				list.add(id);
				if(prev != 0){
					adjList[prev].add(id);
					indegrees[id]++;
				}
				prev = id;
			}
			infoList[i] = list;
		}
		
		sc.close();
		
		
		Queue<Integer>queue = new LinkedList<Integer>();
		List<Integer>result = new ArrayList<Integer>();
		for(int i = 1 ; i <= N ; i++){
			if(indegrees[i] == 0){
				queue.offer(i);
				result.add(i);
			}
		}
		
		
		
		
		while(!queue.isEmpty()){
			
			int here = queue.poll();
			
			List<Integer> thereList = adjList[here];
			for(int there : thereList){
				
				--indegrees[there];
				if(indegrees[there] == 0){
					queue.offer(there);
					result.add(there);
				}
			}
			
		}
		
		if(result.size() != N){
			System.out.println(0);
		}else{
			for(int i = 0 ; i < result.size() ; i++){
				System.out.println(result.get(i));
			}
		}
		
	}

}
