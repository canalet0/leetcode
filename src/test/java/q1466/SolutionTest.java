package q1466;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rcanal.q1466.Solution;

class SolutionTest {

    @Test
    public void testExample1() throws Exception {
        int n = 6;
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int expected = 3;
        int actual = new Solution().minReorder(n, connections);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() {
        int n = 5;
        int[][] connections = {{1,0},{1,2},{3,2},{3,4}};
        int expected = 2;
        int actual = new Solution().minReorder(n, connections);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample3() {
        int n = 3;
        int[][] connections = {{1,0},{2,0}};
        int expected = 0;
        int actual = new Solution().minReorder(n, connections);
        assertEquals(expected, actual);
    }
}