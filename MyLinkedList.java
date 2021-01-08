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
      while (Current.next() != null){
        Current = Current.next();
      }
    }
    return true;
  }

  /*
  public boolean add(int index, String value){

  }
  public String get(int index){

  }
  public String set (int index, String value){

  }
  public String toString(){

  }

  */
}
