public static int[] vectorAdd(int x, int y, int dx, int dy) {
    return new int[]{x + dx, y + dy};
}
public static void main(String[] args) {
    int a=0;
    int b=2;
    int[] results = vectorAdd(a,b,1,1);
    a = results[0];
    b = results[1];
    System.out.println(a+" "+b);
}

private int sum(int[] a){
    int total = 0;
    for (int i : a) {
        total += i;
    }
    return total;
}

private int[] cumsum(int[] a){
    int total = 0;
    for (int i = 0; i < a.length; i++){
        total += a[i];
        a[i] = total;
    }
    return a;
}

private int[] positives (int[] a){
    // First pass to check number of positive elements
    int numPos = 0;
    for (int i : a){
        if (i > 0) numPos++;
    }
    int[] returnVal = new int[numPos];
    int currentIndex = 0;
    for (int i : a) {
        if (i > 0) {
            returnVal[currentIndex] = i;
            currentIndex++;
        }
    }
    return returnVal;
}

public class MyClass{ // (c)
    private int primitiveVariable; // (a)
    private MyClass referenceVariable; // (b)

    public MyClass(int i){
        primitiveVariable = i;
        referenceVariable = null;
    }

    public void CreateObject(){
        referenceVariable = new MyClass(0); // (d)
    }
}

public class LinkedList{
    private class LinkedListNode{
        public int value;
        public LinkedListNode next;

        public LinkedListNode(int val){
            value = val;
        }
    }

    private LinkedListNode head;

    public LinkedList(){
        head = null;
    }

    public void Add(int val){
        if (head == null) head = new LinkedListNode(val);
        else{
            LinkedListNode next = head;
            while (next != null){
                if (next.next == null) next.next = new LinkedListNode(val);
                else next = next.next;
            }
        }
    }

    public void Remove(int val){
        if (head == null) throw new RuntimeException("List doesn't contain item");
        else if (head.value == val) head = head.next;
        else{
            LinkedListNode past = head;
            LinkedListNode current = head.next;
            while (current != null){

                if (current.value == val){
                    past.next = current.next;
                    return;
                }
                else{
                    past = current;
                    current = current.next;
                }
            }
            throw new RuntimeException("List doesn't contain item");
        }
    }

    public LinkedListNode GetHead() { return head; }

    public int Get(int index){
        if (head == null) throw new RuntimeException("Index out of range");
        else{
            LinkedListNode next = head;
            int counter = 0;
            while (next != null){
                if (next.next == null && counter != index) throw new RuntimeException("Index out of range");
                else{
                    if (counter == index){
                        return next.value;
                    }
                    else{
                        counter++;
                        next = next.next;
                    }
                }
            }
        }
        throw new RuntimeException("Index out of range");
    }

    public int Length(){
        if (head == null) return 0;
        else{
            int counter = 1;
            LinkedListNode next = head;
            while (next != null){
                if (next.next == null) break;
                else{
                    next = next.next;
                    counter++;
                }
            }
            return counter;
        }
    }

    public boolean DetectCycles(){
        HashSet<LinkedListNode> visited = new HashSet<>();

        LinkedListNode current = head;
        while (current != null){
            if (!visited.add(current)) return true;
            visited.add(current);
            current = current.next;
        }
        return false;
    }
}

public class Stack{
    private int[] array;
    private int top;

    public Stack(){
        array = new int[16];
        top = -1;
    }

    public void Push(int val){
        if (top == array.length - 1){
            int[] newArray = new int[array.length + array.length/2];
            for (int i = 0; i < array.length; i++){
                newArray[i] = array[i];
            }
            array = newArray;
        }
        top++;
        array[top] = val;
    }

    public int Pop(){
        if (top == -1) throw new RuntimeException("Stack is empty");
        else{
            top--;
            return array[top + 1];
        }
    }

    public int Peek(){
        if (top == -1) throw new RuntimeException("Stack is empty");
        else return array[top];
    }

    public boolean IsEmpty() { return top == -1; }

    public int Size() { return top + 1; }
}