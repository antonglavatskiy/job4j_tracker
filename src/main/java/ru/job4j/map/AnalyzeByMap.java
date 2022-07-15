package ru.job4j.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.getScore();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.getScore();
                count++;
            }
            rsl.add(new Label(pupil.name(), sum / count));
        }
        return rsl;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, List<Integer>> listMap = createMap(pupils);
        for (String str : listMap.keySet()) {
            rsl.add(new Label(str, avg(listMap.get(str))));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        int max = 0;
        String bestName = null;
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.getScore();
            }
            if (sum > max) {
                max = sum;
                bestName = pupil.name();
            }
        }
        return new Label(bestName, max);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, List<Integer>> listMap = createMap(pupils);
        int max = 0;
        String bestName = null;
        for (String str : listMap.keySet()) {
            int sum = sum(listMap.get(str));
            if (sum > max) {
                max = sum;
                bestName = str;
            }
        }
        return new Label(bestName, max);
    }

    private static Map<String, List<Integer>> createMap(List<Pupil> pupils) {
        Map<String, List<Integer>> listMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!listMap.containsKey(subject.getName())) {
                    List<Integer> list = new ArrayList<>();
                    list.add(subject.getScore());
                    listMap.put(subject.getName(), list);
                } else {
                    listMap.get(subject.getName()).add(subject.getScore());
                }
            }
        }
        return listMap;
    }

    private static double avg(List<Integer> list) {
        double sum = 0;
        for (Integer score : list) {
            sum += score;
        }
        return sum / list.size();
    }

    private static int sum(List<Integer> list) {
        int sum = 0;
        for (Integer score : list) {
            sum += score;
        }
        return sum;
    }
}
