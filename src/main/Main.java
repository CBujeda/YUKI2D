package main;

import javax.swing.JFrame;

import resources.Cheker;
import utils.Console;
import utils.Crypter;

public class Main {
	
	
	public static void main(String[] arg) {
		
		System.out.println(" █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
		System.out.println(" █ ╔═════════════════════════╗ █");
		System.out.println(" █ ║   GAME ENGINE YUKI2D    ║ █");
		System.out.println(" █ ╚═════════════════════════╝ █");
		System.out.println(" █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
		Console.print(" ►Created by Clara Bujeda Muñoz◄");
		String nameGame = "YUKI2D - GAME";
		Console.print("\nGAME: "+ nameGame);
		Cheker.res();
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false); // ponerlo en false
		window.setTitle(nameGame);
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}
}
