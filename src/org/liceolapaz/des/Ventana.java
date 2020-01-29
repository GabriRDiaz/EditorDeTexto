package org.liceolapaz.des;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {
	public Ventana() {
		super();
		setTitle("Documento nuevo");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.YELLOW, 5));
		panel.setBackground(Color.BLACK);
		add(panel);
	}
	
}
