import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomisedIterator {
    public static void main(String []args){
        List<List<String>> myList = new ArrayList<List<String>>();

        List<String> list1 = new ArrayList<String>();
        list1.add("Foo");
        list1.add("Bar");

        List<String> list2 = new ArrayList<String>();
        list2.add("ZFoo");
        list2.add("ZBar");

        myList.add(list1);
        myList.add(list2);

        CustomIterator<String> itr = new CustomIterator<String>(myList);
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

class CustomIterator<T> implements Iterator<T>{
    List<List<T>> list;
    Iterator<List<T>> outer;
    Iterator<T> inner;
    
    CustomIterator(List<List<T>> list){
        this.list = list;
        outer = list.iterator();
        if(outer.hasNext())
            inner = outer.next().iterator();
    }

    public boolean hasNext(){
        if(inner.hasNext())
            return true;
        else{
          inner =  populateInner();
          if(inner==null)
        	  return false;
          return inner.hasNext();
        }
    }

    public T next(){
        if(inner.hasNext()){
            return inner.next();
        }
        return null;
    }
    
    public Iterator<T> populateInner(){
        if(outer.hasNext()){
            return inner = outer.next().iterator();
        }else{
            return null;
        }
    }

	@Override
	public void remove() {
		//No implementation
	}
}