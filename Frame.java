
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JPanel implements ActionListener {

    String s = "\n\n    hey I'm DOOD\n\n"
            + "I Created by Diaa Elsayed Ziada (Founder of ZED company)\n"
            + "I'm one of his sons ,The second one\n"
            + "I want to tell you a secret ,don't tell anyone about it\n"
            + "I can do many things like :\n"
            + "\n"
            + "If you want to know meaning of an English word Just write it in me \n"
            + " And i will  search about it in thousands of line from \"Cambridge Dictionary\"\n"
            + " and find it with it's examples ,also create a file contain all data about words you searched for \n"
            + "with name the date of that day in folder with my name to help you to arrangement your engilsh files\n"
            + "\n\n\t\t\t\tyour magical friend Dood";
    private JButton button;
    private JTextField tf;
    private Font font1;
    private Font font2;
    private Font font3;
    private JTextArea ta;
    private JScrollPane jsp;

    private FilesFolders ff;

    private boolean key = true;

    public static String word = " ";

    private Prog p;

    public Frame() {
        ff = new FilesFolders();

        this.setLayout(null);

        font1 = new Font("Arial", Font.BOLD, 20);
        font2 = new Font("Arial", Font.BOLD, 15);
        font3 = new Font("Arial", Font.BOLD, 20);

        button = new JButton("GO");
        button.setBounds(425, 100, 60, 40);
        button.setBackground(Color.WHITE);
        button.setFont(font2);
        button.setForeground(Color.RED);
        button.addActionListener(this);
        button.setVisible(true);
        this.add(button);
        ;

        ta = new JTextArea(s);
        ta.setBounds(20, 160, 860, 420);
        ta.setBackground(Color.WHITE);
        ta.setFont(font2);
        ta.setForeground(Color.BLACK);
        ta.setVisible(true);
        add(ta);

        tf = new JTextField(20);
        tf.setBackground(Color.BLACK);
        tf.setBounds(350, 50, 200, 30);
        tf.setFont(font1);
        tf.setForeground(Color.WHITE);
        tf.setVisible(true);
        this.add(tf);

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(Color.BLACK);
        g.drawRect(10, 150, 880, 440);

        g.setColor(Color.RED);
        g.setFont(new Font("arial", Font.PLAIN, 30));
        g.drawString("ZED ", 780, 650);

        ta.setText(s);

        this.word = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        new Prog(tf.getText());
        if (word != "") {

            s = word;

        } else {
            s = "Word isn't correct !!";
        }
        tf.setText(null);
        this.key = false;

        repaint();

    }

}
