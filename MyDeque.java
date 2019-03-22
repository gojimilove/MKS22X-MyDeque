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
    if (end < start) {
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
    if (element == null) throw new NullPointerException("null is fake");
    if (size() == 0) data[start] = element;
    //assuming there's more space in the beginning
    if (start > 0 && (start < end || start > end+1)) {
      if (size() > 0) start--;
      data[start] = element;
    } else if (end < data.length-1) {
      start = data.length-1;
      data[start] = element;
    } else {
      //resize
    }
    size++;
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException("null is fake");
    //assuming there's more space in the end
    if (size() == 0) data[end] = element;
    if (end < data.length-1 && (end > start || end < start-1)) {
      if (size() > 0) end++;
      data[end] = element;
    } else if (start > 0) {
      end = 0;
      data[end] = element;
    } else {
      //resize
    }
    size++;
  }

  public E removeFirst(){
    if (data[start] == null) throw new NoSuchElementException("bad");
    E first = data[start];
    data[start] = null;
    start++;
    size--;
    return first;
  }

  public E removeLast(){
    if (data[end] == null) throw new NoSuchElementException("bad");
    E last = data[end];
    data[end] = null;
    end--;
    size--;
    return last;
  }

  public E getFirst(){
    if (data[start] == null) throw new NoSuchElementException("bad");
    return data[start];
  }

  public E getLast(){
    if (data[end] == null) throw new NoSuchElementException("bad");
    return data[end];
  }

}
