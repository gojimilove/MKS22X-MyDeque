import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    start = 5;
    end = 5;
    size = end-start;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    start = initialCapacity/2;
    end = initialCapacity/2;
    size = end-start;
  }

  public int size(){
    //number of elements in use, from start to end
    return size;
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] newArray = (E[])new Object[size() * 2];
    int s = newArray.length / 4;
    //copy values over
    if (start < end) {
	    for (int i = 0; i < size(); i++) {
	      newArray[s+i] = data[start+i];
	    }
	  }
	  else if (end < start) {
	  	for (int i = start; i < data.length; i++) {
	  		newArray[s] = data[i];
	  		s++;
	  	}
	  	for (int i = 0; i <= end; i++) {
	  		newArray[s] = data[i];
	  		s++;
	  	}
	  }
    data = newArray;
  }

  public String toString(){
    String s = "{";
    if (end > start) {
      for (int i = start; i <= end; i++){
        if (data[i] != null){
          s+= data[i];
          if (i < end) s+=", ";
        }
      }
    }
    else if (end < start) {
      for (int i = start; i < data.length; i++) {
        if (data[i] != null) {
          s+= data[i];
          if (i < data.length-1) s+= ", ";
        }
      }
      for (int i = 0; i <= end; i++) {
        if (data[i] != null) {
          s+= data[i];
          if (i < end) s+=", ";
        }
      }
    }
    s+="}";
    return s;
  }

  public void addFirst(E element){
    if (element == null) throw new NullPointerException("addfirst");
    if (size() == 0) data[start] = element;
    //assuming there's more space in the beginning
    else if (start > 0 && (start < end || start > end+1)) {
      if (size() > 0) start--;
      data[start] = element;
    } else if (end < data.length-1) {
      start = data.length-1;
      data[start] = element;
    } else {
      resize();
      addFirst(element);
    }
    size++;
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException("addlast");
    //assuming there's more space in the end
    if (size() == 0) data[end] = element;
    else if (end < data.length-1 && (end > start || end < start-1)) {
      if (size() > 0) end++;
      data[end] = element;
    } else if (start > 0) {
      end = 0;
      data[end] = element;
    } else {
      resize();
      addLast(element);
    }
    size++;
  }

  public E removeFirst(){
    if (size() <= 0) throw new NoSuchElementException("removefirst");
    E first = data[start];
    data[start] = null;
    if (start < data.length-1) start++;
    else start = 0;
    size--;
    return first;
  }

  public E removeLast(){
    if (size() <= 0) throw new NoSuchElementException("removelast");
    E last = data[end];
    data[end] = null;
    if (end > 0) end--;
    else end = data.length-1;
    size--;
    return last;
  }

  public E getFirst(){
    if (size() <= 0) throw new NoSuchElementException("getfirst");
    return data[start];
  }

  public E getLast(){
    if (size() <= 0) throw new NoSuchElementException("getlast");
    return data[end];
  }

}
