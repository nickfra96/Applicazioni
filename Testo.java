/* Dato un file di testo, le parole sono delimitate da uno spazi. Si contano le ripetizioni delle parole nel file.
Si è utilizzata una mappa, una TreeMap. La TreeMap ci permette di mantenere ordinate le chiavi. Essendo un TreeMap<String.Integer> gli oggetti 
chiave di tipo String sono gia comparabili. TreeMap utilizzera il compareTo di String. Quindi non è servito in questo caso implementare altri comparatori.
Il risultato sarà del tipo moto=0 (moto non si è ripetuto nessuna volta), casa=1 (la parola casa si è ripetuta 1 volta), ecc. 
Esse verranno stampate in ordine alfabetico.
All'interno sono presenti due implementazioni, HashMap e TreeMap. L'ordinamento di HashMap viene effettuata nel main (commentata la porzione di codice)*/



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Testo {
	
	private String nomeFile;
	//private HashMap<String,Integer> mappa;
	private TreeMap <String,Integer> mappa2;
	
	

//	public HashMap<String, Integer> getMappa() {
//		return mappa;
//	}
//
//	public void setMappa(HashMap<String, Integer> mappa) {
//		this.mappa = mappa;
//	}
	
	

	public TreeMap<String, Integer> getMappa2() {
		return mappa2;
	}

	public void setMappa2(TreeMap<String, Integer> mappa2) {
		this.mappa2 = mappa2;
	}

	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public Testo(String nomeFile,TreeMap<String,Integer> mappa2) throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader(nomeFile));
		String linea = bf.readLine();
		while (linea != null) {
			StringTokenizer st = new StringTokenizer(linea, " ");
			while (st.hasMoreTokens()) {
				
				String record = st.nextToken();
				if (!mappa2.containsKey(record)) {
					mappa2.put(record, 0);
				}
				else {
					mappa2.replace(record, mappa2.get(record)+1);
				}
			}
			linea = bf.readLine();
		}
		
		bf.close();
		
		
	}//testo
	
	
	public static void main(String[] args) {
		
		String nome = new String();
		nome = "/Users/francesconicoletti/Desktop/fileTest.txt";
		//HashMap<String,Integer> mappa = new HashMap<String,Integer>();
		TreeMap <String,Integer> mappa2 = new TreeMap<String,Integer>();
		try {
			Testo t = new Testo(nome,mappa2);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(mappa2.toString());
//		
//		Stream<Map.Entry<String, Integer>> sorted =
//			    mappa.entrySet().stream()
//			       .sorted(Map.Entry.comparingByKey());
//		sorted.forEach(System.out::println);
		//System.out.println(mappa.toString());
		
	}
	

}
