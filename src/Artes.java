import javax.swing.*;

class Artes extends JFrame {

    Artes() {

        add(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int width = 800;
        int height = 600;
        setSize(width, height);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
