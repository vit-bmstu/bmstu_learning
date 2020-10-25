public class Main {
    //Equal objects must have equal hash codes
    public static void testLeaf(Leaf leaf1, Leaf leaf2){
        System.out.println(leaf1 + ", " + leaf2);
        System.out.print("leaf1.equals(leaf2):                  ");
        System.out.println(leaf1.equals(leaf2));
        System.out.print("leaf1.hashCode() == leaf2.hashCode(): ");
        System.out.println(leaf1.hashCode() == leaf2.hashCode());
        System.out.println("__________________________________________");
    }
    //Equal objects must have equal hash codes
    public static void testTree(Tree tree1, Tree tree2){
        System.out.println("__________________________________________");
        System.out.print("tree1.equals(tree2):                  ");
        System.out.println(tree1.equals(tree2));
        System.out.print("tree1.hashCode() == tree2.hashCode(): ");
        System.out.println(tree1.hashCode() == tree2.hashCode());
        System.out.println("__________________________________________");
    }

    public static void main(String[] args) {
        System.out.println("------------------------------------------");
        System.out.println("Testing Leaf");
        System.out.println("__________________________________________");
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        testLeaf(leaf1,leaf2);
        leaf1.turnYellow();
        testLeaf(leaf1,leaf2);

        System.out.println("------------------------------------------");
        System.out.println("Testing Tree");
        System.out.println("__________________________________________");
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        System.out.println(tree1 + ", " + tree2);
        testTree(tree1, tree2);

        for (int i = (int) (Math.random()*5+1); i > 0; i--) {
            tree1.changeState();
            tree2.changeState();
        }
        testTree(tree1, tree2);

    }
}