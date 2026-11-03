package task1;

public class CsvFormatter implements ReportFormatter {
    @Override
    public String format(String title, String[] headers, String[][] rows) {
        StringBuilder sb = new StringBuilder();
        sb.append("# TITLE: ").append(title).append("\n");
        appendRow(sb, headers);
        for (String[] row : rows) {
            appendRow(sb, row);
        }
        return sb.toString();
    }
    private void appendRow(StringBuilder sb, String[] values) {
        for (int i = 0; i < values.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(TextEscaping.csv(values[i]));
        }
        sb.append('\n');
    }
}
