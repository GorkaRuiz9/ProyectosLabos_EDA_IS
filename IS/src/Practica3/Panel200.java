package Practica3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Panel200 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel_2;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_3;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel200 frame = new Panel200();
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
	public Panel200() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_1(), BorderLayout.NORTH);
		getContentPane().add(getPanel_2(), BorderLayout.EAST);
		getContentPane().add(getPanel_3(), BorderLayout.CENTER);
		crearButtons();

	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnNewButton());
			panel.add(getBtnNewButton_1());
			panel.add(getBtnNewButton_2());
			panel.add(getBtnNewButton_3());
		}
		return panel;
	}
	
	private void crearButtons() 
	{ 
		int i,j; 
		for(i=0; i<10;i++) { 
			for(j=0; j<10;j++) { 
				panel_4.add(cbt("@"+(i*10+j))); 
				panel_5.add(cbt("#"+(i*10+j))); 
			}
		}
	}
	
	private JButton cbt(String pNombre) { //parámetros de entrada 
		JButton btnNewButton = new JButton(pNombre); //texto del botón 
		return btnNewButton; 
		
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("B1");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("B2");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("B3");
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("B4");
		}
		return btnNewButton_3;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLblNewLabel());
		}
		return panel_1;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("juego");
		}
		return lblNewLabel;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(0, 1, 0, 0));
			panel_2.add(getRdbtnNewRadioButton());
			panel_2.add(getRdbtnNewRadioButton_1());
			panel_2.add(getRdbtnNewRadioButton_3());
			panel_2.add(getRdbtnNewRadioButton_2());
		}
		return panel_2;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("R1");
			buttonGroup.add(rdbtnNewRadioButton);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnNewRadioButton_1() {
		if (rdbtnNewRadioButton_1 == null) {
			rdbtnNewRadioButton_1 = new JRadioButton("R2");
			buttonGroup.add(rdbtnNewRadioButton_1);
		}
		return rdbtnNewRadioButton_1;
	}
	private JRadioButton getRdbtnNewRadioButton_2() {
		if (rdbtnNewRadioButton_2 == null) {
			rdbtnNewRadioButton_2 = new JRadioButton("R4");
			buttonGroup.add(rdbtnNewRadioButton_2);
		}
		return rdbtnNewRadioButton_2;
	}
	private JRadioButton getRdbtnNewRadioButton_3() {
		if (rdbtnNewRadioButton_3 == null) {
			rdbtnNewRadioButton_3 = new JRadioButton("R3");
			buttonGroup.add(rdbtnNewRadioButton_3);
		}
		return rdbtnNewRadioButton_3;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new GridLayout(1, 2, 0, 0));
			panel_3.add(getPanel_4());
			panel_3.add(getPanel_5());
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(new GridLayout(10, 10, 0, 0));
		}
		return panel_5;
	}
}
