
public class HashNode <k,v> {
	private k key;
	private v value;
	private HashNode<k,v> next;
	
	HashNode(k key, v value){
		this.key = key;
		this.value = value;
		next = null;
	}
	
	
	//accessors and muators
	public void setKey(k key) {
		this.key = key;
	}
	
	public void setValue(v value) {
		this.value = value;
	}
	
	public void setNext(HashNode<k,v> node) {
		this.next = node;
	}
	
	public k key() {
		return key;
	}
	
	public v value() {
		return value;
	}
	
	public HashNode<k,v> next() {
		return next;
	}
}
