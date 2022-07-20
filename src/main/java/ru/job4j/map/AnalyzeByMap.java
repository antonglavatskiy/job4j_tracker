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
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rsl.add(new Label(pupil.name(),
                    sum / pupil.subjects().size()));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        Map<String, Integer> map = createMap(pupils);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            rsl.add(new Label(pair.getKey(),
                    pair.getValue() / (double) pupils.size()));
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
        Map<String, Integer> map = createMap(pupils);
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            rsl.add(new Label(pair.getKey(), pair.getValue()));
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    private static Map<String, Integer> createMap(List<Pupil> pupils) {
        Map<String, Integer> rsl = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl.computeIfPresent(subject.name(), (key, value) -> value + subject.score());
                rsl.putIfAbsent(subject.name(), subject.score());
            }
        }
        return rsl;
    }
}
