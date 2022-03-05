
public class LinkedList { 
    public Node firstNode = null;  
    public Node LastNode = null;  
    public int size=0;
    
	public LinkedList() {
		//non arguments constructor 
	}
	
	public boolean isEmpty() {
		//this method is to now whether the linked list is empty or not
		if(firstNode==null) {
			return true;
		}
		else 
			return false;
	} 
	
	public void insertLast(Student data) {  
		//this method is to add to the linked list at last if needed
		Node newNode = new Node(data);
		if(this.isEmpty()) { 
			firstNode = newNode;  
			LastNode = firstNode;
			size++;
		}
		else {  
			LastNode.next = newNode;  
			LastNode = newNode;
			size++;
		}
	}

	public void insertionSorted(Student student) {
	/*the way I chose to add to my build linkedList is sorted insertion 
	 based on the student's grade starting from the top to the last
     so I can make easier to get top 10 students*/
		Node newNode = new Node(student);
		if(this.isEmpty()) {
			//case is empty
			firstNode=newNode;
			LastNode = firstNode;
			size++;
		}
		else if(student.getGrade()>firstNode.getStudent().getGrade()){
			//case greater than grade
			newNode.setNext(firstNode);
			firstNode=newNode;
			size++;
		}
		else {
			//case less than grade
			Node pre=firstNode;
			Node curr=firstNode.getNext();
			while(curr!=null && student.getGrade()<curr.getStudent().getGrade()) {
				pre=curr;
				curr=curr.getNext();
			}
			newNode.setNext(curr);
			pre.setNext(newNode);
			size++;
		}
	}
	
	public Node search(long seatNum) {
	//this method is created to search for student with specific seat number
		Node current = firstNode;
		if(this.isEmpty()) {
			//is Empty case
    		System.out.println("this is an empty linked list");
    	}
		while (current != null) {
			if (current.getStudent().getSeatNum() == seatNum) 
				//traverse for the same seat number
				return current;
			current = current.getNext(); 
		}
		return current; 
	}
	
    public void deleteStudent(long seatNum) {
    //this method is created to delete a student with specific seat number	
    	Node current = firstNode;
    	
    	if(search(seatNum)==null) {
    		//search method includes this is an empty linked list case
    		System.out.println("there is no student with this seat number!");
    	}
    	
    	else if(firstNode.student.getSeatNum() == seatNum) {
    		  firstNode = firstNode.next;
    		  size--;
    	} 
    	while (current!= null) {
    		if (current.next.student.getSeatNum() == seatNum) {
    		      current.next = current.next.next; 
    		      size--;
    		}
    		current = current.next;
    	}
    	
    }
    
    public void traverse() {   
    //this method is created to traverse the linked list and print it 
        Node current = firstNode;  
        if(this.isEmpty()) {  
            System.out.println("Your LinkedList is empty!");   
        }  
        while(current!= null) {   
            System.out.print(current.student + "\n");  
            current = current.next;  
        }     
    } 
    
    //getters and setters
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Node getFirstNode() {
		return firstNode;
	}
	public void setFirstNode(Node firstNode) {
		this.firstNode = firstNode;
	}
	public Node getLastNode() {
		return LastNode;
	}
	public void setLastNode(Node lastNode) {
		LastNode = lastNode;
	} 	 
}
