package com.pathlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.*;

public class Dijkstras {
	static class Graph{
		int V;
		Map<Character, List<Character>> adj; // Adjacency list
		Map<String, Integer> maplength; // Adjacency list
		
		Graph(int v){
			V = v;
			adj = new HashMap<Character, List<Character>>();
			maplength = new HashMap<String, Integer>();
		}
		
		void addEdge(Character u, Character v, Integer length){
			String key = u.toString() + v.toString();			
			maplength.put(key, length);
			
			if(!adj.containsKey(u)){
				adj.put(u, new ArrayList<Character>());
			}
			adj.get(u).add(v);
		}
		
		Integer getLengthTwoEdge(Character u, Character v)
		{
			Integer result = 0;
			String key = u.toString() + v.toString();			
			if (maplength.containsKey(key)) {
				result = maplength.get(key);	
			}		
			return result;
		}
		
		List<List<Character>> getAllPaths(Character u, Character v){			
						
			List<List<Character>> result = new ArrayList<List<Character>>();
			if(u == v){
				List<Character> temp = new ArrayList<Character>();
				temp.add(u);
				result.add(temp);
				return result;
			}
			boolean[] visited = new boolean[V];
			Deque<Character> path = new ArrayDeque<Character>();
			getAllPathsDFS(u, v, visited, path, result);
			return result;
		}
		
		void getAllPathsDFS(Character u, Character v, boolean[] visited, Deque<Character> path, List<List<Character>> result){
			int index = u - 'A';
			visited[index] = true; // Mark visited
			path.add(u); // Add to the end
			if(u == v){
				result.add(new ArrayList<Character>(path));
			}
			else{
				if(adj.containsKey(u)){
					for(Character i : adj.get(u)){
						int nindex = i - 'A';
						if(!visited[nindex]){
							getAllPathsDFS(i, v, visited, path, result);
						}
					}
				}
			}
			path.removeLast();
			visited[index] = false;
		}
	}
}