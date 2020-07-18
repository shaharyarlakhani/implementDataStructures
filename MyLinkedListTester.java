public class MyLinkedListTester {

    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();
        MyLinkedList l2 = new MyLinkedList();

        l1.add(1);
        l2.add(1);

        System.out.println(l1.toString());
        System.out.println(l2.toString());

        System.out.println(l1.equals(l2));
    }
}