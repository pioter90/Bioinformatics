package pl.pg.eti.biomed.bioinf.dao;

public class Leaf {
	private String id;
	
	public Leaf(String id){
		this.id=id;
	}
	
	public String getId(){
		return this.id;
	}
	
	@Override
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			Leaf l = (Leaf)o;
			if(this.id.equals(l.id)){
				return true;
			}else
				return false;
		}else
			return false;

	}
}
