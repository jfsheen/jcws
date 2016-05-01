package cc.aisc.core.helper;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sjf on 16-5-1.
 */
public abstract class TreeNode<T> implements Comparable{
    Integer nid;
    Integer level;
    Integer sort;
    Integer parentId;
    Set<T> nodeSet = new TreeSet<>();

    public TreeNode() {
    }

    @Override
    public int compareTo(Object o) {
        if (null != o && o instanceof TreeNode) return this.sort - ((TreeNode) o).getSort();
        return 0;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Set<T> getNodeSet() {
        return nodeSet;
    }

    public void setNodeSet(Set<T> nodeSet) {
        this.nodeSet = nodeSet;
    }
}
