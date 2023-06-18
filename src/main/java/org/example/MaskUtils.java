package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MaskUtils {

    public Map<String, String> maskData(Map<String, String> headersMap) {

        Map<String, String> maskedMap = headersMap.entrySet().stream()
                .map(header ->
                {
                    if (Arrays.stream(MaskSensitiveData.values())
                            .anyMatch(sensitiveData -> sensitiveData.name().equalsIgnoreCase(header.getValue()))) {
                        header.setValue(MaskConstant.maskedString);
                    }
                    return header;
                }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return maskedMap;
    }
}
