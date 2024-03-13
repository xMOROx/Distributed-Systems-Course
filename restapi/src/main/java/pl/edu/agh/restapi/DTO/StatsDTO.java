package pl.edu.agh.restapi.DTO;

import pl.edu.agh.restapi.DAO.BreweryDAO;

import java.util.*;
import java.util.stream.Collectors;

public class StatsDTO {

    public List<WordDTO> findTopNWords(BreweryDAO[] breweries, int n){
        List<String> allWords = getAllWords(breweries);

        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : allWords){
            counterMap.put(word, counterMap.getOrDefault(word, 0) + 1);
        }

        List<WordDTO> topN = new LinkedList<>();
        for (int i = 0; i < n; i++){
            fillTopListWithMostTopNFrequentWords(counterMap, topN);
        }

        return filterRareWords(topN);
    }


    private List<String> getAllWords(BreweryDAO[] breweries){
        List<String> allWords = new LinkedList<>();
        for (BreweryDAO brewery : breweries){
            String[] words = brewery.getName()
                    .replaceAll("[^a-zA-Z ]", "")
                    .toLowerCase()
                    .split("\\s+");
            Arrays.stream(words).filter(word -> !word.isEmpty())
                    .forEach(allWords::add);
        }
        return allWords;
    }


    private void fillTopListWithMostTopNFrequentWords(Map<String, Integer> counterMap, List<WordDTO> topN){
        int max = findMaxFrequency(counterMap);
        List<String> toDelete = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : counterMap.entrySet()){
            if (entry.getValue() == max){
                topN.add(new WordDTO(entry.getKey(), entry.getValue()));
                toDelete.add(entry.getKey());
            }
        }
        toDelete.forEach(counterMap::remove);
    }


    private int findMaxFrequency(Map<String, Integer> counterMap){
        return counterMap.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }


    private List<WordDTO> filterRareWords(List<WordDTO> topN){
        return topN.stream()
                .filter(word -> word.getFrequency() > 1)
                .collect(Collectors.toList());
    }
}
