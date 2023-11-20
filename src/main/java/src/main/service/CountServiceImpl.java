package src.main.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import src.main.exception.ValidationException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CountServiceImpl implements CountService {
    private Map<Character, Integer> charMap = new HashMap<>();

    @Override
    public String getCountOfSymbols(String inputStr) {
        charMap.clear();
        StringBuilder result = new StringBuilder();
        if (inputStr == null || inputStr.isBlank()) {
            throw new ValidationException("Получена пустая строка");
        }
        for (char chr : inputStr.toCharArray()) {
            if (!charMap.containsKey(chr)) {
                charMap.put(chr, 1);
            } else {
                charMap.put(chr, charMap.get(chr) + 1);
            }
        }
        Map<Character, Integer> sortedMap = charMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        StringBuilder finalResult = result;
        sortedMap.entrySet().stream().forEach(entry -> finalResult
                .append("\"")
                .append(entry.getKey())
                .append("\": ")
                .append(entry.getValue())
                .append(", ")
        );
        result.delete(result.length() - 2, result.length());
        return result.toString();
    }
}