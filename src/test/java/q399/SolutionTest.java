package q399;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.rcanal.q399.Solution;

public class SolutionTest {

    @Test
    public void testExample1() {
        var equations = List.of(
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

        double[] expected = {6.00000,0.50000,-1.00000,1.00000,-1.00000};

        final var actual = new Solution().calcEquation(equations, values, queries);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testExample4() {
        var equations = List.of(List.of("x1","x2"),List.of("x2","x3"),List.of("x3","x4"),List.of("x4","x5"));
        double[] values = {3.0,4.0,5.0,6.0};
        var queries = List.of(List.of("x1","x5"),List.of("x5","x2"),List.of("x2","x4"),List.of("x2","x2"),List.of("x2","x9"),List.of("x9","x9"));
        double[] expected = {360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000};

        final var actual = new Solution().calcEquation(equations, values, queries);
        assertArrayEquals(expected, actual);
    }
    
}
