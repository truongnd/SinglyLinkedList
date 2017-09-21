package utils;

public class LinkedList {
	Node head;

	public void deleteNode(int key) {
		Node temp = head, prev = null;

		if (temp != null && temp.data == key) {
			head = temp.next;
			return;
		}

		while (temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;

		prev.next = temp.next;
	}
	
	public void removeTail() {
		Node temp = head;
		
		while (temp != null && temp.next != null) {
			if(temp.next.next == null) {
				temp.next = null;
				break;
			}
			temp = temp.next;
		}
	}
	
	public void removeGT(int target) {
		Node temp = head, prev = null;
		
		if(temp.data > target) {
			head = temp.next;
			temp = head;
		}
		
		while (temp != null) {
			if(temp.data > target) {
				if(prev == null) {
					head = temp.next;
					temp = head;
				} else {
					prev.next = temp.next;
					temp = prev.next;
				}
			} else {
				prev = temp;
				temp = temp.next;
			}
		}
		
		if (temp == null)
			return;
	}

	public void append(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
	}

	public static void main(String[] args) {
		LinkedList llist = new LinkedList();

		llist.append(7);
		llist.append(1);
		llist.append(3);
		llist.append(2);

		System.out.println("\nCreated Linked list is:");
		llist.printList();

//		llist.deleteNode(1);
//		llist.removeTail();
		llist.removeGT(1);

		System.out.println("\nLinked List after process:");
		llist.printList();
	}
}