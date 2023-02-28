package LinkedLists;
import java.util.Objects;

public class COM182LinkedList<Anything> {
	private Anything data;
	Node next;
	// the Node class is a inner class used (only) by the LinkedList class
	class Node {
		private Anything data;
		Node next;

		public Node(Anything a, Node n) {
			data = a;
			next = n;
		}

		public COM182LinkedList<Anything>.Node getNextt() {
			// TODO Auto-generated method stub
			return next;
		}

		public void setNextt(COM182LinkedList<Anything>.Node prev) {
			// TODO Auto-generated method stub
			this.next=prev;
			
		}

		
	}

	Node first;
	int length;

	public COM182LinkedList() {
		first = null;
		length = 0;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void addFirst(Anything d) {
		/*
		 * These two lines can be reduced to the single line which follows 
		 * Node temp =first; 
		 * first = new Node(d,temp);
		 */
		
		
		  Node temp = new Node(d,first);
		  temp.next = first; first = temp;
		  
		  if(next == null)
		  { next = temp; 
		  length++; 
		  }
		 
		/*
		 * if(length==0) {
		 * 
		 * first = new Node(d, first); length++;
		 * 
		 * }
		 */
		
			
	       
	}

	public int size() {
		return length;
	}

	public void clear() {
		first = null;
		length = 0;
	}

	public boolean contains(Anything value) {
		for (Node curr = first; curr != null; curr = curr.next) {
			//System.out.print(value.toString());
			
			if (value.equals(curr.data)) {
				return true;
			}
		}
		return false;
	}

	public Anything get(int index) {
		if (index < 0 || index >= length) {
			System.out.println("Index of " + index + " out of range");
			return null;
		}

		Node curr = first;
		for (int i = 0; i < index; i++)
			curr = curr.next;
		return curr.data;
	}

	public boolean remove(Anything m) {
		Node curr = first;
		Node lastVisited = null;

		while (curr != null) {
			if (m.equals(curr.data)) {
				length--;
				if (curr != first) {
					lastVisited.next = curr.next;
				} else {
					first = first.next;
				}
				return true;
			}

			lastVisited = curr;
			curr = curr.next;
		}
		return false;
	}

	public String toString() {
		StringBuilder result = new StringBuilder(); // String result = "";
		for (Node curr = first; curr != null; curr = curr.next)
			result.append(curr.data + "->"); // result = result + curr.data + "->";
		result.append("[null]");
		return result.toString(); // return result + "[null]";
	}

	// ------ COMP182: Methods that you have to write-----------------------\\

	public Anything getFirst() {
		if (first == null) {
            System.out.println("Error: List is empty");
            return null;
        } else {
            return first.data;
        }
	}

	public Anything getLast() {
		
		if (first == null) {
            System.err.println("Error: List is empty");
            return null;
        }
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
		
	}

	public void add(Anything value) {

		Node newNode = new Node(value, first);
	    first = newNode;
	    length++;
		/*
		 * if(length>0) {
		 * 
		 * } else { System.out.
		 * print("List is empty and add first data by using addfirst() method"); }
		 */
		
	}

	public void addAfter(int index, Anything value) {

		 if (first == null) {
	            return;
	        }

	        Node current = first;
	        int i = 0;
	        while (i < index && current.next != null) {
	            current = current.next;
	            i++;
	        }

	        Node newNode = new Node(value,first);
	        newNode.next = current.next;
	        current.next = newNode;
	        length++;
		
	}

	public Anything set(int index, Anything newValue) {
		if (index < 0 || index >= length) {
            System.out.println("Error: Index out of range.");
            return null;
        }
        Node current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Anything oldValue = current.data;
        current.data = newValue;
        return oldValue;
	}
	
	public void removeAll(Anything value) {
		 Node current = first;
		    Node prev = null;

		    while (current != null) {
		        if (current.data.equals(value)) {
		            if (prev == null) {
		                // If the node to be removed is the head node
		                first = current.next;
		            } else {
		                prev.next = current.next;
		            }
		            length--;
		        } else {
		            prev = current;
		        }
		        current = current.next;
		    }
	}

	public int lastIndex(Anything value) {
		int index = -1;
        int i = 0;
        Node current = first;
        while (current != null) {
            if (Objects.equals(current.data, value)) {
                index = i;
            }
            current = current.next;
            i++;
        }
        return index;

	}

	public COM182LinkedList<Anything> clone() {
		COM182LinkedList<Anything> newList = new COM182LinkedList<Anything>();
        Node currNode = first;
        while (currNode != null) {
            newList.add(currNode.data);
            currNode = currNode.next;
        }
        return newList;
	}

	

	public boolean equals(Object o) {
		// check if the object is null or not an instance of COMP182LinkedList
	    if (o == null || !(o instanceof COM182LinkedList)) {
	        return false;
	    }
	    
	    // cast the object to a COMP182LinkedList variable
	    COM182LinkedList<Anything> list = (COM182LinkedList<Anything>) o;
	    
	    // check if the two lists have the same size
	    if (this.size() != list.size()) {
	        return false;
	    }
	    
	    // iterate over both lists and compare their elements
	    Node node1 = first;
	    Node node2 = list.first;
	    while (node1 != null) {
	        if (!node1.data.equals(node2.data)) {
	            return false;
	        }
	        node1 = node1.next;
	        node2 = node2.next;
	    }
	    
	    // if we've made it here, the lists are equal
	    return true;
	}

	public COM182LinkedList<Anything> split() {
		// Handle empty and single-element lists
	    if (first == null || first.next == null) {
	        return new COM182LinkedList<Anything>();
	    }

	    // Use two pointers to find the middle of the list
	    Node slow = first;
	    Node fast = first.next;
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }

	    // Split the list into two by cutting the link between the slow and fast pointers
	    Node backHead = slow.next;
	    slow.next = null;

	    // Create a new list with the back half of the original list
	    COM182LinkedList<Anything> backList = new COM182LinkedList<Anything>();
	    backList.first = backHead;
	    backList.length = length - (length / 2);

	    // Update the size of the original list
	    length = length / 2 + (length % 2);

	    return backList;

	}

	
	public boolean hasCycle() {
		  Node slow = first;
	        Node  fast = first;

	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;

	            if (slow == fast) {
	                return true;
	            }
	        }

