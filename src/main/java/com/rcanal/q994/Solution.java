package com.rcanal.q994;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    /*
     * You are given an m x n grid where each cell can have one of three values:
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * 
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. 
     * If this is impossible, return -1.
     */

    private int [][] visited;
    private int fresh = 0;
    private Queue<int[]> queue;
    private int minutes = -1;
    private int constraint = 0;

    public static void main(String[] args) {
        int[][] grid = {{0,2}};
        var solution = new Solution();

        var expected = 0;
        var actual = solution.orangesRotting(grid);

        assertEquals(expected, actual);
    }

    public int orangesRotting(int[][] grid) {
        return mySolution(grid);
    }

    private int mySolution(int[][] grid) {
        this.constraint = grid.length;
        this.checkGrid(grid);

        if (queue.isEmpty())
            return -1;

        if (fresh == 0)
            return 0;

        this.rottenOranges();

        if (fresh > 0)
            return -1;
        
        return this.minutes;
    }

    private void checkGrid(int[][] grid) {
        this.queue = new LinkedList<>();
        this.visited = grid;
        this.fresh = 0;
        for (int i = 0; i < this.constraint; i++) {
            for (int j = 0; j < this.constraint; j++) {
                if (visited[i][j] == 2) {
                    this.addNeighbors(new int[] {i, j});
                }
                if (visited[i][j] == 1) {
                    this.fresh++;
                }
            }
        }
    }

    private void rottenOranges() {
        while (!this.queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] pos = this.queue.poll();
                size--;
                this.check(pos);
            }
            this.minutes++;
        }
    }

    private void addNeighbors(int[] pos) {
        int[] left = new int[] {pos[0], pos[1] -1};
        int[] right = new int[] {pos[0], pos[1] +1};
        int[] up = new int[] {pos[0] - 1, pos[1]};
        int[] down = new int[] {pos[0] + 1, pos[1]};
        this.queue.add(left);
        this.queue.add(right);
        this.queue.add(up);
        this.queue.add(down);
    }

    private void check(int[] pos) {
        if (isValid(pos) && visited[pos[0]][pos[1]] == 1) {
            this.fresh--;
            this.visited[pos[0]][pos[1]] = 2;
            addNeighbors(pos);
        }
    }

    private boolean isValid(int[] pos) {
        if (pos[0] >= 0 && pos[0] <= this.constraint - 1 && pos[1] >= 0 && pos[1] <= this.constraint - 1)
            return true;

        return false;
    }
    
}
