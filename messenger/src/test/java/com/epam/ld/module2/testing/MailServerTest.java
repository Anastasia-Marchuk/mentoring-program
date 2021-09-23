package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.SOLARIS;

@ExtendWith(ResultFileAfterTesting.class)
public class MailServerTest {

    MailServer mailServer=new MailServer();
    TemplateEngine templateEngine=new TemplateEngine();

    Messenger messenger=new Messenger(mailServer,templateEngine);

    File file = new File(
            Template.class.getClassLoader().getResource("1file.txt").getFile()
    );


    @BeforeAll
    public static void init() throws IOException {
        System.out.println("LET'S START...");
        Files.deleteIfExists(Paths.get("/home/anastasia/EpamMentoringProgram/messenger/src/test/resources/test_result.txt"));
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("THE END!!!");
    }

    @BeforeEach
    public void prepareBefore() {
        System.out.println("START OUR TEST");
    }

    @AfterEach
    public void prepareAfter() {
        System.out.println("FINISHED ONE MORE TEST. LET'S GO TO ANOTHER ONE....\n");
    }


    @ParameterizedTest
    @DisplayName("This is Parametrized test")
    @ValueSource(strings = {"Minsk", "Brest", "Vitebsk"})
    void testWithParametrizes(String address) throws IOException {
        Client client=new Client();
        client.setAddresses(address);

        File file = new File(
                Template.class.getClassLoader().getResource("1file.txt").getFile()
        );

        Template template=new Template(file);
        messenger.sendMessage(client,template);

    }

    @Test
    @DisplayName("This is Dinamic test")
    @TestFactory
    Stream<DynamicTest> testDinamics() throws IOException {
        List<String> input1List = Arrays.asList("Minsk","Brest","Vitebsk");
        List<String> input2List = Arrays.asList("1file.txt","2file.txt","3file.txt");
        List<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i=0; i < input1List.size(); i++) {
            File file = new File(
                    Template.class.getClassLoader().getResource(input2List.get(i)).getFile()
            );
            Template template=new Template(file);
            Client client=new Client();
            client.setAddresses(input1List.get(i));


            DynamicTest dynamicTest = dynamicTest("Dynamic Test for temlate", () ->{messenger.sendMessage(client,template);});
            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }


    @Test
    @DisplayName("This is TemporaryFolder rule")
    void givenTestMethodWithTempDirectory(@TempDir Path tempDir)
            throws IOException {
        Path path = tempDir.resolve("numbers.txt");

        List<String> lines = Arrays.asList("message from 1 file", "!!!", "!");
        Files.write(path, lines);

        assertAll(
                () -> assertTrue(Files.exists(path), "File should exist"),
                () -> assertLinesMatch(lines, Files.readAllLines(path)));
    }


    //The system replaces variable placeholders like #{subject} from a template with values provided at runtime.
    @Tag("UnitTest")
   @Test()
    public final void testSendMessage() throws IOException {
       Client client=new Client();
       client.setAddresses("Brest, Moskovskaja 330");
       Template template=new Template(file);
       messenger.sendMessage(client,template);
    }


    @Test
    @DisplayName("This is Disabling test")
    @EnabledOnOs({ LINUX, SOLARIS }) // disabled on all but Linux, Solaris
    @DisabledOnJre(JRE.JAVA_8)           // disabled on Java 8
    void test() throws IOException {
       Client client=new Client();
       client.setAddresses("Minsk, prospect Nezavisimosti 5");
       Template template=new Template(file);
       messenger.sendMessage(client,template);
}

//    @Test
//    @DisplayName("This is ExcpectedException")
//    public void throwsExceptionWhenNullIsGiven() {
//
//        thrown.expect(NullPointerException.class);
//        thrown.expectMessage(equalTo("NULL IS NOT ALLOWED"));
//        // act
//        Messenger messenger=new Messenger(mailServer,templateEngine);
//        messenger.sendMessage(null,null);
//    }


    @Test
    @DisplayName("This is Exception with Assertation")
    void testMailServerThrowsException() {

        TemplateEngine engine = new TemplateEngine();
        Assertions.assertThrows(NullPointerException.class, () -> {
            engine.generateMessage(null, null);
        });
    }

    @Test()
    @DisplayName("This is Exception with Assertation2")
    public void testMailServerThrowsException2() {
        boolean thrown = false;
        TemplateEngine engine=new TemplateEngine();
        try {
            engine.generateMessage(null,null);
        } catch (NullPointerException e) { }
        assertTrue(!thrown);

    }

}
