package com.clansty.dstest;

public class SingleLinkedList {
    private SingleLinkedListItem head=null;

    public void add(int n){
        if(head==null){
            head=new SingleLinkedListItem(n);
        }
        else{
            SingleLinkedListItem last=head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=new SingleLinkedListItem(n);
        }
    }

    private SingleLinkedListItem getItem(int index){
        SingleLinkedListItem item=head;
        for (int i = 0; i < index; i++) {
            if(item.next==null)
                throw new ArrayIndexOutOfBoundsException();
            item=item.next;
        }
        return item;
    }

    public int get(int index){
        return getItem(index).value;
    }

    public int size(){
        if(head==null){
            return 0;
        }
        SingleLinkedListItem item=head;
        int count=1;
        while (item.next!=null){
            count++;
            item=item.next;
        }
        return count;
    }

    public void insert(int number,int index){
        if(index==0){
            var next=head;
            head=new SingleLinkedListItem(number);
            head.next=next;
        }
        else {
            var previous=getItem(index-1);
            var next=previous.next;
            previous.next=new SingleLinkedListItem(number);
            previous.next.next=next;
        }
    }

    public void delete(int index){
        if(index==0){
            head=head.next;
        }
        else{
            var previous=getItem(index-1);
            previous.next=previous.next.next;
        }
    }
}
