
package start;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
    public GUI() {
       
       initUI();
       
    }
    
    @SuppressWarnings("static-access")
	private String BeginConvert(String xtxt) throws IOException {
    	XMLReader reader = new XMLReader();
    	HandleTableData handle = new HandleTableData();
    	double[][] triangles = reader.getTriangles(xtxt);
    	int[] indices = reader.getIndices(xtxt);
    	if (triangles != null && indices != null) {
    		return handle.ConvertToOBJ(triangles, indices);
    	} else {
    		return "Unexpected error during conversion. :(";
    	}
    }
    
    JTextArea xml;
    JTextArea area;
    
    
    private void initUI() {
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        
        JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        
        JMenuItem cv = new JMenuItem("Convert Model");
        
        file.add(cv);

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	//Exit.
                System.exit(0);
            }
        });
        
        xml = new JTextArea("");
        xml.setBackground(Color.gray);
        xml.setLineWrap(false);
        xml.setSize(250, 600);
        xml.setEditable(true);
        xml.setLocation(250, 0);
        
        area = new JTextArea("To convert a model, paste an XML into the\ngray textbox to the right of this text, then go to\nFile > Convert Model. When it is done\nconverting, an OBJ will be able to be copied\nfrom the gray text box.");
        area.setLineWrap(true);
        area.setSize(250, 600);
        area.setEditable(false);
        
        cv.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		//Code on click convert here.
        		try {
					xml.setText(BeginConvert(xml.getText()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Critical error!");
					e.printStackTrace();
				}
        	}
        });
        
        
        add(area);
        add(xml);
        file.addSeparator();
        file.add(eMenuItem);
        
        menubar.add(file);

        setJMenuBar(menubar);
        
        pack();
        setTitle("Brent \"XanthicDragon\" Duanne's SpiralSpy XML Converter");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }      
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI ex = new GUI();
                ex.setVisible(true);
            }
        });
    }
}
