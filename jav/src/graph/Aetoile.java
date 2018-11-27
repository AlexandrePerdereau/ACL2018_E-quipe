package graph;

import java.util.ArrayList;

import element.MonstreTraqueur;

public class Aetoile implements Runnable{

	private ArrayList<MonstreTraqueur> lMTraqueur = new ArrayList<MonstreTraqueur>();


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
		for (MonstreTraqueur mT:lMTraqueur){

			mT.actualise();

			
		}
		try {
			Thread.sleep(5000);
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
