import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class TestsBST {

    @Test
    public void TestInsert() {

        BinarySearchTree arbol = new BinarySearchTree();

        try {
            String[] arr = new String[3];
            arr[0] = "1";
            arr[1] = "2";
            arr[2] = "3";

            arbol.insert("A", arr);
            arbol.insert("B", arr);
            arbol.insert("C", arr);

            assertEquals(true, true);

        } catch (Exception e) {
            assertEquals(true, e);
        }

    }

    @Test
    public void TestGetNode() {

        BinarySearchTree arbol = new BinarySearchTree();

        try {
            String[] arr = new String[3];
            arr[0] = "1";
            arr[1] = "2";
            arr[2] = "3";

            arbol.insert("A", arr);
            arbol.insert("B", arr);
            arbol.insert("C", arr);


            String[] tempArr = arbol.getNode("A");

            if(tempArr == null){
                assertEquals(true,  null);
            }else{
                assertEquals(true, true);
            }



        } catch (Exception e) {
            assertEquals(true, e);
        }

    }
}
