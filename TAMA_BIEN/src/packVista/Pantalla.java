package packVista;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import packModelo.Minijuego;


import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Pantalla extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JPanel matriz;
	private JLabel puntuacion;
	private JLabel exit;
	
	private ArrayList<JLabel> labels=new ArrayList<JLabel>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla(Minijuego.getMinijuego(),Minijuego.getMinijuego().getMatriz());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pantalla(Observable Minijuego, int[] matrizO) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel norte = new JPanel();
		norte.setBackground(new Color(0, 0, 0));
		panel.add(norte, BorderLayout.NORTH);
		norte.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel Nombre = new JLabel("Mimitchi");
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setForeground(new Color(255, 255, 255));
		norte.add(Nombre);
		
		puntuacion = new JLabel("Score: 0");
		puntuacion.setHorizontalAlignment(SwingConstants.CENTER);
		puntuacion.setForeground(new Color(255, 255, 255));
		norte.add(puntuacion);
		
		exit = new JLabel("exit");
		exit.setForeground(new Color(255, 255, 255));
		exit.setHorizontalAlignment(SwingConstants.CENTER);
		norte.add(exit);
		exit.addMouseListener(getControler());
		
		JPanel sur = new JPanel();
		sur.setBackground(new Color(0, 0, 0));
		panel.add(sur, BorderLayout.SOUTH);
		sur.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("oooh... still far away!!!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sur.add(lblNewLabel, BorderLayout.NORTH);
		
		matriz = new JPanel();
		matriz.setBackground(new Color(0, 0, 0));
		panel.add(matriz, BorderLayout.CENTER);
		matriz.setLayout(new GridLayout(10, 10, 0, 0));
		matriz.addKeyListener(getControler());
		matriz.setFocusable(true);
		
		crearMatriz();
		actualizarMatriz(matrizO, -1, -1);
		Minijuego.addObserver(this);
	}

	
	private void crearMatriz()
	{
		for (int i=0;i<100;i++)
		{
			JLabel label=new JLabel();
			label.setOpaque(true);
			label.addMouseListener(getControler());
			
			labels.add(label);
			matriz.add(label);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if (o instanceof Minijuego)
		{
			if (arg instanceof Object[])
			{
				Object[] datos=(Object[])arg;
				int[] matrizM=(int [])datos[0];
				int posTama=(int)datos[2];
				int posDora=(int)datos[3];
				int puntuacion=(int) datos[1];
				
				actualizarMatriz(matrizM,posTama,posDora);
				cambiarPuntuacion(puntuacion);
			}
		}
		
	}
	
	private void actualizarMatriz(int[] matrizM,int tama, int dora)
	{
		for (int i=0;i<100;i++)
		{
			if (matrizM[i]==3)
			{
				labels.get(i).setBackground(new Color(145, 6, 6));
			}
			else if (matrizM[i]==2)
			{
				labels.get(i).setBackground(new Color(201, 29, 29));
			}
			else if (matrizM[i]==1)
			{
				labels.get(i).setBackground(new Color(246, 4, 4));
			}
			else
			{
				labels.get(i).setBackground(Color.BLACK);
				if (i==tama) {labels.get(i).setIcon(new ImageIcon(Pantalla.class.getResource("/SpritesTama/MimitchiMini1.png")));}
				else {labels.get(i).setIcon(null);}
				if (i==dora) {labels.get(i).setIcon(new ImageIcon(Pantalla.class.getResource("/SpritesTama/dorayakiSmall.png")));}
			}
			labels.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	private void cambiarPuntuacion(int puntos)
	{
		puntuacion.setText("Score: "+puntos);
	}
	
	
	
	private Controler controler;
	
	private Controler getControler()
	{
		if (controler==null)
		{
			controler= new Controler();
		}
		return controler;
	}
	
	private class Controler implements MouseListener, KeyListener
	{

		@Override
		public void mouseClicked(MouseEvent e) {

			if (e.getSource().equals(exit))
			{
				Minijuego.getMinijuego().cerrar();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			if (labels.contains(e.getSource()))
			{
				int valor=labels.indexOf(e.getSource());
				Minijuego.getMinijuego().bajarDureza(valor);
			}
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if (e.getKeyCode()==KeyEvent.VK_W)
			{
				Minijuego.getMinijuego().moverArriba();
			}
			else if (e.getKeyCode()==KeyEvent.VK_A)
			{
				Minijuego.getMinijuego().moverIzquierda();
			}
			else if (e.getKeyCode()==KeyEvent.VK_S)
			{
				Minijuego.getMinijuego().moverAbajo();
			}
			else if (e.getKeyCode()==KeyEvent.VK_D)
			{
				Minijuego.getMinijuego().moverDerecha();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
