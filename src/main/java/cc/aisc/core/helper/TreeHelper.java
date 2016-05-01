package cc.aisc.core.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by sjf on 16-5-1.
 */
public class TreeHelper<T extends TreeNode> {

    @SuppressWarnings("unchecked")
    public List<T> getTree(List<T> listData){
        List<T> listTree = new ArrayList<>();
        for(T node1 : listData){
            boolean flag = false;
            for (T node2 : listData){
                if (node1.getParentId() != null && node1.getParentId().equals(node2.getNid())){
                    flag = true;
                    if (node2.getNodeSet() == null){
                        node2.setNodeSet(new TreeSet<TreeNode>());
                    }
                    node2.getNodeSet().add(node1);
                    break;
                }
            }
            if (!flag){
                listTree.add(node1);
            }
        }
        return listTree;
    }
}
