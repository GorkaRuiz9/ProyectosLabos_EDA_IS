package Practica4;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class FrameMatriz extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel Dimension;
	private JButton BotonHorizontal;
	private JButton BotonVertical;
	private JButton BotonSurround;
	private JPanel panelMatriz;
	
	JLabel anterior=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMatriz frame = new FrameMatriz(0); //Da igual lo que pongas aqui porque no lo vas a ejecutar desde aqui
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
	public FrameMatriz(int pdim) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getPanelMatriz(), BorderLayout.CENTER);
		crearLabels(pdim);
	}
	
	private void crearLabels(int pdim) {
		int i,j;
		ArrayList<JLabel> listaLabels= new ArrayList<JLabel>();
		panelMatriz.setLayout(new GridLayout(pdim,pdim));
		for(i=0; i<pdim;i++) {
			for(j=0; j<pdim;j++) 
			{
				JLabel labelNew=new JLabel();
				labelNew.setBorder(BorderFactory.createLineBorder(Color.white));
				labelNew.setOpaque(true);
				labelNew.setBackground(Color.darkGray);
				
				panelMatriz.add(labelNew);
				listaLabels.add(labelNew);
				

				labelNew.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						JLabel labelClicado = (JLabel) e.getComponent();
						labelClicado.setOpaque(true);
						labelClicado.setBackground(Color.RED);
						cambiarCoordenadas(listaLabels.indexOf(labelClicado),pdim);
						if (anterior!=null && anterior!=labelClicado)
							{
							anterior.setOpaque(true);
							anterior.setBackground(Color.darkGray);
							}
						
						anterior=labelClicado;
					}
				});

				
				
			}
		}
	}

	private void cambiarCoordenadas(int pvalor, int dim)
	{
		int x,y;
		pvalor=pvalor+1;
		if (pvalor%dim==0)
		{
			x=pvalor/dim;
			y=dim;
		}
		else
		{
			x=pvalor/dim+1;
			y=pvalor%dim;
		}
		Dimension.setText("X: "+x+ "& Y: "+y);
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(4, 1, 0, 0));
			panel.add(getDimension());
			panel.add(getBotonHorizontal());
			panel.add(getBotonVertical());
			panel.add(getBotonSurround());
		}
		return panel;
	}
	private JLabel getDimension() {
		if (Dimension == null) {
			Dimension = new JLabel("X:?? & Y:??");
			Dimension.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return Dimension;
	}
	private JButton getBotonHorizontal() {
		if (BotonHorizontal == null) {
			BotonHorizontal = new JButton("Horizontal");
			BotonHorizontal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					//Lo q hace al pulsar horizontal
				}
			});
		}
		return BotonHorizontal;
	}
	private JButton getBotonVertical() {
		if (BotonVertical == null) {
			BotonVertical = new JButton("Vertical");
			BotonVertical.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					//Lo que hace el Vertical
				}
			});
		}
		return BotonVertical;
	}
	private JButton getBotonSurround() {
		if (BotonSurround == null) {
			BotonSurround = new JButton("Surround");
			BotonSurround.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					//Lo q hace el surround
				}
			});
		}
		return BotonSurround;
	}
	private JPanel getPanelMatriz() {
		if (panelMatriz == null) {
			panelMatriz = new JPanel();
		}
		return panelMatriz;
	}
}
