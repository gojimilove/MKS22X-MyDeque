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
        s+= data[i];
        if (i < end) s+=" ";
      }
    }
    if (end < start) {
      for (int i = start; i < data.length; i++) {
        s+= data[i];
        if (i < data.length-1) s+= " ";
      }
      for (int i = 0; i <= end; i++) {
        s+= data[i];
        if (i < end) s+=" ";
      }
    }
    s+="}";
    return s;
  }

  public void addFirst(E element){
    //assuming there's more space in the beginning
    data[start-1] = element;
    start--;
    size++;
  }

  public void addLast(E element){
    //assuming there's more space in the end
    data[end+1] = element;
    end++;
    size++;
  }

  public E removeFirst(){
    E first = data[start];
    start++;
    size--;
    return first;
  }

  public E removeLast(){
    E last = data[end];
    end--;
    size--;
    return last;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

}
