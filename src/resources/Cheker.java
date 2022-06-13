package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;

import javax.imageio.ImageIO;

import utils.Crypter;

import java.awt.image.BufferedImage;
public class Cheker {

	
	public static void res() {
		folder();
		player();
		maps();
	}
	
	public static void folder() {
		File f = new File(".");
		File[] list = f.listFiles();
		boolean existe = false;
		for(int i = 0; i < list.length; i++) {
			if(list[i].getName().equalsIgnoreCase("data")) {
				existe = true;
			}
		}
		File folder = new File("./data");
		if(existe == false) {
			folder.mkdir();
		}
	}
	
	public static void player() {
		File f = new File("./data");
		File[] list = f.listFiles();
		boolean existe = false;
		for(int i = 0; i < list.length; i++) {
			if(list[i].getName().equalsIgnoreCase("player")) {
				existe = true;
			}
		}
		File folder = new File("./data/player");
		if(existe == false) {
			folder.mkdir();
		}
		//--------comprobamos los assets
		File f2 = new File("./data/player");
		File[] list2 = f2.listFiles();
		existe = false;
		for(int i = 0; i < list2.length; i++) {
			if(list2[i].getName().equalsIgnoreCase("player.png")) {
				existe = true;
			}
		}
		File resource = new File("./data/player/player.png");
		if(existe == false) {
			BufferedImage imagen = new BufferedImage(180,180,BufferedImage.TYPE_INT_ARGB);
			try {
				ImageIO.write(imagen, "png", resource);
				resource.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
	
	public static void maps() {
		File f = new File("./data");
		File[] list = f.listFiles();
		boolean existe = false;
		for(int i = 0; i < list.length; i++) {
			if(list[i].getName().equalsIgnoreCase("maps")) {
				existe = true;
			}
		}
		File folder = new File("./data/maps");
		if(existe == false) {
			folder.mkdir();
		}
		
		// comprobamos mapas
		File f2 = new File("./data/maps");
		File[] list2 = f2.listFiles();
		existe = false;
		for(int i = 0; i < list2.length; i++) {
			String[] data = list2[i].getName().split("\\.");
			String extension = "";
			if(data.length > 1) {
				extension = data[1];
			}else {
				extension = "";
			}
			if(extension.equalsIgnoreCase("gwmap")) {
				existe = true;
			}
		}

		if(existe == false) {
			File gwmap = new File("./data/maps/0.gwmap");
			try {
				Formatter fo = new Formatter(gwmap);
				fo.format(Crypter.inNumDataCode("0") +"\n");
				for(int i = 0; i < 20;i++){
					for(int r = 0; r < 20; r++) {
						if(r != 19) {
							fo.format(Crypter.inNumDataCode("0")+ " ");
						}else {
							fo.format(Crypter.inNumDataCode("0"));
						}
					}
					if(i != 19) {
					fo.format("\n");
					}
				}
				fo.flush();
				fo.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		File[] list3 = f.listFiles();
		boolean existe3 = false;
		for(int i = 0; i < list3.length; i++) {
			if(list3[i].getName().equalsIgnoreCase("map.conf")) {
				existe3 = true;
			}
		}
		if(existe3 == false) {
			File file = new File("./data/map.conf");
			try {
				Formatter fo = new Formatter(file);
				fo.format("size:20\n");
				fo.format("1");
				fo.flush();
				fo.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	// falta tile cheker
	
}
