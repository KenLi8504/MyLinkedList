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
      NewNode.setPrev(Current);
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
      size = size + 1;
    }
    else if ( index < size){
      while (i < index - 1){
        Current = Current.getNext();
        i = i + 1;

      }
      Node PlaceHolder = Current.getNext();
      Current.setNext(NewNode);
      NewNode.setNext(PlaceHolder);
      NewNode.setPrev(Current);
      PlaceHolder.setPrev(NewNode);
   	  size = size + 1;
    }
    else{
      add(value);
    }
    return true;
  }


  public String get(int index){
    Node Current = start;
    for (int i = 0; i < index; i++){
      Current = Current.getNext();
    }
    return Current.getData();
  }

  public String set (int index, String value){
    Node Current = start;
    for (int i = 0; i < index; i++){
      Current = Current.getNext();
    }
    String ReplacedValue = Current.getData();
    Current.setData(value);
    return ReplacedValue;
 }

  public String toString(){
    String LinkedList = "[";
    Node Current = start;
    while (Current.getNext() != null){
      LinkedList = LinkedList + Current.getData() + ", ";
      Current = Current.getNext();
    }
    LinkedList = LinkedList + Current.getData();
    LinkedList = LinkedList + "]";
    return LinkedList;
  }

  public String toStringReversed(){
    String LinkedList = "[";
    Node Current = end;
    while (Current.getPrev() != null){
      LinkedList = LinkedList + Current.getData() + ",";
      Current = Current.getPrev();
    }
    LinkedList = LinkedList + Current.getData();
    LinkedList = LinkedList + "]";
    return LinkedList;
  }

  public static void main(String[]args){
    MyLinkedList words = new MyLinkedList();

    //add 0-9 in order
    for(int i = 0; i < 10; i++){
      words.add(i+"");
    }
    //insert 0x - 9x before each value 0-9
    for(int i = 0; i < 10; i++){
      words.add(2*i,i+"x");
    }
    //check the head/tail add
    words.add(0,"head");
    words.add(words.size(),"tail");

    try{
      words.add(-1,"");
      System.out.println("ERROR! Added to negative index");
    }catch(IndexOutOfBoundsException e){

    }

    try{
      words.add(words.size()+1,"");
      System.out.println("ERROR! Added to (size + 1) index");
    }catch(IndexOutOfBoundsException e){

    }


    System.out.println("Your result:\n"+words+" "+words.size());
    System.out.println("expected:\n[head, 0x, 0, 1x, 1, 2x, 2, 3x, 3, 4x, 4, 5x, 5, 6x, 6, 7x, 7, 8x, 8, 9x, 9, tail] 22");
    System.out.println("\nYour result:\n"+words.toStringReversed()+" "+words.size());
    System.out.println("expected:\n[tail, 9, 9x, 8, 8x, 7, 7x, 6, 6x, 5, 5x, 4, 4x, 3, 3x, 2, 2x, 1, 1x, 0, 0x, head] 22");
  }
}
