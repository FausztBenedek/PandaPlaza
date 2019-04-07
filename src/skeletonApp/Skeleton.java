package skeletonApp;

import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import objektumok.*;

/**
 * Utility osztály, amely a metódusok nevének kiírásáért felelős.
 */
public class Skeleton {

	/**
	 * A skeleton osztály csak akkor ír ki bármit is, ha
	 * ez a változó true.
	 */
	private static boolean started = false;
	
	/**
	 * Megadja, hány tabulátorral kell behúzni a sort.
	 */
	private static int tabok = 0;
	
	/**
	 * Kiírja a paraméterül kapott stringet (a metódus neve) a 
	 * megfelelő tabulálással, és a következőkben egyel
	 * beljebb állítja.
	 * 
	 * @param methodName - A metódus neve, amit ke kell írni
	 */
	public static void print(Object object, String methodName) {
		/*if (started) {
			for (int i = 0; i < tabok; i++) {
				System.out.print("\t");
			}
			System.out.println(Skeleton.getObjectName(object)+"."+methodName+"()");
			tabok++;
		}*/
	}

	/**
	 * Kiírja a hívott függvény nevét a megfelelő paraméterekkel, tabulálásokkal, hozzá tartozó objektummal.
	 * @param object A hívó objektum
	 * @param methodName A hívott függvény neve
	 * @param params A paraméterek
	 */
	public static void print(Object object, String methodName, Object... params) {
		/*if (started) {
			for (int i = 0; i < tabok; i++) { //Szükséges mennyiségű tabulátor beszúrása
				System.out.print("\t");
			}
			String paramNames = "";
			// Minden objektum paramétert átfordít stringre: ha regisztrálva van, akkor a regisztrált nevét, ha nincs, akkor a ToString()-jét írja ki			
			for(int i = 0; i < params.length; i++)
				paramNames += params[i]==null?"null, ":getObjectName(params[i])!=null ? getObjectName(params[i])+", " : params[i].toString()+", ";
			if(paramNames.endsWith(", ")) paramNames = paramNames.substring(0, paramNames.length()-2);	
			System.out.println(Skeleton.getObjectName(object)+"."+methodName+"("+paramNames+")");
			tabok++;
		}*/
	}
	
	/**
	 * Eggyel kijjebb állítja a tabulálást.
	 * @throws IllegalStateException - Ha többször lett meghívva, mint a print
	 */
	public static void ret() {
		if (started) {
			tabok--;
			if (tabok < 0) {
				throw new IllegalStateException("Tabulálás nem lehet negatív");
			}
		}
	}
	
	private static HashMap<Object, String> objektumok = new HashMap<Object, String>();
	/**
	 * Regisztrálja az objektumot a skeletonba
	 * @param o A regisztrálandó objektum
	 * @param szoveg A regisztált objektum neve
	 */
	public static void addObject(Object o, String szoveg) {	
		objektumok.put(o, szoveg);
	}
	
	/**
	 * Visszaadja egy regisztrált objektum nevét
	 * @param o A regisztrált objektum
	 * @return Az objektum neve
	 */
	public static String getObjectName(Object o) {
		return objektumok.get(o);
	}
	
	public static Object getObjectFromName(String s) {
		for(Entry<Object, String> entry : objektumok.entrySet()) {
			if(entry.getValue().equals(s))
				return entry.getKey();
		}
		return null;
	}
	
	/**
	 * Elindítja a forgatókönyvet.
	 */
	public static void startForgatokonyv() {
		started = true;
	}
	
	/**
	 * Visszaállítja az osztályt 
	 * az kiindulási állapotba.
	 */
	public static void finishForgatokonyv() {
		started = false;
		objektumok.clear();
	}
	
