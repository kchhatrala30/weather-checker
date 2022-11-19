/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webscrapertest;

import org.jsoup.nodes.Document;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author minis_a
 */
public class MyFrame extends JFrame implements ActionListener {
    private String name;
    private Document doc;
    private City city;
    
    private JComboBox menuBox;
    private JTextField cityName;
    private JButton button;
    private JLabel label;
    private JTextArea textArea;
    
    public MyFrame()
    {
        this.setTitle("Weather Checker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setSize(1000, 750);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }
    
    public void getCity()
    {
        cityName = new JTextField();
        cityName.setPreferredSize(new Dimension(250, 50));
        cityName.addActionListener(this);
        //cityName.setFocusable(false);
        this.add(cityName);
    }
    
    public void loadButton()
    {
        button = new JButton("Load weather for this city");
        button.addActionListener(this);
        //button.setFocusable(false);
        this.add(button);
    }
    
    public void createComboBox()
    {
        String[] menuOptions = {"View the weather at a glance", "View the current temperature",
            "View today's high and low", "View today's entire forecast", "Exit"};
        menuBox = new JComboBox(menuOptions);
        menuBox.addActionListener(this);
        //menuBox.setFocusable(false);
        this.add(menuBox);
    }
    
    public void setIntroLabel()
    {
        label = new JLabel("Enter the name of a city to view its weather:");
        label.setPreferredSize(new Dimension(275, 50));
        this.add(label);
    }
    
    public void displayTextArea()
    {
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        this.add(textArea);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button)
        {
            textArea.setText(null);
            city = new City(cityName.getText());
            doc = city.getCityInfo(cityName.getText());
        }
        
        if (e.getSource() == menuBox)
        {
            int msgNum = menuBox.getSelectedIndex();
            
            switch (msgNum)
            {
                case 0:
                    textArea.setText(city.atAGlance(doc));
                    break;
                case 1:
                    textArea.setText("Current temperature: " + city.currentTemp(doc));
                    break;
                case 2:
                    textArea.setText(city.highAndLow(doc));
                    break;
                case 3:
                    textArea.setText(city.entireForecast(doc, textArea));
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please type in a corresponding number.");
                    System.out.println();
            }
        }
    }
}
