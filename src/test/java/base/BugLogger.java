package base;

import java.io.FileWriter;
import java.io.IOException;

public class BugLogger {
    public static void logBug(String title, String severity, String expected, String actual, String steps) {
        try (FileWriter fw = new FileWriter("dynamic_bugs_report.txt", true)) {
            fw.write("\n🔴 " + title + "\n");
            fw.write("Severity: " + severity + "\n");
            fw.write("Expected: " + expected + "\n");
            fw.write("Actual: " + actual + "\n");
            fw.write("Steps to Reproduce:\n" + steps + "\n");
            fw.write("--------------------------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}