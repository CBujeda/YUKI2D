package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Console {
	
	public static String getTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String time = dtf.format(LocalDateTime.now());
		return time;
	}
	
	public static void msg() {msg("");}
	public static void msg(String data) {msg(data, true);}
	public static void msg(String data, boolean ln) {
		System.out.print("[ "+ getTime()+" ] :  " + data);
		if(ln== true) {
			System.out.println();
		}
	}
	public static void print(String data) {print(data,true);}
	public static void print(String data, boolean ln) {
		System.out.print(data);
		if(ln== true) {
			System.out.println();
		}
	}
	
	public static void err(String data) {
		msg();
		System.err.println(data);
	}
	
	public static void line(int line) {line(line, true);}
	public static void line(int line, boolean ln) {
		for(int i = 0; i < line; i++) {
			System.out.print("▬");
		}
		if(ln == true) {
			System.out.println();
		}
	}

}
