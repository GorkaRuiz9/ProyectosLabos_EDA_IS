package Practica4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Ejercicio1 extends JFrame {

	private JPanel contentPane;
	private JRadioButton RadioButton10;
	private JRadioButton RadioButton5;
	private JButton btnNewButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 frame = new Ejercicio1();
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
	public Ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		contentPane.add(getRadioButton5());
		contentPane.add(getRadioButton10());
		contentPane.add(getBtnNewButton());
	}
	private JRadioButton getRadioButton10() {
		if (RadioButton10 == null) {
			RadioButton10 = new JRadioButton("10x10");
			buttonGroup.add(RadioButton10);
			RadioButton10.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return RadioButton10;
	}
	private JRadioButton getRadioButton5() {
		if (RadioButton5 == null) {
			RadioButton5 = new JRadioButton("5x5");
			buttonGroup.add(RadioButton5);
			RadioButton5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return RadioButton5;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Go!");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
					int dim=0;
					if(RadioButton10.isSelected())
					{
						dim=10;
					}
					else if (RadioButton5.isSelected())
					{
						dim=5;
					}
					setVisible(false);
					FrameMatriz frameM = new FrameMatriz(dim);
					frameM.setVisible(true);
					
				}
			});
		}
		return btnNewButton;
	}
}
