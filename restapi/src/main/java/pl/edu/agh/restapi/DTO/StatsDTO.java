package pl.edu.agh.restapi.DTO;

import pl.edu.agh.restapi.DAO.BreweryDAO;

import java.util.*;
import java.util.stream.Collectors;

public class StatsDTO {

    /**
     * The main method finding the top 3 words
     * (less if there are less than 3 frequent words and
     * more if there are more than 3 words with the same frequency).
     *
     * Returns an empty list if all words occur not more than once.
     *
     * @param breweries  the list of breweries to make statistics form
     * @return three the most frequent words in brewery names
     */
    public List<WordDTO> findTop3Words(BreweryDAO[] breweries){
        List<String> allWords = getAllWords(breweries);

        Map<String, Integer> counterMap = new HashMap<>();
        for (String word : allWords){
            counterMap.put(word, counterMap.getOrDefault(word, 0) + 1);
        }

        List<WordDTO> top3 = new LinkedList<>();
        while (top3.size() < 3 && !counterMap.isEmpty()) {
            fillTopListWithMostFrequentWords(counterMap, top3);
        }

        return filterRareWords(top3);
    }

    /**
     * Gets the list of all the words from brewery names.
     *
     * @param breweries  the list of breweries
     * @return the list of all the words from brewery names
     */
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

    /**
     * Based on map with each word frequency
     * fills the given list with the most frequent word(s)
     * (and then deletes these words from the map).
     *
     * @param counterMap  the map with each word frequency
     * @param top3  the list to fill
     */
    private void fillTopListWithMostFrequentWords(Map<String, Integer> counterMap, List<WordDTO> top3){
        int max = findMaxFrequency(counterMap);
        List<String> toDelete = new LinkedList<>();
        for (Map.Entry<String, Integer> pair : counterMap.entrySet()){
            if (pair.getValue() == max){
                String word = pair.getKey();
                top3.add(new WordDTO(word, max));
                toDelete.add(word);
            }
        }
        toDelete.forEach(counterMap::remove);
    }

    /**
     * Finds the max word frequency in the map.
     *
     * @param counterMap  the map with each word frequency
     * @return the max word frequency
     */
    private int findMaxFrequency(Map<String, Integer> counterMap){
        int max = -1;
        for (int count : counterMap.values()){
            max = Math.max(max, count);
        }
        return max;
    }

    /**
     * Removes from the list all the words that occurred just once.
     *
     * @param top3  the list to filter
     * @return the filtered list
     */
    private List<WordDTO> filterRareWords(List<WordDTO> top3){
        return top3.stream().filter(word -> word.getFrequency() > 1).collect(Collectors.toList());
    }
}
