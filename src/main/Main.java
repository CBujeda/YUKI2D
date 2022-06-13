package main;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import resources.Cheker;
import resources.Read;
import utils.Console;
import utils.Crypter;
import java.io.File;
public class Main {
	
	
	public static void main(String[] arg) {
		Console.logo();Console.print("");
		Console.print(" █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
		Console.print(" █ ╔═════════════════════════╗ █");
		Console.print(" █ ║   GAME ENGINE YUKI2D    ║ █");
		Console.print(" █ ╚═════════════════════════╝ █");
		Console.print(" █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
		Console.print(" ►Created by Clara Bujeda Muñoz◄");
		String nameGame = "YUKI2D - GAME ";
		Console.print("\n ■ GAME: "+ nameGame);
		Cheker.res();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false); // ponerlo en false
		window.setTitle(nameGame);
		window.setIconImage(Read.icon());
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}
}
