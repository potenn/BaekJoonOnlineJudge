package topological_sort_2252;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int cycle = 0;
	public static void dfs(List<List<Integer>> adjList, Stack <Integer>stack, int here, int visited[], int finished[], int N){
		
		visited[here] = 1;
		List <Integer>temp = adjList.get(here);
		for(int there : temp){
			
			if(visited[there] == 0){
				visited[there] = 1;
				dfs(adjList,stack,there,visited,finished,N);
			}else if(finished[there] == 0){
				cycle =1;
				return;
			}
				
		}
		
		finished[here] = 1;
		stack.push(here);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List <List<Integer>>adjList = new ArrayList<List<Integer>>(N+1);
		
		for(int i = 0 ; i <= N ; i++){
			List<Integer>list = new ArrayList<Integer>();
			adjList.add(list);
		}
		
		for(int i = 1 ; i <= M ; i++){
			
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjList.get(src).add(dest);
			
		}
		sc.close();
		
		int finished[] = new int[N+1];
		int visited[] = new int[N+1];
		Stack <Integer>stack = new Stack<Integer>();
		for(int i = 1 ; i <= N ; i++){
			if(visited[i] == 0){
				dfs(adjList,stack,i,visited,finished,N);
			}
		}
		
		while(!stack.isEmpty()){
			
			System.out.print(stack.pop() + " ");
		}
		
		
	}

}
