public class LinkedList<T> implements List<T>
{    Node<T> head; //head of list
    int size;
    public class Node<T>
    {
        T data;
        Node<T> next;
       public Node(T item)
       {
           this.data = item;
           this.next = null;
       }

    }


    public LinkedList()
    {
        head = null;
        this.size=0; //initilizes size of linked list to 0
    }
    public void add(T item)
    {
        if(head ==null)
        {
            head = new Node(item); //if the head is null, meaning the array is empty, it adds the item to the head
            ++size; //increments size of list
        }
        else
        {
            Node<T> prev = head; //creates a node "previous" saves it as head
            while(prev.next != null)
            {
                prev = prev.next;
            }
            Node<T> current = new Node(item);
            prev.next = current;
            ++size;
        }
    }
    public void add(int pos, T item)
    {
        if(pos>size || pos<0)
        {
            return;
        }
        if(pos == 0)
        {
            Node current = new Node(item);
            current.next = head;
            head = current;
            size++;
        }
        else
        {
            Node current = new Node(item);
            Node prev = head;
            for(int i=0; i<pos-1; i++)
            {
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;
            ++size;
        }
    }
    public T get(int pos)
    {
        if(pos >size || pos<0)
            return null;
        Node<T> prev = head;
        for(int i=0; i<pos-1; i++)
        {
            prev= prev.next;
        } return prev.data;
    }
    public T remove(int pos)
    {   Node<T> temp;
        if(pos>size-1 || pos<0)
        {
            return null;

        }
        if(pos==0)
        {
             temp = head;
            head = head.next;
            size--;
        }
        else {
            Node<T> prev = head;
            for (int i = 0; i < pos - 1; i++) {
                prev = prev.next;
            }
             temp = prev.next;
            prev.next = temp.next;
            size--;
        } return temp.data;
    }
    public int size()
    {
        return size;
    }

}