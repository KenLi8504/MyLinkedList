public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }


  public boolean add (String value){
    Node NewTerm = new Node (value);
    size = size + 1;
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
