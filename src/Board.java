import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements ActionListener, KeyListener {
    private int select = 49;
    private double step;

    Board() {
        step = 0;
        Timer t = new Timer(33, this);
        t.start();
        addKeyListener(this);
        setFocusable(true);
    }

    private void openLiner(TwoLiner liner, Graphics graphics, double step) {
        graphics.setColor(Color.WHITE);
        liner.setSize(graphics, getSize().width, getSize().height);

        liner.lines(graphics, step);
    }

    public void paint(Graphics graphics) {
        int option = 0;
        TwoLiner[] twoLiners = new TwoLiner[]{new cogumelo1(), new cogumelo2(), new cogumelo3(),
                new cogumelo4(), new onda(), new petalas(), new anemona(), new batman(),
                new Astroide1(), new Astroide2(), new Cruz(), new Tekening(), new Spirograph()};
        int ASCII = 48;
        int number = 9;
        int letter = 17;
        if (select > ASCII && select <= ASCII + number) {
            option = select - ASCII;
        } else if (select >= ASCII + letter) {
            option = select - (ASCII + 7);
        }
        if (twoLiners.length > option) {
            openLiner(twoLiners[option], graphics, step);
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
        step++;
        if (step > 1000) step = 0;
        repaint();
    }
}
