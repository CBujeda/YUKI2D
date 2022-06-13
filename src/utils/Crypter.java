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
	
	
	public static boolean random() {
		return Math.random() < 0.5;
	}
	
}
