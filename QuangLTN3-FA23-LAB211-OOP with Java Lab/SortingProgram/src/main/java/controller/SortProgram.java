
package controller;



import Common.Algorithm;
import Common.Library;
import model.Element;
import view.Menu;

/**
 *
 * @author ACER
 */
public class SortProgram extends Menu<String> {

    static String[] mc = {"Sort", "Exit"};

    protected Library library;
    protected Algorithm algorithm;
    protected int[] array;
    protected int size_array;

    public SortProgram(Element element) {
        super("PROGRAMMING", mc);
        library = new Library();
        algorithm = new Algorithm();
        size_array = element.getSize_array();
        array = element.getArray();
        //1. Enter a possitive number
        //size_array = library.getInt("Enter number of array", 1, 100);
        //2. Create array by generate random integer in range
        //array = library.createArray(size_array);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 -> sort();
            case 2 -> System.exit(0);
        }
    }

    public void sort() {
        final String[] mcSort = {"Buddle Sort", "Quick Sort", "Exit"};
        class SortMenu extends Menu<String> {

            public SortMenu() {
                super("Sort Option", mcSort);
            }

            @Override
            public void execute(int n) {
                
                switch (n) {
                    case 1 -> {
                        System.out.println("Unsorted array: ");
                        library.display(array);
                        algorithm.buddleSort(array);
                        System.out.println("\nSorted array by Buddle Sort: ");
                        library.display(array);
                        System.out.println("");
                    }
                    case 2 -> {
                        System.out.println("Unsorted array: ");
                        library.display(array);
                        algorithm.quickSort(array, 0, size_array - 1);
                        System.out.println("\nSorted array by Quick Sort: ");
                        library.display(array);
                        System.out.println("");
                    }
                    case 3 -> System.exit(0);
                }
            }
        }
        SortMenu sm = new SortMenu();
        sm.run();
    }

   
}