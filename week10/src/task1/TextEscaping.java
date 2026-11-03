package task1;

/** Escapes data at the output boundary without changing report contents. */
final class TextEscaping {
    private TextEscaping() { }

    static String json(String value) {
        StringBuilder out = new StringBuilder();
        for (char c : value.toCharArray()) {
            switch (c) {
                case '"': out.append("\\\""); break;
                case '\\': out.append("\\\\"); break;
                case '\n': out.append("\\n"); break;
                case '\r': out.append("\\r"); break;
                case '\t': out.append("\\t"); break;
                default:
                    if (c < 0x20) out.append(String.format("\\u%04x", (int)c));
                    else out.append(c);
            }
        }
        return out.toString();
    }

    static String csv(String value) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
}
