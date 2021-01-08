public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
    start = null;
  }

  public int size(){
    return size;
  }


  public boolean add (String value){
    Node NewNode = new Node (value);
    if (size == 0){
      start = NewNode;
      end = NewNode;
      size = size + 1;
    }
    else{
      Node Current = start;
      while (Current.getNext() != null){
        Current = Current.getNext();
      }
      Current.setNext(NewNode);
      NewNode.setNext(null);
      size = size + 1;
    }
    return true;
  }

  public boolean add(int index, String value){
    Node NewNode = new Node (value);
    int i = 0;
    Node Current = start;
    if ( index < 0 || index > size){
      throw new IndexOutOfBoundsException ("this is not a valid index!");
    }
    else if (index == 0){
      NewNode.setNext(start);
      start = NewNode;
    }
    else if ( index < size){
      while (i < index - 1){
        Current = Current.getNext();
        i = i + 1;

      }
      Node PlaceHolder = Current.getNext();
      Current.setNext(NewNode);
      NewNode.setNext(PlaceHolder);
   	  size = size + 1;
    }
    else{
      add(value);
    }
    return true;
  }

  /*
  public String get(int index){

  }

  public String set (int index, String value){
  }

*/

  public String toString(){
    String LinkedList = "";
    Node Current = start;
    while (Current.getNext() != null){
      LinkedList = LinkedList + Current.getData();
      Current = Current.getNext();
    }
    LinkedList = LinkedList + Current.getData();
    return LinkedList;
  }

  public static void main (String [] args){
    MyLinkedList Test = new MyLinkedList();
    Test.add("0");
    Test.add("1");
    Test.add("2");
    Test.add("3");
    System.out.println(Test.toString());
    Test.add(2,"4");
    System.out.println(Test.toString());
  }
}
