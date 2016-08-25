package module01.utils;

import java.util.*;

public class CollectionsTimeTest {

    private long startTime;
    private long endTime;
    private long elapsedTime;
    private long resultTime;

    private int getIndex(int elementsAmount, String position) {
        int index = 0;
        switch (position) {
            case "top": {
                index = 0;
                break;
            }
            case "middle": {
                index = elementsAmount / 2;
                break;
            }
            case "end": {
                index = elementsAmount - 1;
                break;
            }
        }
        return index;
    }

    private void populateCollection(Collection<Integer> collection, int elementsAmount) {
        for (int i = 0; i < elementsAmount; i++) {
            collection.add(i);
        }
    }

    public long populateCollectionTest(Collection<Integer> collection, int elementsAmount, int testsAmount) {
        resultTime = 0;

        for (int i = 0; i < testsAmount; i++) {
            collection.clear();

            startTime = System.nanoTime();

            for (int j = 0; j < elementsAmount; j++) {
                collection.add(j);
            }

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }

        return resultTime / testsAmount;
    }

    public long addToIndexListTest(List<Integer> list, int elementsAmount, int testsAmount, String position) {
        int index = getIndex(elementsAmount, position);

        if (index == elementsAmount - 1) {
            index += 1;
        }

        list.clear();

        populateCollection(list, elementsAmount);

        resultTime = 0;

        for (int i = 0; i < testsAmount; i++) {
            startTime = System.nanoTime();

            list.add(index, index);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }

        return resultTime / testsAmount;
    }

    public long getFromIndexListTest(List<Integer> list, int elementsAmount, int testsAmount, String position) {
        int index = getIndex(elementsAmount, position);

        list.clear();

        populateCollection(list, elementsAmount);

        resultTime = 0;

        for (int i = 0; i < testsAmount; i++) {
            startTime = System.nanoTime();

            list.get(index);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }
        return resultTime / testsAmount;
    }

    public long removeFromIndexListTest(List<Integer> list, int elementsAmount, int testsAmount, String position) {
        int index = getIndex(elementsAmount, position);

        list.clear();

        populateCollection(list, elementsAmount);

        resultTime = 0;

        if (elementsAmount < testsAmount) {
            System.out.println("Error! Count of elements less than count of tests");
            return 0;
        } else {
            if (index == elementsAmount - 1) {
                for (int i = 0; i < testsAmount; i++) {
                    startTime = System.nanoTime();

                    list.remove(index - i);

                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    resultTime += elapsedTime;
                }
            } else {
                for (int i = 0; i < testsAmount; i++) {
                    startTime = System.nanoTime();

                    list.remove(index + i);

                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    resultTime += elapsedTime;
                }
            }
        }
        return resultTime / testsAmount;
    }

    public long containsListTest(List<Integer> list, int elementsAmount, int testsAmount, String position) {
        int index = getIndex(elementsAmount, position);

        list.clear();

        populateCollection(list, elementsAmount);

        resultTime = 0;

        for (int i = 0; i < testsAmount; i++) {
            startTime = System.nanoTime();

            list.contains(index);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }
        return resultTime / testsAmount;
    }

    public long iteratorAddListTest(List<Integer> list, int elementsAmount, int testsAmount, String position) {
        int index = getIndex(elementsAmount, position);

        list.clear();

        populateCollection(list, elementsAmount);

        resultTime = 0;

        ListIterator<Integer> iterator = list.listIterator(index);

        for (int i = 0; i < testsAmount; i++) {

            startTime = System.nanoTime();

            iterator.add(index);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }
        return resultTime / testsAmount;
    }

    public long iteratorRemoveListTest(List<Integer> list, int elementsAmount, int testsAmount, String position) {
        if (elementsAmount < testsAmount) {
            System.out.println("Error! Count of elements less than count of tests");
            return 0;
        } else {
            int index = getIndex(elementsAmount, position);

            if (index == elementsAmount - 1) {
                index += 1;
            }

            list.clear();

            populateCollection(list, elementsAmount);

            resultTime = 0;

            ListIterator<Integer> iterator = list.listIterator(index);

            if (iterator.hasNext()) {
                for (int i = 0; i < testsAmount; i++) {
                    startTime = System.nanoTime();

                    iterator.next();
                    iterator.remove();

                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    resultTime += elapsedTime;
                }
            } else {
                for (int i = 0; i < testsAmount; i++) {

                    startTime = System.nanoTime();

                    iterator.previous();
                    iterator.remove();

                    endTime = System.nanoTime();
                    elapsedTime = endTime - startTime;
                    resultTime += elapsedTime;
                }
            }
        }
        return resultTime / testsAmount;
    }

    public long addSetTest(Set<Integer> set, int elementsAmount, int testsAmount) {
        set.clear();

        populateCollection(set, elementsAmount);

        for (int j = 0; j < testsAmount; j++) {
            startTime = System.nanoTime();

            set.add(elementsAmount++);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }
        return resultTime / testsAmount;
    }

    public long removeSetTest(Set<Integer> set, int elementsAmount, int testsAmount) {
        set.clear();

        populateCollection(set, elementsAmount);

        for (int i = 0; i < testsAmount; i++) {
            startTime = System.nanoTime();

            set.remove(elementsAmount--);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }
        return resultTime / testsAmount;
    }

    public long containsSetTest(Set<Integer> set, int elementsAmount, int testsAmount) {
        set.clear();

        populateCollection(set, elementsAmount);

        for (int i = 0; i < testsAmount; i++) {
            startTime = System.nanoTime();

            set.contains(i);

            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            resultTime += elapsedTime;
        }
        return resultTime / testsAmount;
    }
}

