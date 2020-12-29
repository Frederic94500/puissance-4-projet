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
        node.getGame().place(right, disk);
        /*if(left != -1){
            if(right != -1){
                node.setRight(createTreeProbaRec(node.getGame(), disk, right - 1, 0));
            }
            node.setLeft(createTreeProbaRec(node.getGame(), disk, game.getGrid().getWidth()-1, left - 1));
        }*/
        /*if(right == 0){
            node.setLeft(createTreeProbaRec(node.getGame(), disk, game.getGrid().getWidth()-1, left - 1));
        } else if (left == 0){
            node.setRight(createTreeProbaRec(node.getGame(), disk, right - 1, 0));
        } else if (left == 0 && right == 0){
            return node;
        } else {
            node.setLeft(createTreeProbaRec(node.getGame(), disk, game.getGrid().getWidth()-1, left - 1));
            node.setRight(createTreeProbaRec(node.getGame(), disk, right - 1, left));
        }*/
        if(right == 0){
            return node;
        } else if (left == 0 && right == 0) {
            return node;
        } else {
            node.setRight(createTreeProbaRec(node.getGame(), disk, right - 1, left));
            node.setLeft(createTreeProbaRec(node.getGame(), disk, game.getGrid().getWidth()-1, left - 1));
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
    }
    public void aff_arbo(Node node, String pipe, String space){
        if(node != null){
            System.out.println(pipe + node.getScore());
            aff_arbo(node.getLeft(), space + "|", space + " ");
        }
    }
}
