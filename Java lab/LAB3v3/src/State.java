import java.util.ArrayList;

public enum State {

    NEW {
        @Override
        State doNext(Tree tree) {
            ArrayList<Leaf> leafList = new ArrayList();
            int leavesAmount= (int) (Math.random()*9+1);
            while (0 <= leavesAmount--){
                leafList.add(new Leaf());
            }
            //tree.setLeaves(leafList);
            System.out.println(this);
            System.out.println(tree);
            return BLOOM;
        }
    },
    BLOOM {
        @Override
        State doNext(Tree tree) {
            System.out.println(this);
            System.out.println("Tree blooms");
            return YELLOWING;
        }
    },
    YELLOWING {
        @Override
        State doNext(Tree tree) {
            System.out.println(this);
            System.out.println(tree);
            return FALLING;
        }
    },
    FALLING {
        @Override
        State doNext(Tree tree) {
            System.out.println(this);
            System.out.println(tree);
            return FROSTED;
        }
    },
    FROSTED {
        @Override
        State doNext(Tree tree) {
            System.out.println(this);
            System.out.println("Tree is frosted");
            return NEW;
        }
    };

    abstract State doNext(Tree tree);
}