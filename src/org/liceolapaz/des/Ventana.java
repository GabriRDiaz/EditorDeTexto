package org.liceolapaz.des;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame {
	public final String PERDIDA = "El texto no guardado se perderá. ¿Desea continuar?";
	private JTextArea txt;
	String fichero = "";
	JPanel panel = null;
	JScrollPane scroll = null;
	public Ventana() {
		super("Documento nuevo");
		setSize(1024, 768);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		crearBarra();
		archivoNuevo();
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
		archivoNuevo.setIcon(new ImageIcon(getClass().getResource("/nuevo.png")));
		archivoNuevo.setMnemonic(KeyEvent.VK_N);
		archivoNuevo.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
		menuArchivo.add(archivoNuevo);
		
		//Archivo --> Abrir
		JMenuItem archivoAbrir = new JMenuItem("Abrir");
		archivoAbrir.setIcon(new ImageIcon(getClass().getResource("/abrir.png")));
		archivoAbrir.setMnemonic(KeyEvent.VK_G);
		archivoAbrir.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		menuArchivo.add(archivoAbrir);
		
		//Archivo --> Guardar
		JMenuItem archivoGuardar = new JMenuItem("Guardar");
		archivoGuardar.setIcon(new ImageIcon(getClass().getResource("/guardar.png")));
		archivoGuardar.setMnemonic(KeyEvent.VK_S);
		archivoGuardar.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		menuArchivo.add(archivoGuardar);
		
		//Archivo --> Guardar como
		JMenuItem archivoGuardarAs = new JMenuItem("Guardar como");
		archivoGuardarAs.setIcon(new ImageIcon(getClass().getResource("/guardarComo.png")));
		archivoGuardarAs.setMnemonic(KeyEvent.VK_G);
		archivoGuardarAs.setAccelerator(KeyStroke.getKeyStroke("ctrl shift S"));
		menuArchivo.add(archivoGuardarAs);
		
		//Archivo --> Salir
		JMenuItem archivoSalir = new JMenuItem("Salir");
		archivoSalir.setIcon(new ImageIcon(getClass().getResource("/salir.png")));
		archivoSalir.setMnemonic(KeyEvent.VK_L);
		archivoSalir.setAccelerator(KeyStroke.getKeyStroke("ctrl L"));
		menuArchivo.add(archivoSalir);
		//Action Listeners
		archivoSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				salida();
			}
		});
		archivoGuardarAs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveAs();
			}
		});
		archivoGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String savePath = path();
				guardar(savePath);
			}
		});
		archivoAbrir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				leerArch();
			}
		});
		archivoNuevo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetNuevo();
			}
		});
		setJMenuBar(barraMenu);
}
	protected String path() {
		 final String GUARDAR = "¿Desea guardar el documento?";
	        int respuesta = JOptionPane.showConfirmDialog(Ventana.this, GUARDAR,
					"Abrir documento", JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				String openPath=JOptionPane.showInputDialog(Ventana.this,"Escriba la ruta completa","Guardar archivo", JOptionPane.QUESTION_MESSAGE);
				return openPath;
		}	return null;
	}
	
	protected void guardar(String path) {
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter(new FileWriter(path+".txt"));
		    writer.write(txt.getText());
		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}	
	}

	private String leerArch() {
        final String ABRIR = "El texto no guardado se perderá. ¿Quiere abrir un documento?";
        int respuesta = JOptionPane.showConfirmDialog(Ventana.this, ABRIR,
				"Entrada", JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			String openPath=JOptionPane.showInputDialog(Ventana.this,"Escriba la ruta completa","Abrir archivo", JOptionPane.QUESTION_MESSAGE);
			if(openPath.endsWith(".txt")) {
			try {
			FileReader fr = new FileReader(openPath);
			BufferedReader br = new BufferedReader(fr);
			String s;
			while((s = br.readLine()) != null) {
			fichero += s;
			plasmarArch();
			}
			br.close();
			} catch(java.io.FileNotFoundException fnfex) {

			System.out.println("Archivo no encontrado: " + fnfex);

			} catch(java.io.IOException ioex) {}
			} else {
				JOptionPane.showMessageDialog(
			null, "Error", "El archivo especificado no es de tipo txt", JOptionPane.ERROR_MESSAGE);
			}
	}
		return fichero;	
}
	private void archivoNuevo() {
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.PINK);
		panel.setLayout(new BorderLayout());
		panel.add(lbEdTxt(), BorderLayout.PAGE_START);
		txt = new JTextArea();
		txt.setCaretColor(Color.WHITE);
		txt.setBackground(Color.BLACK);
		txt.setForeground(Color.MAGENTA);
		txt.setLineWrap(true);
		txt.setFont(fuente());
		scroll = new JScrollPane(txt);
		panel.add(scroll, BorderLayout.CENTER);
		add(panel);
		revalidate();
	}
	private void plasmarArch() {
		if(panel != null) {
			remove(panel);
			archivoNuevo();
		} else {
		remove(panel);
		archivoNuevo();
		}
			txt.setText("");
			txt.setText(fichero);
	}
	
	public void saveAs() {
	    JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new File("/home/gabriel/Desktop"));
	    FileFilter filtro = new FileNameExtensionFilter("Archivo de texto","txt");
	    chooser.setFileFilter(filtro);
	    int retrival = chooser.showSaveDialog(null);
	    if (retrival == JFileChooser.APPROVE_OPTION) {
	        try {
	            FileWriter writer = new FileWriter(chooser.getSelectedFile()+".txt");
			    writer.write(txt.getText());
			    writer.flush();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	}
	
	private void salida() {
        final String SALIR = "El texto no guardado se perderá. ¿Quiere salir?";
    	int respuesta = JOptionPane.showConfirmDialog(Ventana.this, SALIR,
				"Nuevo documento", JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
	}
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
	private void resetNuevo() {
        final String SALIR = "El texto no guardado se perderá. ¿Quiere abrir un nuevo documento?";
    	int respuesta = JOptionPane.showConfirmDialog(Ventana.this, SALIR,
				"Nuevo documento", JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			if(panel != null) {
				remove(panel);
				archivoNuevo();
			} else {
			archivoNuevo();
			}
	}
	}
}