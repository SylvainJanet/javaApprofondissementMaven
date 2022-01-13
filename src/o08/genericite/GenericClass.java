package o08.genericite;

import java.util.List;

/*
 * 
 * Pour indiquer qu'une classe ou une interface est générique, il faut
 * ajouter la liste des type génériques entre < >
 * 
 */
public class GenericClass<T> {
	
	private List<T> list;
	private T element;
	
	public GenericClass(List<T> list, T element) {
		super();
		this.list = list;
		this.element = element;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
	
	

}
