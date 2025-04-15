package Algorithm_2;

class Node{
	Node next;
	Employee employee;
	public Node(Employee employee) {
		this.next = null;
		this.employee = employee;
	}
	Node(){

	}
}
public class QuickSortLinkedList  {
	static Node getTail(Node head) {
		Node tail=head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		return tail;
	}


	static void swap(int salary,int salary_2) {
		int temp=salary;
		salary=salary_2;
		salary_2=temp;
	}
	static Node partition(Node head,Node tail) {
		Node pivot=head;
		Node curr=head.next;
		Node prev=head;


		while(curr!=tail.next) {
			if (curr.employee.getSalary() > pivot.employee.getSalary() ||
					(curr.employee.getSalary() == pivot.employee.getSalary() && 
					curr.employee.getAge() < pivot.employee.getAge())
					)  {
				int temp = curr.employee.getSalary();
				curr.employee.setSalary(prev.next.employee.getSalary());
				prev.next.employee.setSalary(temp);
				
				String tempName = curr.employee.getName();
				int tempAge = curr.employee.getAge();
				
				curr.employee.setName(prev.next.employee.getName());
				curr.employee.setAge(prev.next.employee.getAge());
				
				prev.next.employee.setName(tempName); 
				prev.next.employee.setAge(tempAge);
				
				prev = prev.next;
			}
			curr = curr.next;
		}
		
		int temp = pivot.employee.getSalary();
		pivot.employee.setSalary(prev.employee.getSalary()); 
		prev.employee.setSalary(temp);

		
		String tempName = pivot.employee.getName();
		int tempAge = pivot.employee.getAge();
		
		pivot.employee.setName(prev.employee.getName());
		pivot.employee.setAge(prev.employee.getAge());
		prev.employee.setName(tempName);
		prev.employee.setAge(tempAge);
		return prev;
	}


	static void solveSort(Node head,Node tail) {
		if(head==null||tail==null||head==tail) {
			return;
		}
		//l<r
		Node pivot=partition(head,tail);
		solveSort(head, pivot);
		solveSort(pivot.next, tail);
	}


	static void quickSort(Node head) {
		if(head==null||head.next==null) {
			return;
		}
		Node tail=getTail(head);//Tail return krdega
		solveSort(head,tail);
		display(head);

	}


	static void display(Node head) {
		Node temp=head;
		while(temp!=null) {
			System.out.println(temp.employee.toString());
			temp=temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Employee e1=new Employee("Akash", 22, 60000);
		Employee e2=new Employee("Prakash", 24, 50000);
		Employee e3=new Employee("Suyash", 25, 50000);
		Employee e4=new Employee("Dakash", 24, 60000);
		Employee e5=new Employee("Nakash", 23, 50000);
		Employee e6=new Employee("Lakash", 21, 60000);
		Node n1=new Node(e1);
		Node n2=new Node(e2);
		Node n3=new Node(e3);
		Node n4=new Node(e4);
		Node n5=new Node(e5);
		Node n6=new Node(e6);
		Node head=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		quickSort(n1);

	}
}