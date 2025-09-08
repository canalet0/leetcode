package q994;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rcanal.q994.Solution;

public class SolutionTest {

    @Test
    public void testExample1() throws Exception {
        int[][] grid =  {{2,1,1},{1,1,0},{0,1,1}};
        int expected = 4;
        int actual = new Solution().orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() throws Exception {
        int[][] grid =  {{2,1,1},{0,1,1},{1,0,1}};
        int expected = -1;
        int actual = new Solution().orangesRotting(grid);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() throws Exception {
        int[][] grid =  {{0,2}};
        int expected = 0;
        int actual = new Solution().orangesRotting(grid);
        assertEquals(expected, actual);
    }

    
}
