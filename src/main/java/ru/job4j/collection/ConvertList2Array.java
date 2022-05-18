package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] result = new int[groups][cells];
        int row = 0;
        int cell = 0;
        for (Integer num : list) {
            result[row][cell++] = num;
            if (cell == result[row].length) {
                row++;
                cell = 0;
            }
        }
        return result;
    }
}
