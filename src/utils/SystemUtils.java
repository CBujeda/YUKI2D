package utils;

public class SystemUtils {
	
	public static String[] getRamStr() {
		   int dataSize = 1024 * 1024;
		   Runtime runtime = Runtime.getRuntime();
		   String[] data = {
				   "RAM: " + runtime.totalMemory() / dataSize + "MB",
				   "Free: " + runtime.freeMemory() / dataSize + "MB",
				   "Used: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB"
		   };
		return data;
	}
	
	public static void exit() {
		System.exit(0);
	}
}
