/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing1lesson;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Serhiy
 */
public class Swing1Lesson extends JFrame{

    /**
     * @param args the command line arguments
     */
    public Swing1Lesson(String title){
        super(title);
        
        setPreferredSize(new Dimension(400,300));
        
        JPanel panel = new JPanel();
        add(panel);
        JButton btn = new JButton("click");
        btn.setBackground(Color.red);
        panel.add(btn);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        Swing1Lesson window = new Swing1Lesson("My first window");
        
    }
    
}
