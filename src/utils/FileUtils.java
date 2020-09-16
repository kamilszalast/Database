package utils;

import java.io.File;

/**
 * Check if path is Valid
 */
public class FileUtils {
    private FileUtils() {
    }

    public static boolean isFilePathValid(String path) {
        return new File(path).exists();
    }
}
