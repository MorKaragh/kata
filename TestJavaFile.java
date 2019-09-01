import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

// класс, который удаляет комменты
class RemoveCommentsTest { // удаляет комменты

    //@Govnocode
    @Test
    //получить файл
    void getFile() throws FileNotFoundException { //бросает эксепшон

        //удаляет комменты
        RemoveComments removeComments = new RemoveComments();

        String string = new String("// а вот // \"стро // ковые\" // литералы // не // трогает //"); //зато трогает комменты на той же строке

        //проверяет, что файл не "null"
        File file = new File(System.getProperty("user.dir") + File.separator + "TestJavaFile.java");
        assertNotNull(removeComments.fromFile(file));
        assertTrue()

    }
}