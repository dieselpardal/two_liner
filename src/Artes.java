import javax.swing.*;

public class Artes extends JFrame {

    int width = 800;
    int height = 600;
    public Artes() {

        add(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
