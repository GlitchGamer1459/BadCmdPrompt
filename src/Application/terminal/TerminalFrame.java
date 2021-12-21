package Application.terminal;

import javax.swing.*;
import java.awt.*;

public class TerminalFrame extends JFrame {

    JTextField inputField;
    JScrollPane scrollPane;
    public JTextArea outputScreen;

    public void setKeyListener(EventHandler e) {
        inputField.addKeyListener(e);
    }

    public TerminalFrame() {
        this.setSize(1000,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Lightning Shell - V3.4");

        inputField = new JTextField();
        inputField.setBounds(0,this.getHeight() - 100,this.getWidth(),62);
        inputField.setBackground(new Color(0x9B9B9B));
        inputField.setBorder(null);
        inputField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        inputField.setForeground(Color.white);
        this.add(inputField);

        outputScreen = new JTextArea();
        outputScreen.setBounds(0,0,this.getWidth(),this.getHeight() - 100 );
        outputScreen.setEditable(false);
        outputScreen.setBackground(new Color(0x181818));
        outputScreen.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        outputScreen.setForeground(Color.WHITE);

        scrollPane = new JScrollPane(outputScreen);
        scrollPane.setBounds(0, 0, this.getWidth(),this.getHeight() - 100);
        scrollPane.createVerticalScrollBar();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setWheelScrollingEnabled(true);
        this.getContentPane().add(scrollPane);

        this.setVisible(true);
    }
}
