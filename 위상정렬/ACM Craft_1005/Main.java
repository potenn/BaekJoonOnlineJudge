package dp_topological_1005;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Building implements Comparable<Building>{
	
	int id;
	int cost;
	
	public Building(int id, int cost){
		this.id = id;
		this.cost = cost;
	}

	@Override
	public int compareTo(Building o) {
		// TODO Auto-generated method stub
		if(this.cost < o.cost){
			return 1;
		}else if(this.cost > o.cost){
			return -1;
		}
		return 0;
	}
	
}

public class Main {

	
	public static void bfs(int testCase, int result[], List<int[]>buildingList, List <List<int[]>>infoListOfList, int winBuilding[], int N[], int K[]){
		
		int num = N[testCase];
		int indegrees[] = new int[num];
		
		List <List<Integer>>adjList = new ArrayList<List<Integer>>();
		for(int i = 0 ; i < num ; i++){
			adjList.add(new ArrayList<Integer>());
		}	
		
		
			
		List<int[]>infoList = infoListOfList.get(testCase);
		for(int i = 0 ; i < infoList.size(); i++){
			adjList.get(infoList.get(i)[0]-1).add(infoList.get(i)[1]-1);
			indegrees[infoList.get(i)[1]-1]++;
		}
		Queue<Integer>queue= new LinkedList<Integer>();
		
		for(int i = 0 ; i < num ; i++){
			if(indegrees[i] == 0){
				queue.offer(i);
			}
		}
		
		while(indegrees[winBuilding[testCase]-1] > 0){
			
				int here = queue.peek();
				queue.poll();
				List <Integer>temp = adjList.get(here);
				for(int there : temp){
					indegrees[there]--;
					result[there] = Math.max(result[there], result[here] + buildingList.get(testCase)[here]);
					if(indegrees[there] == 0){
						queue.offer(there);
					}
				}	
		}
//	
		System.out.println(result[winBuilding[testCase]-1] + buildingList.get(testCase)[winBuilding[testCase]-1]);
//		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		
		int N[] = new int[testCase]; //건물 개수
		int K[] = new int[testCase]; //규칙 개수
		int winBuilding[] = new int[testCase]; //이기기위한 빌딩넘버
		
		
		List <int[]>buildingList = new ArrayList<int[]>(testCase);//각 건물당 걸리는 시간.

		List <List<int[]>>infoListOfList = new ArrayList<List<int[]>>(testCase);
		
		
		for(int i = 0 ; i < testCase ; i++){
			List <int[]>infoRuleList = new ArrayList<int[]>();	
			N[i] = sc.nextInt();
			K[i] = sc.nextInt();
			int arr[] = new int[N[i]];
			for(int j = 0 ; j < N[i] ; j++){
				arr[j] = sc.nextInt();
			}
			buildingList.add(arr);
			
			for(int k = 0 ; k < K[i] ; k++){
				int rule[] = new int[2];
				rule[0]	= sc.nextInt();
				rule[1] = sc.nextInt();
				infoRuleList.add(rule);
			}
			infoListOfList.add(infoRuleList);
			winBuilding[i] = sc.nextInt();
			
		}
		for(int i = 0 ; i < testCase ; i++){
//			if(i == 1){
				int result[] = new int[N[i]]; 
						//buildingList.get(i);
				bfs(i, result, buildingList, infoListOfList, winBuilding, N, K);				
//			}
	
		}
		
		
		
		
		
		
		
		
	}

}
