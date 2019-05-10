import java.util.ArrayList;

public class Hashtable{
	private static final int DEFAULT_SIZE = 2027;
	private int size;
	private ArrayList<HashNode<String, String>> buckets;
	
	Hashtable(){
		size = 0;
		buckets = new ArrayList<>(DEFAULT_SIZE);
		// Create empty chains 
        for (int i = 0; i < DEFAULT_SIZE; i++) 
            buckets.add(null); 
	}
	
	public boolean containsKey(String key) {
		
		int slot = getSlot(key);
		HashNode<String,String> head = buckets.get(slot);
		if(head == null) {
			return false;
		}
		while( head != null && key !=  head.key()) {
			 head =  head.next();
		}
		if(head.key().equals(key))
			return true;
		
		return false;
	}
	
	
	public String get(String key) {
		int slot = getSlot(key);
		HashNode<String,String> head = buckets.get(slot);
		
		while( head != null && key !=  head.key()) {
			 head =  head.next();
		}
		if(head.key().equals(key))
			return head.value();
		return null;
	}
	
	public void put(String key, String value) {
		int slot = getSlot(key);
		
		HashNode<String,String> head = buckets.get(slot);
		
		while(head != null) {
			if(head.key().equals(key)) {
				head.setValue(value);
				return;
			}
			
			head = head.next();
		}
		
		++size;
		head = buckets.get(slot);
		HashNode<String,String> newNode = new HashNode<String,String>(key, value);
		newNode.setNext(head);
		
		buckets.set(slot, newNode);
		
		
	}
	
	public String remove(String key) {
		int slot = getSlot(key);
		if(buckets.get(slot) == null)
			return null;
		
		HashNode<String,String> head = buckets.get(slot);
		HashNode<String,String> prev = null;
		while(head != null) {
			if(head.key().equals(key))
				break;
			
			prev = head;
			head = head.next();
		}
		
		if(head == null)
			return null;
		
		--size;
		
		if(prev != null)
			prev.setNext(head.next());
		else
			buckets.set(slot, head.next());
		
		return head.value();
		
	}
	
	private int getSlot(String key) {
		int slot = key.hashCode();
		slot = slot % buckets.size();
		return slot;
	}
	
}
