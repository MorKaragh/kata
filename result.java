import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCommentsTest { 

    @Test
    void getFile() throws FileNotFoundException { 

        RemoveComments removeComments = new RemoveComments();

        String string = new String"// а вот // \"стро // ковые\" // литералы // не // трогает /"); 

        assertNotNull(removeComments.fromFile(new File(System.getProperty("user.dir")+File.separator+"TestJavaFile.java")));

    }
}
