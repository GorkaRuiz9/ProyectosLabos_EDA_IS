import modelo.Tamagotchi;
import vista.Pantalla;

public class Main {

	
	public static void main(String[] args) {
		//MODELO//
		
		Pantalla pantalla=new Pantalla(Tamagotchi.getTamagotchi());
		pantalla.setVisible(true);
		
		//Tamagotchi.getTamagotchi();
		
		
	}
}
