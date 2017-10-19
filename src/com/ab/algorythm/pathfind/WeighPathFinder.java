package com.ab.algorythm.pathfind;

import java.util.*;

public class WeighPathFinder {

    private static Queue<Integer> frontier;
    private static Map<Integer, Boolean> visited;
    private static Map<Integer, Integer> cameFromMap;

    public static List<Integer> findPath(int from, int to, SimpleGraph graph){
        int current;
        frontier  = new ArrayDeque<>();
        frontier.add(from);
        visited = new HashMap<>();
        setVisitedTrue(from);
        cameFromMap = new HashMap<>();
        // while deque isn't empty get(and remove) first element and search for the neighbor that not visited
        // put them to deque and to set as new key in cameFromMap with temp value
        while (!frontier.isEmpty()){
            current = frontier.poll();
            //temp is came from position
            int temp = current;
            for(int next : graph.getNeighbors(current)){
                if (!visited.containsKey(next)){
                    frontier.add(next);
                    cameFromMap.put(next, temp);
                    setVisitedTrue(next);
                }
            }
        }
        current = to;
        ArrayList<Integer> path = new ArrayList<>();
        path.add(to);
        while(current!=from){
            current = cameFromMap.get(current);
            path.add(current);
        }
        Collections.reverse(path);
        return path;
    }

    private static void setVisitedTrue(int place){
        visited.put(place, true);
    }

}
