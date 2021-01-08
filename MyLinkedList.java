public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
    start = new Node(null);
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
    else{
      while (i < index){
        Current = Current.getNext();
      }
      Node PlaceHolder = Current.getNext();
      Current.setNext(NewNode);
      NewNode.setNext(PlaceHolder);
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
    Test.add("hi");
    Test.add("hi2");
    Test.add("hi3");
    Test.add("hi4");
    System.out.println(Test.size());
    System.out.println(Test.toString());
  }
}
