package q1926;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rcanal.q1926.Solution;

public class SolutionTest {

    @Test
    public void testExample1() throws Exception {
        char[][] maze = {
            {'+', '+', '.', '+'},
            {'.', '.', '.', '+'},
            {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 2};
        int expected = 1;
        int actual = new Solution().nearestExit(maze, entrance);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() throws Exception {
        char[][] maze = {
            {'.', '+'}
        };
        int[] entrance = {0, 0};
        int expected = -1;
        int actual = new Solution().nearestExit(maze, entrance);
        assertEquals(expected, actual);
    }
    

    @Test
    public void testExample16() throws Exception {
        char[][] maze = {
            {'+','.','+','+','+','+','+'},
            {'+','.','+','.','.','.','+'},
            {'+','.','+','.','+','.','+'},
            {'+','.','.','.','+','.','+'},
            {'+','+','+','+','+','.','+'}
        };
        int[] entrance = {0, 1};
        int expected = 12;
        int actual = new Solution().nearestExit(maze, entrance);
        assertEquals(expected, actual);
        
    }

    @Test
    public void testExample174() throws Exception {
        char[][] maze = {
            {'+','.','+','+','+','+','+'},
            {'+','.','+','.','.','.','+'},
            {'+','.','+','.','+','.','+'},
            {'+','.','x','.','+','.','+'},
            {'+','+','+','+','+','.','+'}


            
        };
        int[] entrance = {3, 2};
        int expected = 4;
        int actual = new Solution().nearestExit(maze, entrance);
        assertEquals(expected, actual);   
    }
}
