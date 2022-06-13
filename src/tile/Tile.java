package tile;

import java.awt.image.BufferedImage;

public class Tile {
	
	private BufferedImage image;
	private boolean collision = false;
	private String name;
	private boolean liquid;
	private boolean danger;
	
	
	
	public Tile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tile(BufferedImage image, boolean collision, String name, boolean liquid, boolean danger) {
		super();
		this.image = image;
		this.collision = collision;
		this.name = name;
		this.liquid = liquid;
		this.danger = danger;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public boolean isCollision() {
		return collision;
	}

	public void setCollision(boolean collision) {
		this.collision = collision;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isLiquid() {
		return liquid;
	}

	public void setLiquid(boolean liquid) {
		this.liquid = liquid;
	}

	public boolean isDanger() {
		return danger;
	}

	public void setDanger(boolean danger) {
		this.danger = danger;
	}
	
	
	
	
}
