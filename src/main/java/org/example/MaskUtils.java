package org.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MaskUtils {

    public Map<String, String> maskData(Map<String, String> headersMap) {

        return headersMap.entrySet().stream()
                .map(MaskUtils::apply)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static Map.Entry<String, String> apply(Map.Entry<String, String> header) {
        if (Arrays.stream(MaskSensitiveData.values())
                .anyMatch(sensitiveData -> sensitiveData.name().equalsIgnoreCase(header.getValue()))) {
            header.setValue(MaskConstant.maskedString);
        }
        return header;
    }
}
