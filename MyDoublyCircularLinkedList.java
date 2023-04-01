import java.util.HashMap;



public class MyDoublyCircularLinkedList<T>
{

    public static void main(String[] args)
    {
        MyDoublyCircularLinkedList<Employee> mylist = new
                MyDoublyCircularLinkedList<Employee>();
        Employee e1 = new Employee("1",6000);
        Employee e2 = new Employee("2",7000);
        Employee e3 = new Employee("3",8000);
        Employee e4 = new Employee("4",6000);
        Employee e5 = new Employee("5",4000);
        Employee e6 = new Employee("6",9500);
        Employee e7 = new Employee("999",9000);
        Employee e8 = new Employee("7",4500);
        mylist.insert(1, e1); //1
        mylist.insert(2, e2); //1 2
        mylist.insert(3, e3); //1 2 3
        mylist.insert(4, e4); //1 2 3 4

//test 1
        System.out.println("-------------------");
        mylist.printAll(); //1 2 3 4 5 6
        System.out.println("-------------------");
//test 2
        mylist.remove(1); //2 3 4 5 6

        mylist.insert(1, e7); //999 2 3 4 6
        System.out.println("*********************");
        mylist.printAll(); //999 2 3 4 6

        mylist.search(e4); //4
        mylist.print(2); //2
        System.out.println("*********************");
        System.out.println( "Max: "+mylist.findMax());
        System.out.println("Min: "+mylist.findMin());



//test 3
        System.out.println("+++++++++++++");
        mylist.remove(7); //remove failed
        mylist.remove(1); //2 3 4 6
        mylist.insert(9, e8); //insert failed
        mylist.print(1);

        mylist.search(e5); //search failed
        mylist.print(5); //print failed
        mylist.printAll(); //1 2 3 4 5 6
        System.out.println("+++++++++++++");
    }
    public MyDoublyCircularLinkedList()
    {

    }
public class MyNode<T>
{
    T data;
    MyNode nextNode;
    MyNode prevNode;

    public MyNode(T data)
    {
        this.data = data;
        nextNode = null;
        prevNode = null;

    }
    public String toString()
    {
        return ""+data +" "+prevNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(MyNode prevNode) {
        this.prevNode = prevNode;
    }

    public MyNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyNode nextNode) {
        this.nextNode = nextNode;
    }
}


    public int  size =0;
    private MyNode head;
    private MyNode tail;

    public void insert(int index,T data)
    {
        MyNode control = head;
        MyNode temp = new MyNode(data);
        if(index>0)
        {
            if(head == null && index==1)
            {
                head=temp;
                head.nextNode = null;
                head.prevNode = null;
                size++;
            }
            else
            {
                for(int i=0;i<index-1;i++)
                {
                    if(i==0)
                        control = head;
                    else
                        control = control.nextNode;
                }
                control.nextNode=temp;
                temp.prevNode=control;
                temp.nextNode=null;
                size++;
            }
        }else
            System.out.println("insert failed");
    }
    public void reverseInsert(int index,T data)
    {}
    public void remove(int index)
    {
        MyNode control = head;

        if (index > 0) {
            if (head != null && index == 1)
            {
                head = null;
                head.prevNode=null;
                head.nextNode.prevNode=null;
                size--;
            } else
            {
                for (int i = 0; i < index - 1; i++)
                {
                    if (i == 0)
                        control = head;
                    else
                        control = control.nextNode;
                }
                control.nextNode=control.nextNode.nextNode;
                control.nextNode.nextNode.prevNode=control;
                size--;

            }
        } else
            System.out.println("remove failed");
    }
    public void reverseRemove(int index)
    {}

    public void search(T d)
    {
        MyNode control = head;
        int controlIndex = 1;
        String str ="";
        while(control !=null)
        {
           if(control.getData()==d)
           {
               str += controlIndex;
               break;
           }
           controlIndex++;
        }
        if(str == "")
            System.out.println("search failed");
        else
            System.out.println(str);
    }

    public void print(int index)
    {
        if(index>0 && index<=size)
        {
            MyNode control = head;
            for (int i = 1; i<index ; i++)
            {
                control=control.nextNode;
            }
            System.out.println(control.getData());
        }else
            System.out.println("print failed");
    }
    public void printAll()
    {
        if(size!=0 )
        {
            MyNode control = head;
            System.out.print(control.getData() + ",");
            for (int i = 0; i < size - 3; i++)
            {
                for (int k = 1; k < i + 2; i++)
                {
                    control = control.nextNode;
                }

                System.out.println(control.getData() + ",");
            }
        }else
            System.out.println("printAll failed");
    }
    public HashMap ToHashMap()
    {
        return null;
    }

    public T findMin()
    {
        MyNode control = head;
        int controlData = (int) head.getData();
        for (int i = 0; i < size - 1; i++)
        {
            for (int k = 1; k < i + 2; i++)
            {
                control = control.nextNode;
            }

            if ((int) controlData > (int) control.getData())
                controlData = (int) control.getData();
        }
         return null;
     }
        public T findMax()
         {
             MyNode control = head;
             int controlData = (int)head.getData();
             for (int i = 0; i < size - 1; i++)
             {
                 for (int k = 1; k < i + 2; i++)
                 {
                     control = control.nextNode;
                 }

                 if((int)controlData > (int)control.getData())
                     controlData = (int)control.getData();
             }
             System.out.println(controlData);
            return null;
         }

        public void fromHashMap(HashMap<Integer,T> map)
        {

        }




    public void reversePrintAll(){}
    public String toString()
    {
        return ""+head.getData() +" "+head.getNextNode();
    }
}