	public static void load(String palyanev) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(palyanev));
			String sor;
			ArrayList<String> commands = new ArrayList<String>();		
			while ((sor = br.readLine()) != null) {
				if(!sor.equals("")) {
					commands.add(sor);
					String[] splitelt = sor.split(" ");
					String tipus = splitelt[0];
					String nev = splitelt[1];
					if(tipus.equals("Csempe")) {
						Skeleton.addObject(new Csempe(), nev);					
					} else if(tipus.equals("Orangutan")) {
						Skeleton.addObject(new Orangutan(), nev);
					} else if(tipus.equals("Game")) {						
						Skeleton.addObject(new Game(), nev);
					} else if(tipus.equals("Csokiautomata")) {
						Skeleton.addObject(new Csokiautomata(), nev);
					} else if(tipus.equals("Jatekgep")) {
						Skeleton.addObject(new Jatekgep(), nev);
					} else if(tipus.equals("Fotel")) {
						Skeleton.addObject(new Fotel(), nev);
					} else if(tipus.equals("Szekreny")) {
						Skeleton.addObject(new Szekreny(), nev);
					} else if(tipus.equals("Kijarat")) {
						Skeleton.addObject(new Kijarat(), nev);
					} else if(tipus.equals("Torekenycsempe")) {
						Skeleton.addObject(new Torekenycsempe(), nev);
					} else if(tipus.equals("Ugros")) {
						Skeleton.addObject(new Ugros(), nev);
					} else if(tipus.equals("Ulos")) {
						Skeleton.addObject(new Ulos(), nev);
					} else if(tipus.equals("Ijedos")) {
						Skeleton.addObject(new Ijedos(), nev);
					} 
				}
				else
					break;
			}
			
			for(int j = 0; j < commands.size(); j++) {
				String[] commandszavak = commands.get(j).split(" ");
				String tipus = commandszavak[0];
				String nev = commandszavak[1];
				if(tipus.equals("Csempe")) {
					Csempe cs = (Csempe)Skeleton.getObjectFromName(nev);
					cs.setDolog((Dolog)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					for(int i = 3; i < commandszavak.length; i++) {
						String[] szosplit = commandszavak[i].split(":");
						cs.setNeighbour(Integer.parseInt(szosplit[0]), (Csempe)Skeleton.getObjectFromName(szosplit[1]));
					}
				} else if(tipus.equals("Torekenycsempe")) {	
					Torekenycsempe torekeny = (Torekenycsempe)Skeleton.getObjectFromName(nev);
					torekeny.setDolog((Dolog)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					torekeny.setElettartam(Integer.parseInt(commandszavak[3].split(":")[1]));  
					for(int i = 4; i < commandszavak.length; i++) {
						String[] szosplit = commandszavak[i].split(":");
						torekeny.setNeighbour(Integer.parseInt(szosplit[0]), (Csempe)Skeleton.getObjectFromName(szosplit[1]));
					}
				} else if(tipus.equals("Orangutan")) {	
					Orangutan o = (Orangutan)Skeleton.getObjectFromName(nev);				
					o.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					o.setElsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
					o.setHatsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[4].split(":")[1]));
					o.setGame((Game)Skeleton.getObjectFromName(commandszavak[5].split(":")[1]));				
				} else if(tipus.equals("Csokiautomata")) {	
					Csokiautomata csoki = (Csokiautomata)Skeleton.getObjectFromName(nev);
					csoki.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));	
				} else if(tipus.equals("Jatekgep")) {	
					Jatekgep jatek = (Jatekgep)Skeleton.getObjectFromName(nev);
					jatek.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
				} else if(tipus.equals("Fotel")) {	
					Fotel fotel = (Fotel)Skeleton.getObjectFromName(nev);
					fotel.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));					
					fotel.setPanda((Ulos)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
					fotel.setCounter(Integer.parseInt(commandszavak[4].split(":")[1]));
				} else if(tipus.equals("Szekreny")) {	
					Szekreny szekreny = (Szekreny)Skeleton.getObjectFromName(nev);
					szekreny.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					szekreny.setMasik((Szekreny)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
				} else if(tipus.equals("Kijarat")) {	
					Kijarat kijarat = (Kijarat)Skeleton.getObjectFromName(nev);
					kijarat.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					kijarat.setBejarat((Csempe)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
					kijarat.setGame((Game)Skeleton.getObjectFromName(commandszavak[4].split(":")[1]));
				} else if(tipus.equals("Ugros")) {	
					Ugros ugros = (Ugros)Skeleton.getObjectFromName(nev);											
					ugros.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					ugros.setElsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
					ugros.setHatsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[4].split(":")[1]));
					ugros.setGame((Game)Skeleton.getObjectFromName(commandszavak[5].split(":")[1]));
				} else if(tipus.equals("Ulos")) {	
					Ulos ulos = (Ulos)Skeleton.getObjectFromName(nev);												
					ulos.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					ulos.setElsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
					ulos.setHatsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[4].split(":")[1]));
					ulos.setGame((Game)Skeleton.getObjectFromName(commandszavak[5].split(":")[1]));
				} else if(tipus.equals("Ijedos")) {	
					Ijedos ijedos = (Ijedos)Skeleton.getObjectFromName(nev);							
					ijedos.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
					ijedos.setElsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
					ijedos.setHatsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[4].split(":")[1]));
					ijedos.setGame((Game)Skeleton.getObjectFromName(commandszavak[5].split(":")[1]));
				} else if(tipus.equals("Game")) {	
					Game g = (Game)Skeleton.getObjectFromName(nev);
					g.setPoint(Integer.parseInt(commandszavak[2].split(":")[1]));
					g.setActiveOrangutan((Orangutan)Skeleton.getObjectFromName(commandszavak[3].split(":")[1])); 
					g.setOrangutanSzam(Integer.parseInt(commandszavak[4].split(":")[1]));
					g.setPandaSzam(Integer.parseInt(commandszavak[5].split(":")[1]));	
				}
			}
		} catch (IOException e) {
			System.out.println("Nincs ilyen pályanév!");
		}
		
		
		// Ha stdin-ről akarnánk olvasni a pályakonfigot(elvileg nem muszáj): 
		/*String userInput = "";
		ArrayList<String> commands = new ArrayList<String>();		
		do {
			if(SkeletonApp.sc.hasNextLine()) {		
				userInput = SkeletonApp.sc.nextLine();
			}	
			if(!userInput.equals("")) {
				commands.add(userInput);
				String[] splitelt = userInput.split(" ");
				String tipus = splitelt[0];
				String nev = splitelt[1];
				if(tipus.equals("Csempe")) {
					Skeleton.addObject(new Csempe(), nev);					
				} else if(tipus.equals("Orangutan")) {
					Skeleton.addObject(new Orangutan(), nev);
				}				
			}
		} while(!userInput.equals("") && SkeletonApp.sc.hasNextLine());		
		
		for(int j = 0; j < commands.size(); j++) {
			String[] commandszavak = commands.get(j).split(" ");
			String tipus = commandszavak[0];
			String nev = commandszavak[1];
			if(tipus.equals("Csempe")) {
				Csempe cs = (Csempe)Skeleton.getObjectFromName(nev);
				cs.setDolog((Dolog)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
				for(int i = 3; i < commandszavak.length; i++) {
					String[] szosplit = commandszavak[i].split(":");
					cs.setNeighbour(Integer.parseInt(szosplit[0]), (Csempe)Skeleton.getObjectFromName(szosplit[1]));
				}
			} else if(tipus.equals("Orangutan")) {	
				Orangutan o = (Orangutan)Skeleton.getObjectFromName(nev);				
				o.setCsempe((Csempe)Skeleton.getObjectFromName(commandszavak[2].split(":")[1]));
				o.setElsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[3].split(":")[1]));
				o.setHatsoMancs((Allat)Skeleton.getObjectFromName(commandszavak[4].split(":")[1]));
				o.setGame((Game)Skeleton.getObjectFromName(commandszavak[5].split(":")[1]));				
			}
			...
		}	*/	
	}
	
	public static void proto_print() {
		ArrayList<String> sorok = new ArrayList<String>();
		
		for(Entry<Object, String> entry : objektumok.entrySet()) {			
			sorok.add(entry.getKey().toString());			
		}		
		Collections.sort(sorok, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}			
		});
		for(String s : sorok) {
			System.out.println(s);
		}
	}
	
	public static void command(String commandstring) {
		if(commandstring.split(" ")[0].equals("load")) {
			load(commandstring.split(" ")[1]);
		} else if(commandstring.split(" ")[0].equals("print") || commandstring.split(" ")[0].equals("list")) {
			proto_print();
		} else if(commandstring.split(" ")[0].equals("do")) {			
			String nev = commandstring.split(" ")[1];
			String tipus = Skeleton.getObjectFromName(nev).getClass().getSimpleName(); // TODO??
			if(tipus.equals("Ijedos") || tipus.equals("Ulos") || tipus.equals("Ugros")|| tipus.equals("Fotel")|| tipus.equals("Jategkep")|| tipus.equals("Csokiautomata")) {
				if(commandstring.split(" ")[2].equals("tick")) {
					((ITickable)Skeleton.getObjectFromName(nev)).tick();
				}
			} else if(tipus.equals("Game")) {
				if(commandstring.split(" ")[2].equals("setActiveOrangutan")) {		
					Orangutan uj = (Orangutan)Skeleton.getObjectFromName(commandstring.split(" ")[3]);
					((Game)Skeleton.getObjectFromName(nev)).setActiveOrangutan(uj);
				} else if(commandstring.split(" ")[2].equals("elenged")) {		
					Orangutan oran = (Orangutan)Skeleton.getObjectFromName(commandstring.split(" ")[3]);
					((Game)Skeleton.getObjectFromName(nev)).elenged();
				} else if(commandstring.split(" ")[2].equals("leptet")) {		
					int irany = Integer.parseInt(commandstring.split(" ")[3]);
					((Game)Skeleton.getObjectFromName(nev)).leptet(irany);
				}
				
			}			
		}
	}
}
