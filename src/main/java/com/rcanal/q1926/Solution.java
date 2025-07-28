package com.rcanal.q1926;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     * You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). 
     * You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] 
     * denotes the row and column of the cell you are initially standing at.
     * 
     * In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, 
     * and you cannot step outside the maze.
     * Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. 
     * The entrance does not count as an exit.
     * 
     * Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
     */

    public static void main(String[] args) {
        char[][] maze = {
            {'+','.','+','+','+','+','+'},
            {'+','.','+','.','.','.','+'},
            {'+','.','+','.','+','.','+'},
            {'+','.','.','.','+','.','+'},
            {'+','+','+','+','+','.','+'}
        };
        int[] entrance = {3, 2};
        int expected = 4;
        int actual = new Solution().nearestExit(maze, entrance);
        assertEquals(expected, actual);
    }
    

    public int nearestExit(char[][] maze, int[] entrance) {        
        final int rowSize = maze.length -1;
        final int colSize = maze[0].length -1;
        final int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};

        final Queue<int[]> queue = new LinkedList<>();

        int steps = 0;

        queue.add(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        System.out.println("initial position: " + entrance[0] + " " + entrance[1]);

        while (!queue.isEmpty()) {
            steps++;
            System.out.println("new step");

            //check all 'childs' from previous step
            for (int i = 0; i < queue.size(); i++) {
                final int[] position = queue.poll();

                for (int[] direction : directions) {
                    final int row = position[0] + direction[0];
                    final int col = position[1] + direction[1];

                    System.out.println(String.format("walkin into: %s %s", row, col));

                    if (row < 0 
                    || row > rowSize 
                    || col < 0 
                    || col > colSize) {
                        System.err.println("invalid position");
                        continue;
                    }

                    if (maze[row][col] == '+'){
                        System.err.println("wall hit or visited");
                        continue;
                    }

                    //mark as visited
                    maze[row][col] = '+';

                    if (row == 0 
                    || row == rowSize 
                    || col == 0 
                    || col == colSize) {
                        return steps;
                    }

                    queue.add(new int[] {row, col});
                }
            }
        }

        return -1;
    }
}

