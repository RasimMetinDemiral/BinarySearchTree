// BinarySearchTree sınıfı
public class BinarySearchTree {
    // Root düğümü
    Node root;

    // Constructor
    BinarySearchTree() {
        root = null;
    }

    // Yeni bir eleman ekleme metodu
    void insert(int data) {
        root = insertRec(root, data);
    }

    // Yeni elemanı ekleme yardımcı metodu (recursive)
    Node insertRec(Node root, int data) {
        // Ağacın boş olup olmadığını kontrol et
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Ağaç boş değilse, uygun alt ağaca ekle
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    // Verilen elemanın ağaçta olup olmadığını kontrol etme metodu
    boolean search(int data) {
        return searchRec(root, data);
    }

    // Elemanı arama yardımcı metodu (recursive)
    boolean searchRec(Node root, int data) {
        // Ağaç boş veya eleman kök düğümde ise
        if (root == null || root.data == data)
            return root != null;

        // Eleman kök düğümde değilse, uygun alt ağaca git
        if (data < root.data)
            return searchRec(root.left, data);
        else
            return searchRec(root.right, data);
    }

    void delete(int data) {
        root = deleteRec(root, data);
    }

    // Verilen elemanı silme yardımcı metodu (recursive)
    Node deleteRec(Node root, int data) {
        // Ağaç boşsa veya eleman ağaçta bulunmuyorsa
        if (root == null)
            return root;

        // Silinecek eleman küçükse, sol alt ağaca git
        if (data < root.data)
            root.left = deleteRec(root.left, data);
            // Silinecek eleman büyükse, sağ alt ağaca git
        else if (data > root.data)
            root.right = deleteRec(root.right, data);
            // Eğer eleman bulunduysa
        else {
            // Eğer sadece bir çocuğu veya hiç çocuğu yoksa
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // İki child ı olan bir düğümü silme
            // Silinecek düğümün yerine en küçük sağ alt ağaç düğümü yerleştirilir
            root.data = minValue(root.right);

            // En küçük sağ alt ağaç düğümünü sil
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Verilen ağaçta en küçük değeri bulma metodu
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }
}
