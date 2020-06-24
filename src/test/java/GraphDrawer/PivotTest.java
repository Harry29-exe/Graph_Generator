package GraphDrawer;

import code.GraphDrawer.Pivot;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PivotTest {

    @Test
    public void pixelsToX_Test() {
        Pivot pivot = new Pivot(400,400,200,200,50);

        assertEquals(-3.5, pivot.pixelsToX(25),0.1);
    }
}