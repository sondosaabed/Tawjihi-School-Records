
public class Node{  
    Student student;  
    Node next;  

    public Node(Student student) {  
    	//Constructor
        this.student = student;  
        this.next = null;  
    }

    //Getters and setters
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}  
}
