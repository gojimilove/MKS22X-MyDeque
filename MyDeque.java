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
    if (start <= end) {
    	for (int i = 0; i < size(); i++) {
    		newArray[i] = data[i];
    	}
    } else if (start > end) {
    	int newCounter = 0;
    	for (int i = start; i < data.length; i++) {
    		newArray[newCounter] = data[i];
    		newCounter++;
    	}
    	for (int i = 0; i <= end; i++) {
    		newArray[newCounter] = data[i];
    		newCounter++;
    	}
    }
    data = newArray;
    start = 0;
    end = size()-1;
  }

  public String toString(){
    String s = "{";
    if (end >= start) {
      for (int i = start; i <= end; i++){
        if (data[i] != null){
          s+= data[i];
          if (i < end) s+=" ";
        }
      }
    }
    else if (end < start) {
      for (int i = start; i < data.length; i++) {
        if (data[i] != null) {
          s+= data[i];
          s+= " ";
        }
      }
      for (int i = 0; i <= end; i++) {
        if (data[i] != null) {
          s+= data[i];
          if (i < end) s+=" ";
        }
      }
    }
    s+="}";
    return s;
  }

  public void printArray() {
  	String s = "{";
  	for (int i = 0; i < data.length; i++) {
  		s+= data[i]+", ";
  	}
  	s+="}";
  	s+="\nStart: "+start;
  	s+="\nEnd: "+end;
  	s+="\nSize: "+size;
  	System.out.println(s);
  }

  public void addFirst(E element){
    if (element == null) throw new NullPointerException("addfirst");

    if (size() == 0) {
    	data[start] = element;
    	size++;
    }
    else if (start > 0 && (start <= end || start > end+1)) {
      if (size() > 0) start--;
      data[start] = element;
      size++;
    }
    else if (start == 0 && end < data.length-1) {
      start = data.length-1;
      data[start] = element;
      size++;
    }
    else{
    	//System.out.println("RESIZE");
      resize();
      addFirst(element);
    }
  }

  public void addLast(E element){
    if (element == null) throw new NullPointerException("addlast");

    if (size() == 0) {
    	data[end] = element;
    	size++;
   	}
    else if (end < data.length-1 && (end >= start || end < start-1)) {
      if (size() > 0) end++;
      data[end] = element;
      size++;
    }
    else if (end == data.length-1 && start > 0) {
      end = 0;
      data[end] = element;
      size++;
    }
    else{
    	//System.out.println("RESIZE");
      resize();
      addLast(element);
    }
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

  public static void main(String[]args) {
  	MyDeque<Integer> tester = new MyDeque<>();
  	tester.printArray();
    System.out.println(tester);
  	tester.addFirst(0);
  	tester.printArray();
    System.out.println(tester);
  	tester.addLast(1);
  	tester.printArray();
    System.out.println(tester);
  	tester.addFirst(2);
  	tester.printArray();
    System.out.println(tester);
  	tester.addLast(3);
  	tester.printArray();
    System.out.println(tester);
  	tester.addLast(4);
  	tester.printArray();
    System.out.println(tester);
  	tester.addLast(5);
  	tester.printArray();
    System.out.println(tester);
  	tester.addLast(6);
  	tester.printArray();
    System.out.println(tester);
    tester.removeLast();
    tester.printArray();
    System.out.println(tester);
  	// tester.addLast(7);
  	// tester.printArray();
    // System.out.println(tester);
    // tester.removeFirst();
    // tester.printArray();
    // System.out.println(tester);
  	// tester.addLast(8);
  	// tester.printArray();
    // System.out.println(tester);
  	// tester.addLast(9);
  	// tester.printArray();
    // System.out.println(tester);
  	// tester.addFirst(10);
  	// tester.printArray();
    // System.out.println(tester);
    // tester.removeLast();
    // tester.printArray();
    // System.out.println(tester);
    // tester.removeFirst();
    // tester.printArray();
    // System.out.println(tester);
    System.out.println(tester.getFirst());
    System.out.println(tester.getLast());
  }
}
