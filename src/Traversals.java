import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> output = new ArrayList<>();

        traversePreorderNext(root, output);

        return output;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> output = new ArrayList<>();

        traverseInorderNext(root, output);

        return output;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        List<T> output = new ArrayList<>();

        traversePostorderNext(root, output);

        return output;
    }

    private void traversePreorderNext(TreeNode<T> input, List<T> list) {

        if (input != null) {

            list.add(input.getData());
            traversePreorderNext(input.getLeft(), list);
            traversePreorderNext(input.getRight(), list);

        }
    }

    private void traverseInorderNext(TreeNode<T> input, List<T> list) {

        if (input != null) {

            traverseInorderNext(input.getLeft(), list);
            list.add(input.getData());
            traverseInorderNext(input.getRight(), list);

        }
    }

    private void traversePostorderNext(TreeNode<T> input, List<T> list) {

        if (input != null) {

            traversePostorderNext(input.getLeft(), list);
            traversePostorderNext(input.getRight(), list);
            list.add(input.getData());

        }
    }
}