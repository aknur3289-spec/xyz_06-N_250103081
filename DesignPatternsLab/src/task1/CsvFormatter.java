package task1;


public class CsvFormatter implements ReportFormatter {
    @Override
    public String format(String title, String[] headers, String[][] rows) {
        StringBuilder sb = new StringBuilder();
        sb.append("# TITLE: ").append(title).append("\n");
        sb.append(java.util.Arrays.stream(headers).map(TextEscaping::csv).collect(java.util.stream.Collectors.joining(","))).append("\n");
        for (String[] row : rows) {
            sb.append(java.util.Arrays.stream(row).map(TextEscaping::csv).collect(java.util.stream.Collectors.joining(","))).append("\n");
        }
        return sb.toString();
    }
}
