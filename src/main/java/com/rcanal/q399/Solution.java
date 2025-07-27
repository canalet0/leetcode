package com.rcanal.q399;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    /*  
     * You are given an array of variable pairs equations and an array of real numbers values, 
     * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
     *  Each Ai or Bi is a string that represents a single variable.
     * 
     * You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query 
     * where you must find the answer for Cj / Dj = ?.
     * 
     * Return the answers to all queries. If a single answer cannot be determined, return -1.0.
     * 
     * Note: The input is always valid. You may assume that evaluating the queries will not 
     * result in division by zero and that there is no contradiction.
     * 
     * Note: The variables that do not occur in the list of equations are undefined, 
     * so the answer cannot be determined for them.
    */
    
    public static void main(String[] args) {
        /*var equations = List.of(
            List.of("a", "b"),
            List.of("b", "c")
        );
        double[] values = {2.0, 3.0};
        var queries = List.of(
            List.of("a", "c"),
            List.of("b", "a"),
            List.of("a", "e"),
            List.of("a", "a"),
            List.of("x", "x")
        );

        double[] expected = {6.00000,0.50000,-1.00000,1.00000,-1.00000};*/

        var equations = List.of(List.of("x1","x2"),List.of("x2","x3"),List.of("x3","x4"),List.of("x4","x5"));
        double[] values = {3.0,4.0,5.0,6.0};
        var queries = List.of(List.of("x1","x5"),List.of("x5","x2"),List.of("x2","x4"),List.of("x2","x2"),List.of("x2","x9"),List.of("x9","x9"));
        double[] expected = {360.00000,0.008333333333333333,20.00000,1.00000,-1.00000,-1.00000};

        //var queries = List.of(List.of("x5","x2"));
        //double[] expected = {0.008333333333333333};

        final var actual = new Solution().calcEquation(equations, values, queries);
        for (int i = 0; i < actual.length; i++) {
            System.out.println(actual[i]);
        }

        assertArrayEquals(expected, actual);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final var graphRepresentation = this.getGraphRepresentation(equations, values);
        final var result = new double[queries.size()];


        for (int i = 0; i < queries.size(); i++) {
            result[i] = -1;
            final var queryNominator = queries.get(i).get(0);
            final var queryDenominator = queries.get(i).get(1);

            //if nominator or denominator does not exists the calculation is invalid
            if (!graphRepresentation.containsKey(queryNominator) || !graphRepresentation.containsKey(queryDenominator))
                continue;

            if (queryNominator.equals(queryDenominator)) {
                result[i] = 1;
                continue;
            }
            
            //simple result
            if (graphRepresentation.get(queryNominator).containsKey(queryDenominator)) {
                result[i] = graphRepresentation.get(queryNominator).get(queryDenominator).doubleValue();
                continue;
            }

            //look to possible paths
            System.out.println("starting dfs");
            dfs(queryNominator, queryDenominator, new HashSet<>(), graphRepresentation, result, i, 1);
        }

        return result;
    }

    private HashMap<String, HashMap<String,Double>> getGraphRepresentation(List<List<String>> equations, double[] values) {
        final HashMap<String, HashMap<String,Double>> graphRepresentation = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            final var equationPair = equations.get(i);
            
            final var fromValue = graphRepresentation.getOrDefault(equationPair.get(0), new HashMap<String,Double>());
            fromValue.put(equationPair.get(1), values[i]);
            graphRepresentation.put(equationPair.get(0), fromValue);
            
            final var toValue = graphRepresentation.getOrDefault(equationPair.get(1), new HashMap<String,Double>());
            toValue.put(equationPair.get(0), 1 / values[i]);
            graphRepresentation.put(equationPair.get(1), toValue);
        }

        return graphRepresentation;
    }

    private void dfs(String nominator, String denominator, HashSet<String> visited, HashMap<String, HashMap<String,Double>> graph, double[] result, int index, double pathSum) {
        visited.add(nominator);

        if (nominator.equals(denominator))
            result[index] = pathSum;

        final var children = graph.get(nominator);

        for (var child: children.keySet()) {
            if (visited.contains(child)) {
                continue;
            }

            dfs(child, denominator, visited, graph, result, index, pathSum * children.get(child));
        }
    }
}
