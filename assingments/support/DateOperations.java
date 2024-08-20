package assingments.support;

public interface DateOperations {
    String detectDateTimeFormat(String dateTimeString);
    String addDefaultTimeIfNeeded(String dateTimeString, String detectedFormat);
}
