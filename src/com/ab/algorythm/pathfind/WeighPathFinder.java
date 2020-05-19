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
        List<Integer> max = new ArrayList<>();
        restoreLongestPath(cameFromMap, from, new ArrayList<Integer>(), max);


        System.out.println("Abstract Logest Path: ");
        max.forEach(v-> System.out.print(v+"->"));
        System.out.println();
        System.out.println("Shorest Path to the Point: ");
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

    public static void restoreLongestPath(Map<Integer, Integer> map, int from, List<Integer> l, List<Integer> max){
        l.add(from);
        map.forEach((To, CameFrom) -> {
            if(CameFrom == from){
                List<Integer> t = new ArrayList<>();
                t.addAll(l);

                restoreLongestPath(map, To, t, max);
            }
        });
        if(l.size() > max.size()){
            max.clear();
            max.addAll(l);
        }
    }

    private static void setVisitedTrue(int place){
        visited.put(place, true);
    }

}
