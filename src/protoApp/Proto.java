package protoApp;

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
public class Proto {
	// Az objektumokat tárolja a nevükkel együtt.
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
	
	/**
	 * Visszatér azzal a beregisztrált objektummal, aminek a paraméterül kapott string a neve.
	 * @param s A kért objektum neve
	 * @return A keresett nevű objektum
	 */
	public static Object getObjectFromName(String s) {
		for(Entry<Object, String> entry : objektumok.entrySet()) {
			if(entry.getValue().equals(s))
				return entry.getKey();
		}
		return null;
	}
	
	/**
	 * Betölti a paraméterül kapott pályát
	 * @param palyanev A betöltendő pálya neve. A program a tests/palyak/
	 * mappa alatt keresi az ilyen nevű fájlt. 
	 */
	public static void load(String palyanev) {
		// Ha volt korábban betöltve valami, törli
		objektumok.clear();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("tests/palyak/"+palyanev));			
			String sor;
			// Az összes sor eltárolásra kerül. Első körben csak létrejönnek az objektumok, és
			// beregisztrálódnak az adott névvel, a második körben pedig ezek attribútumai kerülnek beállításra.
			// Erre azért van szükség, mert az objektumok egymásra is hivatkozhatnak attribútumaikban, így a
			// későbbi sorokban szereplő objektumokra nem lehetne hivatkozni.
			ArrayList<String> commands = new ArrayList<String>();		
			while ((sor = br.readLine()) != null) { // Soronként objektumok beolvasása
				if(!sor.equals("")) {
					commands.add(sor);
					String[] splitelt = sor.split(" ");
					String tipus = splitelt[0];
					String nev = splitelt[1];
					// Objektumok beregisztrálása a nevükkel
					if(tipus.equals("Csempe")) {
						Proto.addObject(new Csempe(), nev);					
					} else if(tipus.equals("Orangutan")) {
						Proto.addObject(new Orangutan(), nev);
					} else if(tipus.equals("Game")) {						
						Proto.addObject(Game.getInstance(), nev);
					} else if(tipus.equals("Csokiautomata")) {
						Proto.addObject(new Csokiautomata(), nev);
					} else if(tipus.equals("Jatekgep")) {
						Proto.addObject(new Jatekgep(), nev);
					} else if(tipus.equals("Fotel")) {
						Proto.addObject(new Fotel(), nev);
					} else if(tipus.equals("Szekreny")) {
						Proto.addObject(new Szekreny(), nev);
					} else if(tipus.equals("Kijarat")) {
						Proto.addObject(new Kijarat(), nev);
					} else if(tipus.equals("Torekenycsempe")) {
						Proto.addObject(new Torekenycsempe(), nev);
					} else if(tipus.equals("Ugros")) {
						Proto.addObject(new Ugros(), nev);
					} else if(tipus.equals("Ulos")) {
						Proto.addObject(new Ulos(), nev);
					} else if(tipus.equals("Ijedos")) {
						Proto.addObject(new Ijedos(), nev);
					} 
				}
				else
					break;
			}
			
