import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener, KeyListener {
    Timer t;
    int ASCII = 49;
    int select = 49;
    double step = 0;

    public Board() {
        step = 0;
        t = new Timer(33, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public void openLiner(TwoLiner liner, Graphics graphics, double step) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, liner.width, liner.height);
        graphics.setColor(Color.black);
        liner.lines(graphics, step);
    }

    public void paint(Graphics graphics) {
        TwoLiner[] twoLiners = new TwoLiner[]{new cogumelo2(), new cogumelo3(), new cogumelo4(), new onda(), new petalas(), new anemona(), new batman()};
        int option = select - ASCII;

        if (0<= option && option <= 6) {
            openLiner(twoLiners[select - ASCII], graphics, step);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        step = 0;
        select = e.getKeyCode();
        System.out.println(select);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        step += 0.1;
        if (step > 1000) step = 0;
        repaint();
    }
}
