public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

  public MyDeque(int initialCapacity){

  }

  public int size(){
    return -1;
  }

  public String toString(){
    String s = "";
    return s;
  }

  public void addFirst(E element){
    //assuming there's more space in the beginning
    data[start-1] = element;
    start--;
  }

  public void addLast(E element){
    //assuming there's more space in the end
    data[end+1] = element;
    end++;
  }

  public E removeFirst(){
    E first = data[start];
    start++;
    return first;
  }

  public E removeLast(){
    E last = data[end];
    end--;
    return last;
  }

  public E getFirst(){
    return data[start];
  }

  public E getLast(){
    return data[end];
  }

}
