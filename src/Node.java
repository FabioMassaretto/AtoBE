class Node {
  private Node leftChild, rightChild;

  public Node(Node leftChild, Node rightChild) {
    this.leftChild = leftChild;
    this.rightChild = rightChild;
  }

  public Node getLeftChild() {
    return this.leftChild;
  }

  public Node getRightChild() {
    return this.rightChild;
  }

  public static int height(Node root) {
    if(root == null) {
      return 0;
    }

    int leftHeight = height(root.getLeftChild());
    int rightHeight = height(root.getRightChild());

    return Math.max(leftHeight, rightHeight) + 1;
  }

  public static void main(String[] args) {
    Node leaf1 = new Node(null, null);
    Node leaf2 = new Node(null, null);
    Node node = new Node(leaf1, null);
    Node root = new Node(node, leaf2);

    System.out.println(height(root));
  }
}