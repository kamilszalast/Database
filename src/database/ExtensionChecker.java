package database;

import java.util.Optional;

public class ExtensionChecker {
    public Optional<String> getExtensionsByStringHandling(String filename) {
        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }
}
