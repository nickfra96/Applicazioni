/*Dato un file di testo e una parola, il metodo da come risultato la "lista" delle parole che seguono la parola data.
Es: se in un file di testo sono presenti: (ciao albero bacio ciao albero mela pera ciao banana toro ciao mela ciao banana) il metodo restituirà
una mappa di mappa fatta cosi: {ciao={banana=2, albero=2, mela=1}}.   */


public static HashMap<String, HashMap<String, Integer>> parolaProssimi(String nomeFile, String parola)
			throws IOException {
  
		HashMap<String, HashMap<String, Integer>> prossimi = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> secondaMappa = new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new FileReader(nomeFile));
		String linea = br.readLine();
		while (linea != null) {
			StringTokenizer st = new StringTokenizer(linea, " ");
			while (st.hasMoreTokens()) {

				String p = st.nextToken();
				if (p.equals(parola)) {

					if (st.hasMoreTokens()) {
						String pNext = st.nextToken();

						if (!pNext.equals(parola)) {
							if (!prossimi.containsKey(p)) {

								prossimi.put(p, new HashMap<String, Integer>());
								secondaMappa = prossimi.get(p);

								if (!secondaMappa.containsKey(pNext)) {
									secondaMappa.put(pNext, 1);
									prossimi.replace(p, secondaMappa);
								} else {
									secondaMappa.replace(pNext, secondaMappa.get(pNext) + 1);
									prossimi.replace(p, secondaMappa);
								}

							} else {

								if (!secondaMappa.containsKey(pNext)) {
									secondaMappa.put(pNext, 1);
									prossimi.replace(p, secondaMappa);
								} else {
									secondaMappa.replace(pNext, secondaMappa.get(pNext) + 1);
									prossimi.replace(p, secondaMappa);
								}

							}

						}

					}

				}

			} // stringTokenizer

			linea = br.readLine();

		} // linea(buffered)

		br.close();
		return prossimi;

	}
