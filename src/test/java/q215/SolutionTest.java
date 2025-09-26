package q215;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rcanal.q215.Solution;

public class SolutionTest {

    @Test
    public void testExample1() throws Exception {
        int[] nums =  {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int expected = 4;
        int actual = new Solution().findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void testExample2() throws Exception {
        int[] nums =  {-1,2,0};
        int k = 2;
        int expected = 0;
        int actual = new Solution().findKthLargest(nums, k);
        assertEquals(expected, actual);
    }
    
}
