package pl.pg.eti.biomed.bioinf.comparators;

import java.util.Comparator;

import pl.pg.eti.biomed.bioinf.dao.Leaf;

public class LeafComparer  implements Comparator<Leaf> {

	public int compare(Leaf l1, Leaf l2) {
		return l1.getId().compareTo(l2.getId());
	}
	

}
