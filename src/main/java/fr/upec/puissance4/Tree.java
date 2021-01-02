package fr.upec.puissance4;

public class Tree {
    private Node root;

    public Tree(Node root){
        this.root = root;
    }
    public Tree(){
    }

    public Node getRoot() {
        return root;
    }

    public static Tree createTreeProba(Game game, Coin disk){
        Tree tree = new Tree();
        tree.root = createTreeProbaRec(game, disk, game.getGrid().getWidth()-1, 2);
        return tree;
    }
    public static Node createTreeProbaRec(Game game, Coin disk, int right, int left){
        Node node = new Node(game.clone());
        //node.getGame().place(right, disk);
        if(right == 0){
            return node;
        } else if (left == 0){
            node.setRight(createTreeProbaRec(node.getGame(), disk, right - 1, 0));
        } else {
            node.setLeft(createTreeProbaRec(node.getGame(), Coin.invert(disk), game.getGrid().getWidth()-1, left - 1));
            node.setRight(createTreeProbaRec(node.getGame(), disk, right - 1, left));
        }
        return node;
    }

    public void computeScore(Node node){
        if(node != null){
            node.setScore(node.getGame().verify());
            computeScore(node.getLeft());
            computeScore(node.getRight());
        }
    }

    public void affichage_arbo(){
        System.out.println("Test:");
        aff_arbo(root, "", "", root.getGame().getGrid().getWidth()-1, 2);
    }
    public void aff_arbo(Node node, String pipe, String space, int right, int left){
        System.out.println(pipe + node.getScore());
        if(right == 0){} 
        else if (left == 0){
            aff_arbo(node, pipe, space, right - 1, 0);
        } else {
            aff_arbo(node, space + "|", space + " ", root.getGame().getGrid().getWidth(), left - 1);
            aff_arbo(node, pipe, space, right - 1, left);
        }
    }
}
