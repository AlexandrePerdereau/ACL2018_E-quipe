package graph;

import java.util.ArrayList;

import element.MonstreTraqueur;

public class Aetoile implements Runnable{

	public ArrayList<MonstreTraqueur> lMTraqueur = new ArrayList<MonstreTraqueur>();


	@Override
	public void run() {
		long temps =1000;
		// TODO Auto-generated method stub
		while (lMTraqueur.size()!=0){
			System.out.print("A*");
		for (MonstreTraqueur mT:lMTraqueur){

			mT.actualise();

			
		}
		System.out.print("finactualisation");
		try {
			Thread.sleep(temps);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public Aetoile(ArrayList<MonstreTraqueur> lMTraqueur){
		this.lMTraqueur=lMTraqueur;

	}

}
