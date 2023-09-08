package utils.logicObj;

import java.util.ArrayList;

import utils.Console;

public class ListButton {

	ArrayList<Button> l;

	public ListButton() {
		super();
		l = new ArrayList<Button>();
	}
	public ListButton(String[] data) {
		super();
		l = new ArrayList<Button>();
		addListBtn(data);
	}
	
	public void addListBtn(String[] data) {
		for(int i = 0; i < data.length; i++) {
			l.add(new Button(data[i],l.size()));
		}
	}
	
	public String getStringButton(int i) {
		if(i >= 0 && i < l.size()) {
			return l.get(i).getName();
		}else {
			Console.err("Error al obtener el String de una (ListButton)");
			return "ERROR";
		}
	}
	
	public String getStringButtonAndSelected(int i) {
		if(i >= 0 && i < l.size()) {
			if(l.get(i).isSelect()) {
				return "> " + l.get(i).getName();
			}else {
				return "  " + l.get(i).getName();
			}
		}else {
			Console.err("Error al obtener el String de una (ListButton)");
			return "ERROR";
		}
	}
	
	public void select(int i) {
		for(int d = 0; d < l.size(); d++) {
			l.get(d).setSelect(false);
		}
		if(i >= 0 && i < l.size()) {
			l.get(i).setSelect(true);
		}else {
			System.out.println(i);
			Console.err("Error al seleccionar en una (ListButton)");
		}
	}
	public int getSelect() {
		for(int i = 0; i < l.size();i++) {
			if(l.get(i).isSelect()) {
				return i;
			}
		}
		return 0;
	}
	
	public int getAcction(int i) {
		if(i >= 0 && i < l.size()) {
			return l.get(i).getAcction();
		}else {
			Console.err("Error al obtener la accion de una (ListButton)");
			return -1;
		}
	}
	
	public int size() {
		return l.size();
	}
	
	public void display(int up, int down){
		if(up == 1) {
			int actualSelect = getSelect();
			if(actualSelect != 0) {
				select(actualSelect-1);
			}else {
				select(size()-1);
			}
		}else if(down == 1){
			int actualSelect = getSelect();
			if(actualSelect != size()-1) {
				select(actualSelect+1);
			}else {
				select(0);
			}
		}
	}
	

}
