package packModelo;

import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Minijuego extends Observable{

	
	private static Minijuego mMinijuego;
	private int[] matriz=new int[100];
	private int filas=10;
	private int columnas=10;
	private int puntuacion=0;
	
	private int posTama;
	private int posDora;
	
	private int contador=20;
	
	
	
	private Minijuego()
	{
		puntuacion=0;
		steps();
	}
	
	public static Minijuego getMinijuego()
	{
		if (mMinijuego==null)
		{
			mMinijuego=new Minijuego();
		}
		return mMinijuego;
	}
	
	public void crearMatriz()
	{
		Random random=new Random();
		
		for (int i=0;i<filas*columnas;i++)
		{
			int valor=random.nextInt(3)+1;
			matriz[i]=valor;
		}
		
		posTama=random.nextInt(100);
		posDora=random.nextInt(100);
		
		while (posTama==posDora) {posDora=random.nextInt(100);}
	}
	
	
	public void steps () {

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.print(contador);
				contador--;
				if (contador==0) {System.out.print("Se ha acabado el tiempo"); System.exit(0);}
				setChanged();
				notifyObservers(new Object[] {matriz,puntuacion,posTama,posDora});
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);
	}
	public int[] getMatriz()
	{
		crearMatriz();
		return matriz;
	}
	
	public void bajarDureza(int pos)
	{
		int valor=matriz[pos];
		
		if (valor!=0)
		{
			puntuacion=puntuacion+valor;
			matriz[pos]=valor-1;
			setChanged();
			notifyObservers(new Object[] {matriz,puntuacion,posTama,posDora});
		}
	}
	
	public void moverArriba()
	{
		if (posTama>=10)
		{
			posTama=posTama-10;
			if(!comprobarCas(posTama)) {posTama=posTama+10;}
			else
			{
				setChanged();
				notifyObservers(new Object[] {matriz,puntuacion,posTama,posDora});
			}
		}
	}
	
	public void moverAbajo()
	{
		if (posTama<90)
		{
			posTama=posTama+10;
			if(!comprobarCas(posTama)) {posTama=posTama-10;}
			else
			{
				setChanged();
				notifyObservers(new Object[] {matriz,puntuacion,posTama,posDora});
			}
		}
	}
	
	public void moverDerecha()
	{
		if ((posTama+1)%10!=0)
		{
			posTama=posTama+1;
			if(!comprobarCas(posTama)) {posTama=posTama-1;}
			else
			{
				setChanged();
				notifyObservers(new Object[] {matriz,puntuacion,posTama,posDora});
			}
		}
	}
	
	public void moverIzquierda()
	{
		if (posTama%10!=0)
		{
			posTama=posTama-1;
			if(!comprobarCas(posTama)) {posTama=posTama+1;}
			else
			{
				setChanged();
				notifyObservers(new Object[] {matriz,puntuacion,posTama,posDora});
			}
		}
	}
	
	private boolean comprobarCas(int pos)
	{
		if (posDora==pos) {System.exit(0);}
		return matriz[pos]==0;
	}
	
	public void cerrar()
	{
		System.exit(0);
	}
}
