package org.liceolapaz.des;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {
	public String perdida = "El texto no guardado se perderá. ¿Desea continuar?";
	public Ventana() {
		super("Documento nuevo");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearBarra();
	}
	
	private void crearBarra() {
		JMenuBar barraMenu = new JMenuBar();
		add(barraMenu);
		//ARCHIVO
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic(KeyEvent.VK_P);
		barraMenu.add(menuArchivo);
		
		//Archivo --> Nuevo
		JMenuItem archivoNuevo = new JMenuItem("Nuevo");
		archivoNuevo.setMnemonic(KeyEvent.VK_N);
		archivoNuevo.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		menuArchivo.add(archivoNuevo);
		
		//Archivo --> Abrir
		JMenuItem archivoAbrir = new JMenuItem("Abrir");
		archivoAbrir.setMnemonic(KeyEvent.VK_G);
		archivoAbrir.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		menuArchivo.add(archivoAbrir);
		
		//Archivo --> Guardar
		JMenuItem archivoGuardar = new JMenuItem("Guardar");
		archivoGuardar.setMnemonic(KeyEvent.VK_S);
		archivoGuardar.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		menuArchivo.add(archivoGuardar);
		
		//Archivo --> Guardar como
		JMenuItem archivoGuardarAs = new JMenuItem("Guardar como");
		archivoGuardarAs.setMnemonic(KeyEvent.VK_G);
		archivoGuardarAs.setAccelerator(KeyStroke.getKeyStroke("ctrl shift S"));
		menuArchivo.add(archivoGuardarAs);
		
		//Archivo --> Salir
		JMenuItem archivoSalir = new JMenuItem("Salir");
		archivoSalir.setMnemonic(KeyEvent.VK_L);
		archivoSalir.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
		menuArchivo.add(archivoSalir);
		//Action Listeners
		archivoSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		archivoGuardarAs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Funciona");
			}
		});
		archivoGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Funciona");
			}
		});
		archivoAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Funciona");
			}
		});
		archivoNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pregunta();
			}
			
			public void pregunta() {
				int respuesta = JOptionPane.showConfirmDialog(Ventana.this, perdida,
							"Nuevo documento", JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION) {
						archivoNuevo();
					} else {
						System.exit(0);
					}
				}
			
			public void archivoNuevo() {
				JPanel panel = new JPanel();
				panel.setBackground(Color.BLACK);
				panel.setForeground(Color.PINK);
				add(panel);
			}
		
		});
		setJMenuBar(barraMenu);
}
}
