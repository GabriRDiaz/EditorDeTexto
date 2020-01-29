package org.liceolapaz.des;

import java.awt.Color;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana() {
		super();
		setTitle("Documento nuevo");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
