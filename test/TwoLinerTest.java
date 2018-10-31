import junit.framework.TestCase;

import java.awt.*;

import static org.mockito.Mockito.*;

public class TwoLinerTest extends TestCase {

    public void testSetSize() {
        Graphics graphics = mock(Graphics.class);
        TwoLiner twoLiner = new cogumelo1();
        twoLiner.setSize(graphics, 1, 2);
        assertEquals(twoLiner.width, 1.0);
        assertEquals(twoLiner.height, 2.0);
    }


    public void testIfn() {
        TwoLiner twoLiner = new cogumelo1();
        double a = twoLiner.ifn(true);
        assertEquals(a, -1.0);
    }


    public void testPoint() {
        Graphics graphics = mock(Graphics.class);
        TwoLiner twoLiner = mock(TwoLiner.class);
        doCallRealMethod().when(twoLiner).point(isA(Graphics.class), any(double.class), any(double.class));
        twoLiner.point(graphics, 10, 10);
        verify(twoLiner, times(1)).point(graphics, 10, 10);

    }

    public void testLine() {
        Graphics graphics = mock(Graphics.class);
        TwoLiner twoLiner = mock(TwoLiner.class);
        doCallRealMethod().when(twoLiner).line(isA(Graphics.class), any(double.class),
                any(double.class), any(double.class), any(double.class));
        twoLiner.line(graphics, 1, 2, 3, 4);
        verify(twoLiner, times(1)).line(graphics, 1, 2, 3, 4);

    }

    public void testCogumelo1() {
        Graphics graphics = mock(Graphics.class);
        TwoLiner twoLiner = mock(cogumelo1.class);
        doCallRealMethod().when(twoLiner).lines(isA(Graphics.class), any(double.class));
        twoLiner.lines(graphics, 1);
        verify(twoLiner, times(1)).lines(graphics, 1);

    }
}