package com.rcanal.q1466;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    /**
    There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between 
    two different cities (this network form a tree). Last year, The ministry of transport decided to orient the 
    roads in one direction because they are too narrow.

    Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

    Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number 
    of edges changed.
    
    It's guaranteed that each city can reach city 0 after reorder.
    */

    public int reorder = 0;
    public boolean[] visited;

    public static void main(String[] args) {
        final var solution = new Solution();
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int expected = 3;
        int actual = solution.minReorder(n, connections);
        assertEquals(expected, actual);
    }

    public int minReorder(int n, int[][] connections) {
        this.reorder = 0;
        this.visited = new boolean[n + 1];
        final var graphRepresentation = getGraphRepresentation(connections);
        this.visited[0] = true;

        for (int cityNumber = 0; cityNumber < n; cityNumber++) {
            dfs(graphRepresentation, cityNumber);
        }

        return this.reorder;
    }

    private void dfs(HashMap<Integer, HashSet<Integer>> graphRepresentation, Integer cityNumber) {
        final var cityConnections = graphRepresentation.get(cityNumber);
        
        this.visited[cityNumber] = true;

        for (var relatedCity : cityConnections) {
            final var absRelatedCity = Math.abs(relatedCity);
            if (this.visited[absRelatedCity]) {
                continue;
            }

            if (relatedCity < 0)
                this.reorder++;

            dfs(graphRepresentation, absRelatedCity);
        }
    }

    
    private HashMap<Integer, HashSet<Integer>> getGraphRepresentation(int[][] connections) {
        HashMap<Integer, HashSet<Integer>> connectionsGraph = new HashMap<>();

        for (int[] connectionPair : connections) {
            storeCityAndConnections(connectionsGraph, connectionPair);
        }

        return connectionsGraph;
    }

    private void storeCityAndConnections(HashMap<Integer, HashSet<Integer>> connectionsGraph, int[] connectionPair) {
        int fromCity = connectionPair[0];
        int toCity = connectionPair[1];
        updateCityConnections(connectionsGraph, fromCity, toCity * -1);
        updateCityConnections(connectionsGraph, toCity, fromCity);
        
    }

    private void updateCityConnections(HashMap<Integer, HashSet<Integer>> connectionsGraph, int city, int connectedCity) {
        HashSet<Integer> cityConnections = connectionsGraph.getOrDefault(city, new HashSet<>());
        cityConnections.add(connectedCity);
        connectionsGraph.put(city, cityConnections);
    }
}