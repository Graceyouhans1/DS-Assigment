package dynamicqueueimplementation;
public class DynamicQueueImplementation {
int arrayQueue[];
int head= 0;
int tail = - 1;
int currentSize = 0 ;
private final int power = 3 ;
public DynamicQueueImplementation(){
arrayQueue= new int[this .power];
}
private boolean isFull() {
        return currentSize == 1;
    }
    private boolean isEmpty() {
    return currentSize == power;   
    }
public void enqueue( int item) {
if (isFull()) {
System.out.println( "Queue is full so you have to increase its POWER.." );
increasePower();
}
 tail ++;
if ( tail  >= arrayQueue.length && currentSize != arrayQueue.length){
 tail  = 0 ;
}
arrayQueue[ tail ] = item;
currentSize++;
System.out.println( "Adding: " + item);
}
public void dequeue() {
if (isEmpty()) {
System.out.println( "It'sImpossible to remove element from Queue" );
} else {
head++;
if(head > arrayQueue.length- 1){
System.out.println( "removed: " +arrayQueue[head- 1 ]);
head = 0 ;
} else {
System.out.println( "removed: " +arrayQueue[head- 1 ]);
}
currentSize--;
}
}
public boolean isQueueFull(){
boolean status = false ;
if (currentSize == arrayQueue.length){
status = true ;
}
return status;
}
public boolean isQueueEmpty(){
boolean status = false ;
if (currentSize == 0 ){
status = true ;
}
return status;
}
private void increasePower(){
int newCapacity = this .arrayQueue.length* 2;
int [] newArray = new int [newCapacity];
int tmpHead = head;
int index = - 1;
while (true ){
newArray[++index] = this.arrayQueue[tmpHead];
tmpHead++;
if(tmpHead == this .arrayQueue.length){
tmpHead= 0 ;
}
if(currentSize == index+ 1){
break ;
}
}
this .arrayQueue = newArray;
System.out.println( "New Array capacity is: " +this .arrayQueue.length);
this .head = 0;
this .head = index;
}
public static void main(String []args){
DynamicQueueImplementation queue = new DynamicQueueImplementation();
queue.enqueue( 6);
queue.enqueue( 10);
queue.enqueue( 22);
queue.dequeue();
queue.enqueue( 9);
queue.dequeue();
queue.enqueue( 4);
queue.enqueue( 2);
queue.dequeue();
queue.dequeue();
queue.dequeue();
queue.enqueue( 5 );
queue.dequeue();
queue.dequeue();
}}