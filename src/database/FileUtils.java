package database;

import java.io.File;

/**
 * Check if path is Valid
 */
public class FileUtils {
    static boolean isFilePathValid(String path) {
        return new File(path).exists();
    }
}
