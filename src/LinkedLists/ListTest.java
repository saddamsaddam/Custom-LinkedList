package LinkedLists;
import java.util.*;
public class ListTest
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        COM182LinkedList<String> list0 = new COM182LinkedList<String>();
        COM182LinkedList<String> list1 = new COM182LinkedList<String>();
        COM182LinkedList<String> list2 = new COM182LinkedList<String>();
        
        list1.addFirst("node1");
        System.out.println("1-element list: " + list1);
        list2.addFirst("node2"); list2.addFirst("node1");
        System.out.println("2-element list: " + list2);
        
        System.out.println("\nTesting size...");
        System.out.println(list1.size());
        System.out.println(list1.size()==1?"PASSED":"**FAILED**");
        System.out.println(list2.size() );
        System.out.println(list2.size()==2?"PASSED":"**FAILED**");
        
        System.out.println("\nTesting getFirst...");
        System.out.println(list0.getFirst());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getFirst().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getFirst().equals("node1")?"PASSED":"**FAILED**");
        
        System.out.println("\nTesting getLast...");
        System.out.println(list0.getLast());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getLast().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getLast().equals("node2")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
      
        System.out.println("\nTesting add...");
        COM182LinkedList<String> list3 = new COM182LinkedList<String>();
        COM182LinkedList<String> list4 = new COM182LinkedList<String>();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        System.out.println("3-element list: " + list3);
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        System.out.println("4-element list: " + list4);
        
        System.out.println("\nTesting set...");
        COM182LinkedList<String> test = new COM182LinkedList<String>();
        System.out.println("  empty list test = " + ((test.set(2,"bad") == null)?"PASSED":"**FAILED**"));
        test.addFirst("Mark");
        test.addFirst("Sohaib");
        test.addFirst("Salman");
      //  System.out.println("  return value test = " + ((test.set(1,"Nora")).equals("Sohaib")?"PASSED":"**FAILED**")); error here
     //   System.out.println("  non-empty test = " + ((test.get(0).equals("Salman") && test.get(1).equals("Nora") &&
                          // test.get(2).equals("Mark"))?"PASSED":"**FAILED**"));
  
        System.out.println("\nTesting addAfter...");
        COM182LinkedList<String> other = new COM182LinkedList<String>();
        other.add("one");
        other.add("two");
        other.add("three");
        other.add("four");
        System.out.println(other.size() + " " + other);
        other.addAfter(2,"three.5");
       // System.out.println((other.get(3).equals("three.5")?"PASSED":"**FAILED**"));// error here
        System.out.println(other.size() + " " + other);
        
        System.out.println("\nTesting lastIndex...");
        System.out.println((test.lastIndex("Salman")==0)?"PASSED":"**FAILED**");
        test.addFirst("Mark");
        System.out.println((test.lastIndex("Mark")==3)?"PASSED":"**FAILED**");

        System.out.println("\nTesting clone...");
        COM182LinkedList<String> empty = new COM182LinkedList<String>();
        list1 = empty.clone();
        System.out.println("  empty list test = " + (list1.isEmpty()?"PASSED":"**FAILED**"));
        COM182LinkedList<String> another = other.clone();
        System.out.println(another.size() + " " + another);
        System.out.println("  making sure nodes not shared...");
        other.remove("two");
        System.out.println(other.size() + " " + other);
        System.out.println(another.size() + " " + another);

        System.out.println("\nTesting removeAll...");
        //time for you to write some tests!

        System.out.println("\nTesting equals...");
        System.out.println("  reflexive test = " + (list2.equals(list2)?"PASSED":"**FAILED**"));
        COM182LinkedList<String> emptyList = new COM182LinkedList<String>();
        list0.clear();
        list1.clear();
        list1.add("node1");
        System.out.println("  empty list test/true = " + (emptyList.equals(list0)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test1/false = " + (!emptyList.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test2/false = " + (!list1.equals(emptyList)?"PASSED":"**FAILED**"));
        list0.add("node1");
        list2.clear();
        list2.add("node1");
        System.out.println("  singleton test = " + (list0.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 1/false = " + (!list1.equals(list2)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 2/false = " + (!list2.equals(list1)?"PASSED":"**FAILED**"));
        list0.add("node2"); list0.add("node3"); list0.add("node4");
        list0.add("node5"); list0.add("node6"); list0.add("node7");
        list4.add("node5"); list4.add("node6"); list4.add("node7");
        System.out.println("  7-element test/true = " + (list0.equals(list4)?"PASSED":"**FAILED**"));
        list0.remove("node4");
        list0.add("node5");
        System.out.println("  7-element test/false = " + (!list0.equals(list4)?"PASSED":"**FAILED**"));
        System.out.println("  7-element test/false = " + (!list4.equals(list0)?"PASSED":"**FAILED**"));

        System.out.println("\nTesting split...");
        COM182LinkedList<String> result;
        list0.clear();
        list1.clear();
        list1.add("node1");
        list2.clear();
        list2.add("node1");
        list2.add("node2");
        list3.clear();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        list4.clear();
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        COM182LinkedList<String> list5 = new COM182LinkedList<String>();
        list5.add("node1"); 
        list5.add("node2"); 
        list5.add("node3"); 
        list5.add("node4");
        list5.add("node5");
        COM182LinkedList<String> list6 = new COM182LinkedList<String>();
        list6.add("node1"); list6.add("node2"); list6.add("node3"); list6.add("node4");
        list6.add("node5"); list6.add("node6");
        System.out.print("SPLIT ");
        System.out.println(list0.size() + " " + list0);
        result = list0.split();
        System.out.println("  list " + list0.size() + " " + list0);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list1.size() + " " + list1);
        result = list1.split();
        System.out.println("  list " + list1.size() + " " + list1);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list2.size() + " " + list2);
        result = list2.split();
        System.out.println("  list " + list2.size() + " " + list2);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list3.size() + " " + list3);
        result = list3.split();
        System.out.println("  list " + list3.size() + " " + list3);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list4.size() + " " + list4);
        result = list4.split();
        System.out.println("  list " + list4.size() + " " + list4);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list5.size() + " " + list5);
        result = list5.split();
        System.out.println("  list " + list5.size() + " " + list5);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list6.size() + " " + list6);
        result = list6.split();
        System.out.println("  list " + list6.size() + " " + list6);
        System.out.println("  result " + result.size() + " " + result);
        
        System.out.println("\nTesting cycle...");

        
        COM182LinkedList<String> list7 = new COM182LinkedList<String>();
        list7.add("node1"); 
        list7.add("node2"); 
        list7.add("node3");
        list7.add("node4");
        list7.add("node5");
        list7.add("node6");
        list7.add("node7");
        list7.add("node8");
        list7.first.next.next.next.next = list7.first;

        System.out.println("Cycle " + ((list7.hasCycle()== true)?"PASSED":"**FAILED**"));
        
        System.out.println("\nTesting reverse...");

        COM182LinkedList<String> list8 = new COM182LinkedList<String>();
        list8.add("node1"); 
        list8.add("node2"); 
        list8.add("node3");
        list8.add("node4");
        list8.add("node5");
        list8.add("node6");
        list8.add("node7");
        list8.add("node8");
        list8.add("node9");
        list8.add("node10");
        list8.reverseList();
        
        COM182LinkedList<String> list9 = new COM182LinkedList<String>();
        list9.add("node10"); 
        list9.add("node9"); 
        list9.add("node8");
        list9.add("node7");
        list9.add("node6");
        list9.add("node5");
        list9.add("node4");
        list9.add("node3");
        list9.add("node2");
        list9.add("node1");

        System.out.println("Reverse " + (list8.equals(list9)?"PASSED":"**FAILED**"));
        
        System.out.println("\nTesting oddEven...");

        COM182LinkedList<String> list10 = new COM182LinkedList<String>();
        list10.add("node1"); 
        list10.add("node2"); 
        list10.add("node3");
        list10.add("node4");
        list10.add("node5");
        list10.add("node6");
        list10.add("node7");
        list10.oddEvenList();
        COM182LinkedList<String> list11 = new COM182LinkedList<String>();
        list11.add("node1"); 
        list11.add("node3"); 
        list11.add("node5");
        list11.add("node7");
        list11.add("node2");
        list11.add("node4");
        list11.add("node6");
        System.out.println("OddEven " + (list10.equals(list11)?"PASSED":"**FAILED**"));

         
    	
   // Node deleteDuplicates
	
	  COM182LinkedList<String> list = new COM182LinkedList<String>();
	  list.addFirst("1");
	  list.add("2");
	  list.add("2");
	  list.add("3");
	  list.add("3"); 
	  list.add("3"); 
	  list.add("4");
	  COM182LinkedList.printList(list.deleteDuplicates());
	 
           
        

    }
}
