package Application.control;

import javax.swing.*;

@SuppressWarnings("unused")
public class Out {
    JTextArea outputScreen;

    public Out(JTextArea outputArea) {
        outputScreen = outputArea;
    }

    public void println() {
        outputScreen.append("\n");
    }

    public void println(String output) {
        outputScreen.append(output + "\n");
    }

    public void println(double output) {
        outputScreen.append(output + "\n");
    }

    public void println(int output) {
        outputScreen.append(output + "\n");
    }

    public void println(char output) {
        outputScreen.append(output + "\n");
    }

    public void println(float output) {
        outputScreen.append(output + "\n");
    }
}
