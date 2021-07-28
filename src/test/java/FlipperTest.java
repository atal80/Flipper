import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class FlipperTest {
    @BeforeAll
    public static void setup() {
        System.out.println("Flipper App Tests");
    }
    @Test
    public void sanityPositiveTest() {
        int[] arr = {3, 2, 1};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(1, actions.size());
        Assertions.assertEquals(3, actions.get(0));
    }
    @Test
    public void complexFlipPositiveTest() {
        int[] arr = {3, 2, 1, 5, 8, 0};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(8, actions.size());
    }
    @Test
    public void negativeNumbersFlipPositiveTest() {
        int[] arr = {-3, 2, 1, -5, 8, 0};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(8, actions.size());
    }
    @Test
    public void maxIntNumbersFlipPositiveTest() {
        int[] arr = {Integer.MAX_VALUE, 2, 1, -5, 8, 0};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(7, actions.size());
    }
    @Test
    public void minIntNumbersFlipPositiveTest() {
        int[] arr = {Integer.MIN_VALUE, 2, 1, -5, 8, 0};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(9, actions.size());
    }
    @Test
    public void negativeSortedArrTest() {
        int[] arr = {1, 2, 3};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(0, actions.size());
    }
    @Test
    public void negativeEmptyArrTest() {
        int[] arr = {};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(0, actions.size());
    }
    @Test
    public void negativeSmallArrTest() {
        int[] arr = {1};
        Flipper flipper = new Flipper();
        ArrayList<Integer> actions = flipper.flipSort(arr);
        Assertions.assertNotNull(actions);
        Assertions.assertEquals(0, actions.size());
    }
}
