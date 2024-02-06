public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Eleman ekleme
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Eleman arama
        System.out.println(tree.search(60)); // true

        tree.delete(30);
        System.out.println(tree.search(30)); // true

    }
}
