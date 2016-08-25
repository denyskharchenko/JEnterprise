package module01;

import module01.utils.CollectionsTimeTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) throws IOException {
        System.out.println("Java Enterprise. Module #1 \n");

        int elements = 10_000;
        int tests = 100;

        String fileName = "result_" + elements + ".txt";

        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Set hashSet = new HashSet();
        Set treeSet = new TreeSet();

        CollectionsTimeTest timeTest = new CollectionsTimeTest();

        String[][] resultTable = new String[23][5];

        for (int i = 0; i < resultTable.length; i++) {
            for (int j = 0; j < resultTable[0].length; j++) {
                resultTable[i][j] = " - ";
            }
        }

        resultTable[0][0] = " # ";
        resultTable[0][1] = "ArrayList";
        resultTable[0][2] = "LinkedList";
        resultTable[0][3] = "HashSet";
        resultTable[0][4] = "TreeSet";

        resultTable[1][0] = "populate";
        resultTable[2][0] = "add(index) top";
        resultTable[3][0] = "add(index) mid";
        resultTable[4][0] = "add(index) end";
        resultTable[5][0] = "get(index) top";
        resultTable[6][0] = "get(index) mid";
        resultTable[7][0] = "get(index) end";
        resultTable[8][0] = "remove(index) top";
        resultTable[9][0] = "remove(index) mid";
        resultTable[10][0] = "remove(index) end";
        resultTable[11][0] = "contains(index) top";
        resultTable[12][0] = "contains(index) mid";
        resultTable[13][0] = "contains(index) end";
        resultTable[14][0] = "iterator.add() top";
        resultTable[15][0] = "iterator.add() mid";
        resultTable[16][0] = "iterator.add() end";
        resultTable[17][0] = "iterator.remove() top";
        resultTable[18][0] = "iterator.remove() mid";
        resultTable[19][0] = "iterator.remove() end";
        resultTable[20][0] = "add(value)";
        resultTable[21][0] = "remove(value)";
        resultTable[22][0] = "contains(value)";

        long startTime = System.currentTimeMillis();

        resultTable[1][1] = String.valueOf(timeTest.populateCollectionTest(arrayList, elements, tests));
        resultTable[1][2] = String.valueOf(timeTest.populateCollectionTest(linkedList, elements, tests));
        resultTable[1][3] = String.valueOf(timeTest.populateCollectionTest(hashSet, elements, tests));
        resultTable[1][4] = String.valueOf(timeTest.populateCollectionTest(treeSet, elements, tests));

        resultTable[2][1] = String.valueOf(timeTest.addToIndexListTest(arrayList, elements, tests, "top"));
        resultTable[2][2] = String.valueOf(timeTest.addToIndexListTest(linkedList, elements, tests, "top"));

        resultTable[3][1] = String.valueOf(timeTest.addToIndexListTest(arrayList, elements, tests, "middle"));
        resultTable[3][2] = String.valueOf(timeTest.addToIndexListTest(linkedList, elements, tests, "middle"));

        resultTable[4][1] = String.valueOf(timeTest.addToIndexListTest(arrayList, elements, tests, "end"));
        resultTable[4][2] = String.valueOf(timeTest.addToIndexListTest(linkedList, elements, tests, "end"));

        resultTable[5][1] = String.valueOf(timeTest.getFromIndexListTest(arrayList, elements, tests, "top"));
        resultTable[5][2] = String.valueOf(timeTest.getFromIndexListTest(linkedList, elements, tests, "top"));

        resultTable[6][1] = String.valueOf(timeTest.getFromIndexListTest(arrayList, elements, tests, "middle"));
        resultTable[6][2] = String.valueOf(timeTest.getFromIndexListTest(linkedList, elements, tests, "middle"));

        resultTable[7][1] = String.valueOf(timeTest.getFromIndexListTest(arrayList, elements, tests, "end"));
        resultTable[7][2] = String.valueOf(timeTest.getFromIndexListTest(linkedList, elements, tests, "end"));

        resultTable[8][1] = String.valueOf(timeTest.removeFromIndexListTest(arrayList, elements, tests, "top"));
        resultTable[8][2] = String.valueOf(timeTest.removeFromIndexListTest(linkedList, elements, tests, "top"));

        resultTable[9][1] = String.valueOf(timeTest.removeFromIndexListTest(arrayList, elements, tests, "middle"));
        resultTable[9][2] = String.valueOf(timeTest.removeFromIndexListTest(linkedList, elements, tests, "middle"));

        resultTable[10][1] = String.valueOf(timeTest.removeFromIndexListTest(arrayList, elements, tests, "end"));
        resultTable[10][2] = String.valueOf(timeTest.removeFromIndexListTest(linkedList, elements, tests, "end"));

        resultTable[11][1] = String.valueOf(timeTest.containsListTest(arrayList, elements, tests, "top"));
        resultTable[11][2] = String.valueOf(timeTest.containsListTest(linkedList, elements, tests, "top"));

        resultTable[12][1] = String.valueOf(timeTest.containsListTest(arrayList, elements, tests, "middle"));
        resultTable[12][2] = String.valueOf(timeTest.containsListTest(linkedList, elements, tests, "middle"));

        resultTable[13][1] = String.valueOf(timeTest.containsListTest(arrayList, elements, tests, "end"));
        resultTable[13][2] = String.valueOf(timeTest.containsListTest(linkedList, elements, tests, "end"));

        resultTable[14][1] = String.valueOf(timeTest.iteratorAddListTest(arrayList, elements, tests, "top"));
        resultTable[14][2] = String.valueOf(timeTest.iteratorAddListTest(linkedList, elements, tests, "top"));

        resultTable[15][1] = String.valueOf(timeTest.iteratorAddListTest(arrayList, elements, tests, "middle"));
        resultTable[15][2] = String.valueOf(timeTest.iteratorAddListTest(linkedList, elements, tests, "middle"));

        resultTable[16][1] = String.valueOf(timeTest.iteratorAddListTest(arrayList, elements, tests, "end"));
        resultTable[16][2] = String.valueOf(timeTest.iteratorAddListTest(linkedList, elements, tests, "end"));

        resultTable[17][1] = String.valueOf(timeTest.iteratorRemoveListTest(arrayList, elements, tests, "top"));
        resultTable[17][2] = String.valueOf(timeTest.iteratorRemoveListTest(linkedList, elements, tests, "top"));

        resultTable[18][1] = String.valueOf(timeTest.iteratorRemoveListTest(arrayList, elements, tests, "middle"));
        resultTable[18][2] = String.valueOf(timeTest.iteratorRemoveListTest(linkedList, elements, tests, "middle"));

        resultTable[19][1] = String.valueOf(timeTest.iteratorRemoveListTest(arrayList, elements, tests, "end"));
        resultTable[19][2] = String.valueOf(timeTest.iteratorRemoveListTest(linkedList, elements, tests, "end"));

        resultTable[20][3] = String.valueOf(timeTest.addSetTest(hashSet, elements, tests));
        resultTable[20][4] = String.valueOf(timeTest.addSetTest(treeSet, elements, tests));

        resultTable[21][3] = String.valueOf(timeTest.removeSetTest(hashSet, elements, tests));
        resultTable[21][4] = String.valueOf(timeTest.removeSetTest(treeSet, elements, tests));

        resultTable[22][3] = String.valueOf(timeTest.containsSetTest(hashSet, elements, tests));
        resultTable[22][4] = String.valueOf(timeTest.containsSetTest(treeSet, elements, tests));

        long endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime) / 1000;

        for (int i = 0; i < resultTable.length; i++) {
            for (int j = 0; j < resultTable[0].length; j++) {
                if (j == 0) {
                    System.out.printf("|   %-25s   |   ", resultTable[i][j]);
                } else {
                    System.out.printf("%-10s   |   ", resultTable[i][j]);
                }
            }
            System.out.println("\n+---------------------------------------------------------------------------------------------------+");
        }

        System.out.println();
        System.out.println("Number of tests: " + tests);
        System.out.println();
        System.out.println("Number of elements: " + elements);
        System.out.println();
        System.out.println("Test calculation time: " + elapsedTime + " sec");

        BufferedWriter textWriter = null;
        try {
            textWriter = new BufferedWriter(new FileWriter(fileName));

            textWriter.newLine();
            textWriter.flush();

            for (int i = 0; i < resultTable.length; i++) {
                for (int j = 0; j < resultTable[0].length; j++) {
                    if (j == 0) {
                        textWriter.write(new Formatter().format("|   %-25s   |   ", resultTable[i][j]).toString());
                    } else {
                        textWriter.write(new Formatter().format("%-10s   |   ", resultTable[i][j]).toString());
                    }
                    if (j == 4) {

                        textWriter.newLine();
                        textWriter.write("+");
                        for (int k = 0; k < 99; k++) {
                            textWriter.write("-");
                        }
                        textWriter.write("+");
                    }
                }
                textWriter.newLine();
                textWriter.flush();
            }

            textWriter.newLine();
            textWriter.write("Number of tests: " + tests);
            textWriter.newLine();
            textWriter.write("Number of elements: " + elements);
            textWriter.newLine();
            textWriter.write("Test calculation time: " + elapsedTime + " sec");

        } catch (IOException e) {
            System.out.println("Error! Cannot create file \"results.txt\"");
        } finally {
            if (textWriter != null) {
                textWriter.close();
            }
        }
    }
}
