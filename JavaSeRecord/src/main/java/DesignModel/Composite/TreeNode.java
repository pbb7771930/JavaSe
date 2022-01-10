package DesignModel.Composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author admin
 */
public class TreeNode {
	private String name;  
    private TreeNode parent;  
    private final Vector<TreeNode> children = new Vector<>();
     
    public TreeNode(String name){  
        this.name = name;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public TreeNode getParent() {  
        return parent;  
    }  
  
    public void setParent(TreeNode parent) {  
        this.parent = parent;  
    }  
      

    public void add(TreeNode node){  
        children.add(node);  
    }  
      

    public void remove(TreeNode node){  
        children.remove(node);  
    }  
      

    public Enumeration<TreeNode> getChildren(){  
        return children.elements();  
    }
}
