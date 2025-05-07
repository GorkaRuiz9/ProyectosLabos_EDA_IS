package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Tamagotchi;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.SwingConstants;

public class Pantalla extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JButton btnNewButton;
	private JButton btnFeed;
	private JLabel label;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_12;
	
	private JLabel[] labelHearts=new JLabel[10];
	private JLabel[] labelHappy=new JLabel[10];
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla(Tamagotchi.getTamagotchi());
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
	public Pantalla(Observable Tamagotchi) {
		
		Tamagotchi.addObserver(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_10 = new JLabel("Hearts");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(135, 4, 163, 14);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_12 = new JLabel("Happy");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setBounds(135, 244, 163, 14);
		contentPane.add(lblNewLabel_12);
		
		JPanel panel = new JPanel();
		panel.setBounds(135, 0, 163, 21);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 10, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 255, 0));
		labelHearts[0]=lblNewLabel;
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(0, 255, 0));
		lblNewLabel_1.setOpaque(true);
		labelHearts[1]=lblNewLabel_1;
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(0, 255, 0));
		lblNewLabel_2.setOpaque(true);
		labelHearts[2]=lblNewLabel_2;
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBackground(new Color(0, 255, 0));
		lblNewLabel_9.setOpaque(true);
		labelHearts[3]=lblNewLabel_9;
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(0, 255, 0));
		lblNewLabel_3.setOpaque(true);
		labelHearts[4]=lblNewLabel_3;
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(0, 255, 0));
		lblNewLabel_4.setOpaque(true);
		labelHearts[5]=lblNewLabel_4;
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBackground(new Color(0, 255, 0));
		lblNewLabel_5.setOpaque(true);
		labelHearts[6]=lblNewLabel_5;
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBackground(new Color(0, 255, 0));
		lblNewLabel_6.setOpaque(true);
		labelHearts[7]=lblNewLabel_6;
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(new Color(0, 255, 0));
		lblNewLabel_7.setOpaque(true);
		labelHearts[8]=lblNewLabel_7;
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBackground(new Color(0, 255, 0));
		lblNewLabel_8.setOpaque(true);
		labelHearts[9]=lblNewLabel_8;
		panel.add(lblNewLabel_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(135, 240, 163, 21);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 10, 0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setOpaque(true);
		lblNewLabel_11.setBackground(Color.GREEN);
		labelHappy[0]=lblNewLabel_11;
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setOpaque(true);
		lblNewLabel_1_1.setBackground(Color.GREEN);
		labelHappy[1]=lblNewLabel_1_1;
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setOpaque(true);
		lblNewLabel_2_1.setBackground(Color.GREEN);
		labelHappy[2]=lblNewLabel_2_1;
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("");
		lblNewLabel_9_1.setOpaque(true);
		lblNewLabel_9_1.setBackground(Color.GREEN);
		labelHappy[3]=lblNewLabel_9_1;
		panel_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setOpaque(true);
		lblNewLabel_3_1.setBackground(Color.GREEN);
		labelHappy[4]=lblNewLabel_3_1;
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setOpaque(true);
		lblNewLabel_4_1.setBackground(Color.GREEN);
		labelHappy[5]=lblNewLabel_4_1;
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setOpaque(true);
		lblNewLabel_5_1.setBackground(Color.GREEN);
		labelHappy[6]=lblNewLabel_5_1;
		panel_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setOpaque(true);
		lblNewLabel_6_1.setBackground(Color.GREEN);
		labelHappy[7]=lblNewLabel_6_1;
		panel_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		lblNewLabel_7_1.setOpaque(true);
		lblNewLabel_7_1.setBackground(Color.GREEN);
		labelHappy[8]=lblNewLabel_7_1;
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setOpaque(true);
		lblNewLabel_8_1.setBackground(Color.GREEN);
		labelHappy[9]=lblNewLabel_8_1;
		panel_1.add(lblNewLabel_8_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 30, 63, 199);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnNewButton = new JButton("play");
		
		btnNewButton.addActionListener(getControler());
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setOpaque(true);
		panel_2.add(btnNewButton);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(370, 30, 63, 199);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnFeed = new JButton("feed");
		btnFeed.addActionListener(getControler());
		btnFeed.setBackground(Color.GRAY);
		panel_2_1.add(btnFeed);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(135, 29, 163, 184);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(Pantalla.class.getResource("/sprites/Egg.png")));
		panel_3.add(label);
	}
	
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
		if (o instanceof Tamagotchi)
		{
			if (arg instanceof Object[])
			{
				Object[] datos=(Object[])arg;
				int hearts=(int) datos[0];
				int happy=(int) datos[1];
				String estado= (String) datos[2];
				boolean hambruna=(boolean)datos[3];
				boolean depresion=(boolean)datos[4];
				cambiarTama(estado);
				cambiarCorazones(hearts,hambruna);
				cambiarHappy(happy,depresion);
				hambruna(hambruna);
				depresion(depresion);
			}
			
			
		}
	}
	
	
	private void cambiarTama (String estado)
	{
		if (estado.equals("Egg"))
		{
			label.setIcon(new ImageIcon(Pantalla.class.getResource("/sprites/Egg.png")));
		}
		else if (estado.equals("Mimitchi"))
		{
			label.setIcon(new ImageIcon(Pantalla.class.getResource("/sprites/Mimitchi.png")));
		}
		else
		{
			label.setIcon(new ImageIcon(Pantalla.class.getResource("/sprites/Mametchi.png")));
		}
	}
	
	private void cambiarCorazones(int verdes, boolean hambruna)
	{
		for (int i=0;i<=verdes-1;i++)
		{
			if (hambruna)
			{
				labelHearts[i].setBackground(Color.RED);
			}
			else
			{
				labelHearts[i].setBackground(new Color(0, 255, 0));
			}
			
		}
		
		for (int j=verdes; j<=9;j++)
		{
			labelHearts[j].setBackground(Color.GRAY);
		}
	}
	
	private void cambiarHappy(int verdes,boolean depresion)
	{
		for (int i=0;i<=verdes-1;i++)
		{
			if (depresion)
			{
				labelHappy[i].setBackground(Color.RED);
			}
			else
			{
				labelHappy[i].setBackground(new Color(0, 255, 0));
			}
			
		}
		
		for (int j=verdes; j<=9;j++)
		{
			labelHappy[j].setBackground(Color.GRAY);
		}
	}
	
	
	private void hambruna (boolean valor)
	{
		if (valor==true)
		{
			lblNewLabel_10.setText("Famine!!!");
			btnNewButton.setBackground(new Color(255, 0, 0));
		}
		else
		{
			btnNewButton.setBackground(new Color(128, 128, 128));
			lblNewLabel_10.setText("Hearts");
		}
	}
	
	
	
	private void depresion (boolean valor)
	{
		if (valor==true)
		{
			lblNewLabel_12.setText("Depression!!!");
			btnFeed.setBackground(new Color(255, 0, 0));
		}
		else
		{
			lblNewLabel_12.setText("Happy");
			btnFeed.setBackground(new Color(128, 128, 128));
		}
	}
	
	
	
	
	
	
private Controler1 controler=null;
	
	private Controler1 getControler()
	{
		if (controler==null)
		{
			controler=new Controler1();
		}
		return controler;
	}
	
	private class Controler1 implements ActionListener
	{

		public void actionPerformed(ActionEvent e) 
		{
			if (e.getSource().equals(btnNewButton))
			{
				Tamagotchi.getTamagotchi().aumentarHearts();
			}
			if (e.getSource().equals(btnFeed))
			{
				Tamagotchi.getTamagotchi().aumentarHappy();
			}
		}
		
	}

	
}
