import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCommentsTest {

    @Test
    void getFile() throws IOException {
        RemoveComments removeComments = new RemoveComments();
        File result = new File(System.getProperty("user.dir") + File.separator + "TestJavaFile.java");
        File resultFile = removeComments.removeCommentsFromFile(result);
        assertTrue(resultFile.exists());
        assertNotNull(resultFile);
    }

    @Test
    void processStringFile() {
        RemoveComments removeComments = new RemoveComments();
        String EXPECTED = "        String string = new String(\"// а вот строковые литералы не трогает //\"); ";
        String TEST_LINE = "        String string = new String(\"// а вот строковые литералы не трогает //\"); //зато трогает комменты на той же строке";
        assertEquals(EXPECTED, removeComments.processLineWithStrings(TEST_LINE));
    }

}