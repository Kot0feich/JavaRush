package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList <String> implements Cloneable, Serializable {
    static class Entry <T> implements Serializable{
        String elementName;
        Long lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren=true;
            availableToAddRightChildren=true;
        }
        public boolean isAvailableToAddChildren () {
            return availableToAddLeftChildren||availableToAddRightChildren;
        }
    }

    Entry<String> root;
    List<Entry<String>> list = new LinkedList<>();
    int size = 0;

    public Long countLineNumber (String s) {
        Double lineNumber = Math.floor(Math.log(Integer.parseInt(s)+1)/Math.log(2));
        return Math.round(lineNumber);
    }
    public CustomTree() {
        this.root = new Entry<>("0");
        root.lineNumber=  0L;
        list.add(root);

    }

    public Entry<String> get (String element) {
        Iterator <Entry<String>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry<String> entryCurrent = iterator.next();
            if (element.equals(entryCurrent.elementName)) return entryCurrent;
        }
        return null;
    }
    public void viewEntry (String s) {
        Entry<String> entryCurrent = get(s);
        if (entryCurrent==null) System.out.println(s + " not found");
        else {
            String leftChildElementName = entryCurrent.leftChild!=null ? entryCurrent.leftChild.elementName : "null";
            String rightChildElementName = entryCurrent.rightChild!=null ? entryCurrent.rightChild.elementName : "null";
            String parentElementName = entryCurrent.parent!=null?entryCurrent.parent.elementName:"null";
            String stringLineNumber = entryCurrent.lineNumber!=null?entryCurrent.lineNumber.toString():"null";
            System.out.println("parent " + parentElementName);
            System.out.println("line number " + stringLineNumber);
            System.out.println("elementName = " + entryCurrent.elementName);
            System.out.println("availableToAddLeftChildren, availableToAddRightChildren: " + entryCurrent.availableToAddLeftChildren + "," + entryCurrent.availableToAddRightChildren);
            System.out.println("leftChild = " + leftChildElementName +
                    " rightChild = " + rightChildElementName);
        }
    }
    public void viewEntryAll ()
    {
        Iterator <Entry<String>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry<String> entryCurrent = iterator.next();
            viewEntry(entryCurrent.elementName);
        }
    }
    public String getParent (String s) {

    Entry <String> entry = get(s);
    if (entry!=null) return entry.parent.elementName;
    else return null;
    }

    public Entry<String> getRoot() {
        return root;
    }
    public Entry<String> findFirstWithEmptyChildWithLineNum(String s) {
        Entry<String> returnedNode = null;
        Queue<Entry<String>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Entry<String> node = nodes.remove();
            if (node.isAvailableToAddChildren() && node.lineNumber + 1 == countLineNumber(s)) {
                returnedNode = node;
                break;
            } else {
                if (node.leftChild != null) {
                    nodes.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    nodes.add(node.rightChild);
                }
            }
        }
        return returnedNode;
    }

    public Entry<String> findFirstWithEmptyChild(String s) {
        Entry<String> returnedNode=null;
        Queue<Entry<String>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Entry<String> node = nodes.remove();
            if (node.isAvailableToAddChildren()) {
                returnedNode=node;
                break;
            }
            else {
                if (node.leftChild != null) {
                    nodes.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    nodes.add(node.rightChild);
                }
            }
        }
        return returnedNode;
    }
    public void clearChild ()
    {
        Iterator <Entry<String>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry<String> entryCurrent = iterator.next();
            if (entryCurrent.rightChild==null&&!entryCurrent.availableToAddRightChildren) entryCurrent.availableToAddRightChildren=true;
            if (entryCurrent.leftChild==null&&!entryCurrent.availableToAddLeftChildren) entryCurrent.availableToAddLeftChildren=true;
        }
    }
    @Override
    public boolean add(String s) {
        Entry<String> parent = null;
        Queue<Entry<String>> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Entry<String> node = nodes.remove();
            if (node.isAvailableToAddChildren()) {
                parent=node;
                break;
            }
            else {
                if (node.leftChild != null) {
                    nodes.add(node.leftChild);
                }
                if (node.rightChild != null) {
                    nodes.add(node.rightChild);
                }
            }
        }

        //if (!s.equals("0"))
//            parent = findFirstWithEmptyChildWithLineNum(s);
            //if (parent==null) parent = findFirstWithEmptyChild(s);
/*            if (parent==null) {
                clearChild ();
                parent = findFirstWithEmptyChildWithLineNum(s);
                if (parent==null) parent = findFirstWithEmptyChild(s);
            }*/

        Entry<String> current = new Entry<>(s);
        if (parent.availableToAddLeftChildren) {
            parent.availableToAddLeftChildren=false;
            parent.leftChild=current;
        }
        else {
            parent.availableToAddRightChildren=false;
            parent.rightChild=current;
        }
        current.parent=parent;
        current.lineNumber = countLineNumber(s);
        size++;
        list.add(current);
        return true;
    }

    public void add(int index, String element) {

        throw new UnsupportedOperationException();
    }

    @Override
    public String get(int index) {
        String returnedName="";
        if (index==0) returnedName=root.elementName;
        else returnedName=list.get(index-1).elementName;
        return returnedName;

        //throw new UnsupportedOperationException();
    }
    @Override
    public int size() {
        return size;
        //throw new UnsupportedOperationException();
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    public int getIndexList (Entry <String> node) {
        for (int i=1;i<list.size();i++)
            if (list.get(i).elementName.equals(node.elementName)) return i;
            return -1;
    }
    public Entry<String> findLeaf(String s) {
        Entry<String> firstNode = get((String) s);
        Queue<Entry<String>> nodes = new LinkedList<>();
        nodes.add(firstNode);
        while (!nodes.isEmpty()) {
            Entry<String> node = nodes.remove();
            if (node.leftChild != null) {
                nodes.add(node.leftChild);
            }
            if (node.rightChild != null) {
                nodes.add(node.rightChild);
            }
            //if (node.availableToAddLeftChildren&&node.availableToAddRightChildren) {
            if (node.leftChild==null && node.rightChild==null) {
                return node;
            }
        }
        return null;
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean remove(Object s) {
        if (!(s instanceof String)) throw new UnsupportedOperationException();
        boolean stop = false;
        while (!stop) {
            Entry<String> node = findLeaf((String) s);
            Entry <String> parent = node.parent;
            if (parent.rightChild!=null) {
                if (parent.rightChild.elementName.equals(node.elementName)) {
                    parent.rightChild=null;
                    parent.availableToAddRightChildren=true;
                }
            }
            if (parent.leftChild!=null) {
                if (parent.leftChild.elementName.equals(node.elementName)) {
                    parent.leftChild=null;
                    parent.availableToAddLeftChildren=true;
                }
            }
            size--;
            list.remove(getIndexList(node));
            if (node.elementName.equals(s))
            {
                stop=true;
            }
        }
        return stop;
    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
}
