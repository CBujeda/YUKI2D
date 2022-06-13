package main;

import javax.swing.JFrame;

import resources.Cheker;

public class Main {
	
	
	public static void main(String[] arg) {
		
		System.out.println(" █▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
		System.out.println(" █ ╔════════════════════╗ █");
		System.out.println(" █ ║ GAME ENGINE YUKI2D ║ █");
		System.out.println(" █ ╚════════════════════╝ █");
		System.out.println(" █▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█");
		Cheker.res();
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Game");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}
}
