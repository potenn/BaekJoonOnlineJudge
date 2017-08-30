package topological_3665;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static int cycle = 0;
	
	public static void dfs(int map[][], int here, int visited[], int finished[], Stack<Integer> stack, int teamNum){
		
		visited[here] = 1;
		int temp[] = map[here];
		
		for(int there = 1 ; there <= teamNum ; there++){
			if(temp[there] != 0){
				if(visited[there] == 0){
					visited[there] = 1;
					dfs(map,there,visited,finished,stack,teamNum);					
				}
				else if(finished[there] == 0){
					cycle=1;
					return;
				}
			}
		}

		finished[here] = 1;
		stack.push(here);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		int numOfTeam[] = new int[testCase];//팀의 수
	
		List<int[][]> adjList = new ArrayList<int[][]>(testCase);// 각테스트케이스 현황.
		
		int changeNum[] = new int[testCase];
	
		for(int i = 0 ; i < testCase ; i++){
			numOfTeam[i] = sc.nextInt();
			List <Integer>tempRank = new ArrayList<Integer>();
			for(int team = 0 ; team < numOfTeam[i] ; team++){
				int teamNum = sc.nextInt();
				tempRank.add(teamNum);
			}
			
			int map[][] = new int[numOfTeam[i]+1][numOfTeam[i]+1];
			for(int k = 1 ; k <= numOfTeam[i] ; k++){
				for(int kk = k+1 ; kk <= numOfTeam[i] ; kk++){
					map[tempRank.get(k-1)][tempRank.get(kk-1)] = 1;
				}
			}
			adjList.add(map);
			changeNum[i] = sc.nextInt();
			
			for(int change = 0 ; change < changeNum[i] ; change++){
				int src = sc.nextInt();
				int dest = sc.nextInt();
				int tempMap[][] = adjList.get(i);
				if(tempMap[src][dest] == 1){
					tempMap[src][dest] = 0;
					tempMap[dest][src] = 1;	
				}else{
					tempMap[dest][src] = 0;
					tempMap[src][dest] = 1;
				}
			}
			
		}
		sc.close();
		
		for(int i = 0 ; i < testCase ; i++){

			int temp[][] = adjList.get(i);
//			for(int k = 1 ; k <= numOfTeam[i] ; k++){
//				for(int j = 1 ; j<=numOfTeam[i];j++){
//					System.out.print(temp[k][j] + " ");
//				}
//				System.out.println();
//			}

//			System.out.println();
			
			int visited[] = new int[numOfTeam[i] + 1];
			int finished[] = new int[numOfTeam[i] + 1];
			Stack<Integer> stack = new Stack<Integer>();			
			for(int k = 1; k <= numOfTeam[i] ; k++){
				if(visited[k] == 0){
					dfs(temp, k, visited, finished, stack,numOfTeam[i]);
				}
			}
			if(cycle != 1){
				if(stack.size() != numOfTeam[i]){
					System.out.println("?");
				}else{
					while(!stack.isEmpty()){
						System.out.print(stack.pop() + " ");
					}			
					System.out.println();					
				}

			}else{
				System.out.println("IMPOSSIBLE");
			}
			cycle = 0;
		}
		
		
		
		
		
		
	}

}
