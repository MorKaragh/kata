import java.io.*;

public class RemoveComments {


    public File removeCommentsFromFile(File file) throws IOException {
        try(
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter("result.java"));
        ) {
            String line = reader.readLine();
            while (line != null) {
                String lineToAdd = removeComments(line);
                if (lineToAdd != null) {
                    fileWriter.write(lineToAdd + "\n");
                }
                line = reader.readLine();
            }
            return new File(System.getProperty("user.dir") + "/result.java");
        }

    }

    private String removeComments(String line) {
        String lineToAdd;
        if (line.contains("//")) {
            lineToAdd = processContainingCommentSymbol(line);
        } else {
            lineToAdd = line;
        }
        return lineToAdd;
    }

    private String processContainingCommentSymbol(String line) {
        if (line.trim().startsWith("//")) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        String[] parts = line.split("\"");
        boolean lineWithString = parts.length > 1;
        if (lineWithString) {
            result.append(processLineWithStrings(line));
            return result.toString();
        } else {
            result.append(line, 0, line.indexOf("//"));
            return result.toString();
        }
    }

    protected String processLineWithStrings(String line) {
        String regex = "[^\\\\]\\\"";
        String[] split = line.split(regex);
        StringBuilder result = new StringBuilder();
        boolean isLiteral = false;
        for (String s : split) {
            if (isLiteral) {
                result.append("\"").append(s).append("\"");
            } else {
                if (s.contains("//")){
                    String adding = s.substring(0, s.indexOf("//"));
                    result.append(adding);
                    return result.toString();
                } else {
                    result.append(s);
                }
            }
            isLiteral = !isLiteral;
        }
        return result.toString();
    }




}