	        return false;

	}


	public Node reverseList() {
		Node prev = null;
        Node current = first;
        Node next = null;

        while (current != null) {
            next = current.getNextt();
            current.setNextt(prev);
            prev = current;
            current = next;
        }

        return prev;
        

	}

	public Node oddEvenList() {
		if (first == null || first.next == null) {
            return first;
        }
        
        Node odd = first;
        Node even = first.next;
        Node evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        
        odd.next = evenHead;
        
        return first;
	}
   
   public Node deleteDuplicates () {
	   if (first == null || first.next == null) {
           return first;
       }

       Node current = first;
       while (current != null && current.next != null) {
           if (current.data == current.next.data) {
               current.next = current.next.next;
           } else {
               current = current.next;
           }
       }

       return first;
   
   }
   
  
   public boolean isPalindrome() {
       if (first == null) {
           return false;
       }
       Node slow = first;
       Node fast = first;
       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;
       }
       if (fast != null) {
           slow = slow.next;
       }
       slow = reverse(slow);
       fast = first;
       while (slow != null) {
           if (!slow.data.equals(fast.data)) {
               return false;
           }
           slow = slow.next;
           fast = fast.next;
       }
       return true;
   }

   private COM182LinkedList<Anything>.Node reverse(COM182LinkedList<Anything>.Node slow) {
	   Node  prev = null;
       Node current = slow;
       while (current != null) {
           Node next = current.next;
           current.next = prev;
           prev = current;
           current = next;
       }
       return prev;
}


   static void printList(COM182LinkedList<String>.Node node) {
       while (node != null) {
           System.out.print(node.data + " ");
           node = node.next;
           
       }
   }
	public static void main(String[] args) {
		   COM182LinkedList<String> list0 = new COM182LinkedList<String>();//string input mean
	    
		   // add first
		        list0.addFirst("Saddam hossen");
		        list0.addFirst("Saddam hossen khan");//not granted
		        
		        //add any
		        list0.add("saddam khan nvn");
		        list0.add("saddam bus");
		        //add after index
		        list0.addAfter(0, "jakir");
		        
		        //set new node according to index
		        list0.set(3, "Jafor");
		        System.out.print("before removing node:\n");
		        System.out.print(list0.toString()+"\n");
		        list0.removeAll("jakir");
		        System.out.print("after removing node:\n");
		        //remove all node according to given node;
		        
		       System.out.print(list0.toString()+"\n");
		       
		       // last index
		       System.out.print( list0.lastIndex("Jafor")+"\n");
		       
		       // anything getlast
		       System.out.print( list0.getLast()+"\n");
		       
		       // anything get first 
		       System.out.print( list0.getFirst()+"\n");
		       
		       // check cycle
		       COM182LinkedList<String> list1 = new COM182LinkedList<String>();
		       list1.addFirst("10");
		       list1.add("5");
		       list1.add("20");
		       if(list1.hasCycle()){ 
		           System.out.println("Linked List is cyclic "); 
		           
		       }
		       else{ 
		           System.out.println("LinkedList is not cyclic "); 
		           
		       }
		       // node reverse
		       printList(list0.reverseList());
		       //delete duplicate
			   COM182LinkedList<String> list = new COM182LinkedList<String>();//string input mean
   
		        list.addFirst("1");
		        list.add("2");
		        list.add("2");
		        list.add("3");
		        list.add("3");
		        list.add("3");
		        list.add("4");
		        list.deleteDuplicates();
		        list. printList(list.deleteDuplicates());
		        list.clear();
		        
		        list.addFirst("1");
		        list.add("2");
		        list.add("3");
		        list.add("2");
		        list.add("1");
		        boolean isPalindrome = list.isPalindrome();
		        System.out.println("\nIs the list a palindrome? " + isPalindrome+"\n");

		       
		      System.out.print("\n"+list0.length);

	        //System.out.print(list0.get(0));
		// Here you can create some lists (use lists of Strings
		// to test) and thoroughly test each of your new methods
	}
}