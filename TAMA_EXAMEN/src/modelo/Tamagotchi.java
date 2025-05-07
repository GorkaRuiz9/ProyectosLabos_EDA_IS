
package modelo;
import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.random.RandomGenerator;


public class Tamagotchi extends Observable{
	private int life = 0;
	private int hearts=10;
	private int happy=10;
	private String state = "Egg";
	private boolean hambruna=false;
	private boolean depresion=false;
	
	private static Tamagotchi mTamagochi;
	
	private Tamagotchi () {
		steps();		
	}
	
	public static Tamagotchi getTamagotchi()
	{
		if (mTamagochi==null)
		{
			mTamagochi=new Tamagotchi();
		}
		return mTamagochi;
	}
	public void steps () {
		System.out.print("HOLA");
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				life++;
				eventosAleatorios();
				contadores();
				System.out.println("\nTama "+state+"-> hearts: "+hearts+" -> happy: "+happy);
				setChanged();
				notifyObservers(new Object[] {hearts,happy,state, hambruna,depresion});
			}
		};
		timer.scheduleAtFixedRate(task, 0, 3000);
	}
	
	public void contadores()
	{		
		if (life==5)
		{
			state="Mimitchi";
		}
		else if (life==15)
		{
			state="Mametchi";
		}
		
		if (hearts==0 || happy==0)
		{
			derrota();
		}
	}
	
	private void derrota()
	{
		life = 0;
		hearts=10;
		happy=10;
		state = "Egg";
		hambruna=false;
		depresion=false;
		
		System.out.print("\nOh no, ha muerto!!!");
	}
	
	private void eventosAleatorios()
	{
		Random random = new Random();
		int numAleatorio=random.nextInt(100)+1;
		
		if (numAleatorio<=20 && state!="Egg")
		{
			hambruna=true;
			hearts=random.nextInt(4)+1;
			happy--;
		}
		else if (state!="Egg")
		{
			hearts--;
			happy--;
		}
	}
	
	public void aumentarHearts()
	{
		hearts++;
		if (hearts>10) {hearts=10;}
		if (hearts>=5) {hambruna=false;}
		
		Random random = new Random();
		int numAleatorio=random.nextInt(100)+1;
		
		if (numAleatorio<=30 && state!="Egg")
		{
			depresion=true;
			happy=random.nextInt(2)+1;
			System.out.print("\n"+happy);
		}
		setChanged();
		notifyObservers(new Object[] {hearts,happy,state,hambruna,depresion});
	}
	
	public void aumentarHappy()
	{
		happy++;
		if (happy>10) {happy=10;}
		if (happy>=5) {depresion=false;}
		setChanged();
		notifyObservers(new Object[] {hearts,happy,state,hambruna,depresion});
	}
}
