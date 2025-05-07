import packModelo.Minijuego;

import packVista.Pantalla;

public class MAIN {

	
	public static void main(String[] args)
	{
		Pantalla pantalla=new Pantalla(Minijuego.getMinijuego(),Minijuego.getMinijuego().getMatriz());
		pantalla.setVisible(true);
		
		
	}
}
