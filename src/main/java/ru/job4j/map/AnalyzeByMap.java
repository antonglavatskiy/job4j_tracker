package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            rsl.add(new Label(pupil.name(), sum / count));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, List<Integer>> listMap = createMap(pupils);
        for (String str : listMap.keySet()) {
            rsl.add(new Label(str, avg(listMap.get(str))));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(), sum));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, List<Integer>> listMap = createMap(pupils);
        for (String str : listMap.keySet()) {
            rsl.add(new Label(str, sum(listMap.get(str))));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    private static Map<String, List<Integer>> createMap(List<Pupil> pupils) {
        Map<String, List<Integer>> listMap = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!listMap.containsKey(subject.name())) {
                    List<Integer> list = new ArrayList<>();
                    list.add(subject.score());
                    listMap.put(subject.name(), list);
                } else {
                    listMap.get(subject.name()).add(subject.score());
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
