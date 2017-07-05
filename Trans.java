
import java.awt.Color;
import java.io.IOException;
import javax.swing.JFrame;

public class Trans extends JFrame {
    
    public Trans() {
        
        setSize(900, 700);
        setResizable(false);
        setTitle("DOOD");
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Frame());
        setVisible(true);
        
    }
    
    public static void main(String[] args) throws IOException {
        new Trans();
        
    }
}
