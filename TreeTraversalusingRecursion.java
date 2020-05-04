import java.util.*;
class Node{
	int data;
	Node lchild;
	Node rchild;
	public Node(int data){
		this.data=data;
		this.lchild=null;
		this.rchild=null;
	}
}
class Node1{
	Node data;
	Node1 next;
}
public class TreeTraversalusingRecursion{
	public static void main(String[] agrs){
		Tree t=new Tree();
		t.create();
		System.out.println("\n\n\n\nDisplay");
		t.preOrderDisplay(t.root());
	}
}
class Tree{
	Scanner sc=new Scanner(System.in);
	Node root;
	Node p;
	public void create(){
		//first we insert the rooot element
		System.out.println("Enter the Root data");
		root=new Node(sc.nextInt());
		Queue q=new Queue();
		q.enqueue(root);
		int x;
		while(!q.isEmpty()){
			p=q.dequeue();
			//insert the element at left side
			System.out.println("Enter the Left Child of "+p.data);
			x=sc.nextInt();
			if(x!=-1){
				Node t=new Node(x);
				p.lchild=t;
				q.enqueue(t);
			}
			//insert the element at right side
			System.out.println("Enter the Right Child of "+p.data);
			x=sc.nextInt();
			if(x!=-1){
				Node t=new Node(x);
				p.rchild=t;
				q.enqueue(t);
			}
		}
	}
	//return the Address of root
	public Node root(){
		return root;
	}
	public void preOrderDisplay(Node n){
		if (n!=null){
			System.out.println(n.data);
			preOrderDisplay(n.lchild);
			preOrderDisplay(n.rchild);
		}
	}
	public void inOrderDisplay(Node n){
		if (n!=null){
			inOrderDisplay(n.lchild);
			System.out.println(n.data);
			inOrderDisplay(n.rchild);
		}
	}
}
//Queue Class
class Queue{
	Node1 front;
	Node1 rear;
	//inserting the address in queue
	public void enqueue(Node data){
		Node1 node1=new Node1();
		if (node1==null){
			System.out.println("Queue is Full");
		}else{
			node1.data=data;
			node1.next=null;
			if (front==null){
				front=node1;
				rear=node1;
			}else{
				rear.next=node1;
				rear=node1;
			}
		}
	}
	//Deleting the address in queue
	public Node dequeue(){
		Node x=null;
		if(front==null){
			System.out.println("Queue is Empty");
		}else{
			Node1 t=front;
			x=t.data;
			front=front.next;
			t=null;
		}return x;
	}
	//Check it is empty or not
	public boolean isEmpty(){
		if (front==null)
			return true;
		return false;
	}
}
