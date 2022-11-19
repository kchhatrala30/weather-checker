/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package webscrapertest;

/**
 *
 * @author minis_a
 */
public class WebScraperTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Establish the frame
        MyFrame frame = new MyFrame();
        
        // Place intro label
        frame.setIntroLabel();
        
        // Set up text field
        frame.getCity();
        
        // Load city weather
        frame.loadButton();
        
        // Set up combo box
        frame.createComboBox();
        
        // Weather display
        frame.displayTextArea();
        
        frame.pack();
    }   
}
