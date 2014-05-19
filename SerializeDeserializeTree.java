
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * program to serialize / deserialize tree. the tree can have any number of
 * child nodes the convention for writing the tree is as per the following
 * example a<b<c<>d<>>e<f<>>g<h<i<>j<>k<>>>> makes the following tree 
 * a 
 * b 
 * e g c
 * d f h ijk
 *
 * @author anupam
 */
public class SerializeDeserializeTree {

    public GenericTreeNode deserializeTree(String s) {
         HashMap<Integer, Integer> levelChild = new HashMap<>();
        int level = 0;
        GenericTreeNode n = new GenericTreeNode();
        GenericTreeNode temp = n;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '<':
                    level++;                    
                    break;
                case '>':
                    level--;
                    temp = temp.parent;
                    break;
                default:
                    int childNum;
                    GenericTreeNode newNode = new GenericTreeNode();
                    newNode.parent = temp;
                    temp.children.add(newNode);
                    if (levelChild.containsKey(level)) {
                        childNum = levelChild.get(level) + 1;
                        levelChild.put(level, childNum);
                    } else {
                        childNum = 0;
                        levelChild.put(level, childNum);
                    }                    
                    temp.val = c;
                    temp = temp.children.get(childNum);
                    break;
            }
        }
        return n;
    }

    public String serializeTree(GenericTreeNode root) {
        String op = "";
        if (root.children.size() > 0) {
            op = op + root.val;
            for (GenericTreeNode g : root.children) {
                op = op + "<" + serializeTree(g) + ">";
            }
        } else {
            op = op + root.val + "<>";
        }
        return op;
    }

    public static void main(String[] arg) {
        SerializeDeserializeTree sdt = new SerializeDeserializeTree();
        System.out.println(sdt.serializeTree(sdt.deserializeTree("a<b<c<>>d<>e<f<>>>")));
    }
}

class GenericTreeNode {

    char val;
    List<GenericTreeNode> children = new ArrayList<>();
    GenericTreeNode parent;
}
