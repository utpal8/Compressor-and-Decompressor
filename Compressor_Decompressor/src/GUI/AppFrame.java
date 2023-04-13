package GUI;

import comp_decomp.compressor;
import comp_decomp.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class AppFrame extends JFrame implements ActionListener{

    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        /*creating the compressor button and setting its size*/
        compressButton = new JButton("Select file to Compressor");
        compressButton.setBounds(20,100,200,30);
        compressButton.addActionListener(this);

        /*creating the decompress button and setting its size*/
        decompressButton = new JButton("Select file to Decompress");
        decompressButton.setBounds(250,100,200,30);
        decompressButton.addActionListener(this);

        /*adding the buttons to the frame*/
        this.add(compressButton);
        this.add(decompressButton);

        /*setting the size of the frame*/
        this.setSize(600,600);

        /*creating a content pane and adding the bacjground color to frame*/
        this.getContentPane().setBackground(Color.BLACK);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    compressor.method(file);
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,exception.toString());
                }
            }
        }

        if(e.getSource() == decompressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    decompressor.method(file);
                }
                catch(Exception exception){
                    JOptionPane.showMessageDialog(null,exception.toString());
                }
            }
        }
    }
}
