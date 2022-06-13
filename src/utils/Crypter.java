package utils;

public class Crypter {
	/**
	 * z s 0
	 * a r 1
	 * c p 2
	 * e n 3
	 * g l 4
	 * i j 5
	 * k h 6
	 * m f 7
	 * o d 8
	 * q b 9
	 */
	//01542
	private static String[] code1() {
		 String[] code1 = {"z","a","c","e","g","i","k","m","o","q"};
		return code1;	
	}
	private static String[] code2() {
		 String[] code1 = {"s","r","p","n","l","j","h","f","d","b"};
		return code1;	
	}
	
	public static String inNumDataCode(String data) {
		String n1 ="";
		for(int i = 0; i < data.length(); i++) {	
			String d = data.substring(i,i+1);
			String c ="";
			if(random() == true) {
				for(int c1 = 0; c1 < code1().length; c1++) {
					c = Integer.toString(c1);
					if(c.equalsIgnoreCase(d)) {
						n1 = n1 + code1()[c1];
					}
				}
			}else {
				for(int c2 = 0; c2 < code2().length; c2++) {
					c = Integer.toString(c2);
					if(c.equalsIgnoreCase(d)) {
						n1 = n1 + code2()[c2];
					}
				}
			}
		}
		return n1;
	}
	public static String inNumDataDecode(String data) {
		String n1 ="";
		for(int i = 0; i < data.length(); i++) {	
			String d = data.substring(i,i+1);
			String c ="";
			for(int r = 0; r < 10; r++) {
				c = Integer.toString(r);
				if(code1()[r].equalsIgnoreCase(d)||code2()[r].equalsIgnoreCase(d) ){
					n1 = n1 + c;
				}
			}
		}
		return n1;
	}
	
	final static int key = 12345;
	
	private static String[] codeStr_es() {
		 String[] code1 = { "l","m","n","a","b",
				 			"c","w","x","y","z",
				 			"h","i","j","k","d",
				 			"e","f","g","o","p",
				 			"q","r","s","t","u"};
		return code1;	
	}
	public static String inStringDataCode(String data) {
		String n1="";
		for(int i = 0; i < data.length(); i++) {
			for(int r = 0; r < codeStr_es().length;r++) {
				if(codeStr_es()[r].equalsIgnoreCase(data.substring(i,i+1))) {
					int dat = (r*key +132496043);
					n1 = n1 + Integer.toString(dat) + " ";
				}
			}
		}
		return n1;
	}
	
	public static String inStringDataDeCode(String data) {
		String n1="";
		String[] datos = data.split(" ");
		for(int i = 0; i < datos.length; i++) {
			try {
				int dat = Integer.parseInt(datos[i]);
				int r = ((dat - 132496043)/key);
				n1 = n1 + codeStr_es()[r];
			}catch(Exception e) {
				Console.err("[code x801] Error en descifrado de datos"+ e);
			}
		}
		return n1;
	}
	
	public static boolean random() {
		return Math.random() < 0.5;
	}
	
}
