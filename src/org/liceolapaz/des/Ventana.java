
package org.liceolapaz.des;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class Ventana extends JFrame {
	public final String PERDIDA = "El texto no guardado se perderá. ¿Desea continuar?";
	private JTextArea txt;
	public Ventana() {
		super("Documento nuevo");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearBarra();
	}
	
	public void crearBarra() {
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
				System.out.println(txt.getText());
			}
		});
		archivoAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		archivoNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pregunta();
			}
			
			public void pregunta() {
				int respuesta = JOptionPane.showConfirmDialog(Ventana.this, PERDIDA,
							"Nuevo documento", JOptionPane.YES_NO_OPTION);
					if (respuesta == JOptionPane.YES_OPTION) {
						archivoNuevo();
					} else {
						System.exit(0);
					}
				}
		});
		setJMenuBar(barraMenu);
}
	private void archivoNuevo() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.PINK);
		panel.setLayout(new BorderLayout());
		panel.add(lbEdTxt(), BorderLayout.PAGE_START);
		txt = new JTextArea();
		txt.setBackground(Color.BLACK);
		txt.setForeground(Color.MAGENTA);
		txt.setLineWrap(true);
		txt.setFont(fuente());
		JScrollPane scroll = new JScrollPane(txt);
		panel.add(scroll, BorderLayout.CENTER);
		add(panel);
		revalidate();
	}
	
	private JLabel lbEdTxt() {
		JLabel lbTexto = new JLabel("Editor de texto");
		lbTexto.setHorizontalAlignment(JLabel.CENTER);
		lbTexto.setForeground(Color.WHITE);
		return lbTexto;
	}
	
	private Font fuente() {
		Font fuente = new Font("Default", 1, 15);
		return fuente;
	}
}