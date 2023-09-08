package items;
import java.awt.image.BufferedImage;
public class Item {
	
	private int id;
	private int cantidadMax;
	private int cantidad;
	private String nombre;
	private BufferedImage ico;
	private int type; 
	private int effect;
	

	
	public boolean plusItem() {
		if(cantidad != cantidadMax) {
			cantidad++;
			return true;
		}else {return false;}
	}
	
	public boolean restItem() {
		if(cantidad > 0) {
			cantidad--;
			return true;
		}else {return false;}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getCantidadMax() {
		return cantidadMax;
	}
	public void setCantidadMax(int cantidad) {
		this.cantidadMax = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BufferedImage getIco() {
		return ico;
	}
	public void setIco(BufferedImage ico) {
		this.ico = ico;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	

}
