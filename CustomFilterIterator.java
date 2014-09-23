import java.util.NoSuchElementException;
public class CustomFilterIterator<T> implements IIterator<T> {

	IIterator<T> itr = null;
	IPredicate<T> pred = null;
	IIterator<T> copyItr = null;
	T nextElement;
	boolean hasNext;
	
	public CustomFilterIterator(IIterator<T> itr, IPredicate<T> pred){
		this.itr = itr;
		this.copyItr = itr;
		this.pred = pred;
		nextMatch();
	}
	
	@Override
	public boolean hasNext() {
		return hasNext;
	}

	@Override
	public T next() {
		if(nextElement==null)
			throw new NoSuchElementException();
		return nextMatch();
	}

	@Override
	public void reset() {
		itr.reset();
		nextMatch();
	}
	
	private T nextMatch(){
		T oldElement = nextElement;
		while(itr.hasNext()){
			T tmp = itr.next();
			if(pred.test(tmp)){
				nextElement = tmp;
				hasNext = true;
				return oldElement;
			}
		}
		hasNext = false;
		return oldElement;
	}
	
	public static void main(String[] args){
		DecNumIterator decNum = new DecNumIterator(10);
		EvenNum evenNum = new EvenNum();
		CustomFilterIterator<Integer> custom = new CustomFilterIterator<>(decNum, evenNum);
		//First
		while(custom.hasNext){
			System.out.println(custom.next());
		}
		
		// After Reset
		custom.reset();
		while(custom.hasNext){
			System.out.println(custom.next());
		}
	}

}

class DecNumIterator implements IIterator<Integer>{

	int size;
	int sizeCopy;
	public DecNumIterator(int size) {
		this.size = size;
		this.sizeCopy = size;
	}
	
	@Override
	public boolean hasNext() {
		if(size>0)
			return true;
		return false;
	}

	@Override
	public Integer next() {
		if(size>0)
			return size--;
		return null;
	}

	@Override
	public void reset() {
		size = sizeCopy;
	}
	
}

class EvenNum implements IPredicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return t % 2 == 0;
	}
	
}

interface IIterator<T>{
	boolean hasNext();
	T next();
	void reset();
}

interface IPredicate<T>{
	boolean test(T t);
