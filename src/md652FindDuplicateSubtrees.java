import node.random.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class md652FindDuplicateSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);

        root.left = new TreeNode(0);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(0);
        root.left.right = null;  // null as specified
        root.right.left = null;  // null as specified
        root.right.right = new TreeNode(0);

        root.left.left.left = null;  // null as specified
        root.left.left.right = null; // null as specified
        root.right.right.left = null; // null as specified
        root.right.right.right = new TreeNode(0);

        md652FindDuplicateSubtrees test = new md652FindDuplicateSubtrees();
        List<TreeNode> result = test.findDuplicateSubtrees(root);
        System.out.println("Hello");
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        HashMap<String, Integer> hs = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        traverse(root, hs, result);
        return result;
    }

    String traverse(TreeNode n, HashMap<String, Integer> hs, List<TreeNode> result){
        if(n == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n.val);
        sb.append("(");
        sb.append(traverse(n.left, hs, result));
        sb.append(")");
        sb.append(traverse(n.right, hs, result));
        sb.append(",");
        String str = sb.toString();
        if(!hs.containsKey(str)){
            hs.put(str, 1);
        }else{
            hs.put(str, hs.get(str) + 1);
            if(hs.get(str) == 2){
                result.add(n);
            }
        }
        return str;
    }

}
