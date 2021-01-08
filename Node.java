public class Node{
  public Node(String value){
    data = value;
  }
  private String data;
  private Node next,prev;

  public String data(){
    return data;
  }

  public Node next(){
    return next;
  }

  public Node prev(){
    return prev;
  }
}
