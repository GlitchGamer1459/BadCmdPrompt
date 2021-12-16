package Application.terminal;

import javax.swing.*;
import java.awt.*;

public class TerminalFrame extends JFrame {

    JTextField inputField;
    public JTextArea outputScreen;

    public void setKeyListener(EventHandler e) {
        inputField.addKeyListener(e);
    }

    public TerminalFrame() {
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Lightning Shell - V2.3");

        inputField = new JTextField();
        inputField.setBounds(0,this.getHeight() - 100,this.getWidth(),62);
        inputField.setBackground(new Color(0x9B9B9B));
        inputField.setBorder(null);
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 15));
        inputField.setForeground(Color.white);
        this.add(inputField);

        outputScreen = new JTextArea();
        outputScreen.setEditable(false);
        outputScreen.setBounds(0,0,this.getWidth(),this.getHeight() - 62 );
        outputScreen.setBackground(new Color(0x181818));
        outputScreen.setFont(new Font("SansSerif", Font.PLAIN, 15));
        outputScreen.setForeground(Color.WHITE);
        this.add(outputScreen);

        this.setVisible(true);
    }
}
