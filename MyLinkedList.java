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
      end = NewNode;
      NewNode.setNext(null);
      NewNode.setPrev(Current);
      size = size + 1;
    }
    return true;
  }

  public void add(int index, String value){
    Node NewNode = new Node (value);
    if (size == 0){
      start = NewNode;
      end = NewNode;
      size = size + 1;
    }
    else{
      int i = 0;
      Node Current = start;
      if ( index < 0 || index > size){
        throw new IndexOutOfBoundsException ("this is not a valid index!");
      }
      else if (index == 0){
        start.setPrev(NewNode);
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
    }
  }

  public String get(int index){
    if (size == 0){
      return "This is an empty LinkedList!";
    }
    else if (index > size() - 1 || index < 0){
      throw new IndexOutOfBoundsException ("this is not a valid index!");
    }
    else{
    Node Current = start;
    for (int i = 0; i < index; i++){
      Current = Current.getNext();
    }
    return Current.getData();
  }
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
    if (size == 0){
      return "[]";
    }
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
      LinkedList = LinkedList + Current.getData() + ", ";
      Current = Current.getPrev();
    }
    LinkedList = LinkedList + Current.getData();
    LinkedList = LinkedList + "]";
    return LinkedList;
  }

  public String remove (int index){
    if (index > size() - 1 || index < 0){
      throw new IndexOutOfBoundsException ("this is not a valid index!");
    }
    else if (index == 0){
      Node Current = start;
      start = Current.getNext();
      return Current.getData();
    }
    else if (index == size() - 1){
      Node Current = end;
      Node NewEnd = Current.getPrev();
      NewEnd.setNext(null);
      end = NewEnd;
      return Current.getData();
    }
    return "hi";
  }
}
