package server.model;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

import util.Location;

public class Board {
	
	int size;
	Hashtable<Location, Cell> table; 
	Cell Bonus;
	
	Board() {
	
		size = 7;
		table = new Hashtable<Location, Cell>();
		for(int c = 1; c<=size;c++){
			for(int r =1; r<=size; r++){
                Location loc = new Location(c,r);
		
		Cell cell = new Cell(loc);
				cell.getLetter();
				table.put(loc, cell);	
			}
		}
	}
	
	public Board(int size) {
		super();
		table = new Hashtable<Location, Cell>();
		for(int c = 1; c<=size;c++){
			for(int r =1; r<=size; r++){
				Location loc = new Location(c,r);
                Cell cell = new Cell(loc);
				cell.getLetter();
				table.put(loc, cell);
			}
		}
	}
	
	public int getSize(){
		return this.size;
	}
	
	
	
	
	public Board resetBoard(){
		return new Board();	
		
	}
	
	public Board resetBoard(int size){
		return new Board(size);	
	}
	
	public String getCellContains(Location l){
		return table.get(l).letter;
	}
	
	public Location BonusCell(){
		int c = (int) (Math.random()*size)+1;
		int r = (int) (Math.random()*size)+1;
		table.get(new Location(c,r).hashCode()).setSeleted();
		return new Location(c, r);
	} 
	
	
	public void removeWord(List<Cell> Cells){
		for(Cell c : Cells){
			c.removeLetter();
		}	
	}
	
	public void refreshBoard(){
		for(int c = 1; c<=size;c++){
			int count = 0;
			for(int r =1; r<=size; r++){
				Location l = new Location(c,r);
				if(!table.get(l.hashCode()).hasLetter()){
					while (!table.get(new Location(c,++r).hashCode()).hasLetter())
					table.get(l.hashCode()).letter = table.get(new Location(c,r).hashCode()).getLetter();
					table.get(new Location(c,r).hashCode()).removeLetter();
					
					count++;	
				}			
			}
			for(int x =0; x<count; x++){
				Location r = new Location(c, size-x);
				table.get(r.hashCode()).setLetter();
			}
		}	
	}
	
	
	
	
	
	






	
	

}