			// Létrehozott objektumok attribútumainak beállítása
			for(int j = 0; j < commands.size(); j++) {
				String[] commandszavak = commands.get(j).split(" ");
				String tipus = commandszavak[0];
				String nev = commandszavak[1];				 
				if(tipus.equals("Csempe")) {
					Csempe cs = (Csempe)Proto.getObjectFromName(nev);
					cs.setDolog((Dolog)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					for(int i = 3; i < commandszavak.length; i++) {
						String[] szosplit = commandszavak[i].split(":");
						cs.setNeighbour(Integer.parseInt(szosplit[0]), (Csempe)Proto.getObjectFromName(szosplit[1]));
					}
				} else if(tipus.equals("Torekenycsempe")) {	
					Torekenycsempe torekeny = (Torekenycsempe)Proto.getObjectFromName(nev);
					torekeny.setDolog((Dolog)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					torekeny.setElettartam(Integer.parseInt(commandszavak[3].split(":")[1]));  
					for(int i = 4; i < commandszavak.length; i++) {
						String[] szosplit = commandszavak[i].split(":");
						torekeny.setNeighbour(Integer.parseInt(szosplit[0]), (Csempe)Proto.getObjectFromName(szosplit[1]));
					}
				} else if(tipus.equals("Orangutan")) {	
					Orangutan o = (Orangutan)Proto.getObjectFromName(nev);				
					o.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					o.setElsoMancs((Allat)Proto.getObjectFromName(commandszavak[3].split(":")[1]));
					o.setHatsoMancs((Allat)Proto.getObjectFromName(commandszavak[4].split(":")[1]));
					o.setGame((Game)Proto.getObjectFromName(commandszavak[5].split(":")[1]));				
				} else if(tipus.equals("Csokiautomata")) {	
					Csokiautomata csoki = (Csokiautomata)Proto.getObjectFromName(nev);
					csoki.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));	
				} else if(tipus.equals("Jatekgep")) {	
					Jatekgep jatek = (Jatekgep)Proto.getObjectFromName(nev);
					jatek.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
				} else if(tipus.equals("Fotel")) {	
					Fotel fotel = (Fotel)Proto.getObjectFromName(nev);
					fotel.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));					
					fotel.setPanda((Ulos)Proto.getObjectFromName(commandszavak[3].split(":")[1]));
					fotel.setCounter(Integer.parseInt(commandszavak[4].split(":")[1]));
				} else if(tipus.equals("Szekreny")) {	
					Szekreny szekreny = (Szekreny)Proto.getObjectFromName(nev);
					szekreny.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					szekreny.setMasik((Szekreny)Proto.getObjectFromName(commandszavak[3].split(":")[1]));
				} else if(tipus.equals("Kijarat")) {	
					Kijarat kijarat = (Kijarat)Proto.getObjectFromName(nev);
					kijarat.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					kijarat.setBejarat((Csempe)Proto.getObjectFromName(commandszavak[3].split(":")[1]));
					kijarat.setGame((Game)Proto.getObjectFromName(commandszavak[4].split(":")[1]));
				} else if(tipus.equals("Ugros")) {	
					Ugros ugros = (Ugros)Proto.getObjectFromName(nev);											
					ugros.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					ugros.setElsoMancs((Allat)Proto.getObjectFromName(commandszavak[3].split(":")[1]));
					ugros.setHatsoMancs((Allat)Proto.getObjectFromName(commandszavak[4].split(":")[1]));
					ugros.setGame((Game)Proto.getObjectFromName(commandszavak[5].split(":")[1]));
				} else if(tipus.equals("Ulos")) {	
					Ulos ulos = (Ulos)Proto.getObjectFromName(nev);												
					ulos.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					ulos.setElsoMancs((Allat)Proto.getObjectFromName(commandszavak[3].split(":")[1]));
					ulos.setHatsoMancs((Allat)Proto.getObjectFromName(commandszavak[4].split(":")[1]));
					ulos.setGame((Game)Proto.getObjectFromName(commandszavak[5].split(":")[1]));
				} else if(tipus.equals("Ijedos")) {	
					Ijedos ijedos = (Ijedos)Proto.getObjectFromName(nev);							
					ijedos.setCsempe((Csempe)Proto.getObjectFromName(commandszavak[2].split(":")[1]));
					ijedos.setElsoMancs((Allat)Proto.getObjectFromName(commandszavak[3].split(":")[1]));
					ijedos.setHatsoMancs((Allat)Proto.getObjectFromName(commandszavak[4].split(":")[1]));
					ijedos.setGame((Game)Proto.getObjectFromName(commandszavak[5].split(":")[1]));
				} else if(tipus.equals("Game")) {	
					Game g = (Game)Proto.getObjectFromName(nev);
					g.setPoint(Integer.parseInt(commandszavak[2].split(":")[1]));
					g.setActiveOrangutan((Orangutan)Proto.getObjectFromName(commandszavak[3].split(":")[1])); 
					g.setOrangutanSzam(Integer.parseInt(commandszavak[4].split(":")[1]));
					g.setPandaSzam(Integer.parseInt(commandszavak[5].split(":")[1]));	
				}
			}
		} catch (IOException e) { // Ha nem létezik az adott nevű pálya..
			System.out.println("Nincs ilyen pályanév!");
		}		
	}
	
	/**
	 * Abc sorrendben kiírja az összes beregisztrált objektumot az attribútumaikkal együtt.
	 */
	public static void print() {
		ArrayList<String> sorok = new ArrayList<String>();		
		// Minden objektum bekerül a listába, de még rendezetlenül
		for(Entry<Object, String> entry : objektumok.entrySet()) {			
			sorok.add(entry.getKey().toString());			
		}		
		// Sorok rendezése abc sorrendbe
		Collections.sort(sorok, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}			
		});
		// Minden sor kiírása
		for(String s : sorok) {
			System.out.println(s);
		}
	}
	
	/**
	 * Végrehajtja a paraméterül kapott prototípus parancsot.
	 * @param commandstring A végrehajtandó parancs, lehetséges parancsokat ld. dokumentáció
	 */
	public static void command(String commandstring) {		
		if(commandstring.split(" ")[0].equals("load")) {
			load(commandstring.split(" ")[1]);
		} else if(commandstring.split(" ")[0].equals("print") || commandstring.split(" ")[0].equals("list")) {
			print();
		} else if(commandstring.split(" ")[0].equals("do")) {			
			String nev = commandstring.split(" ")[1];
			String tipus = Proto.getObjectFromName(nev).getClass().getSimpleName(); // TODO??
			if(tipus.equals("Ijedos") || tipus.equals("Ulos") || tipus.equals("Ugros")|| tipus.equals("Fotel")|| tipus.equals("Jatekgep")|| tipus.equals("Csokiautomata")) {
				if(commandstring.split(" ")[2].equals("tick")) {
					((ITickable)Proto.getObjectFromName(nev)).tick();
				}
			} else if(tipus.equals("Game")) {
				if(commandstring.split(" ")[2].equals("setActiveOrangutan")) {		
					Orangutan uj = (Orangutan)Proto.getObjectFromName(commandstring.split(" ")[3]);
					((Game)Proto.getObjectFromName(nev)).setActiveOrangutan(uj);
				} else if(commandstring.split(" ")[2].equals("elenged")) {		
					((Game)Proto.getObjectFromName(nev)).elenged();
				} else if(commandstring.split(" ")[2].equals("leptet")) {		
					int irany = Integer.parseInt(commandstring.split(" ")[3]);
					((Game)Proto.getObjectFromName(nev)).leptet(irany);
				}	
				else System.out.println("Nincs ilyen parancs!");
			}			
		}
	}
}
