package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Template;
import com.epam.ld.module2.testing.template.TemplateEngine;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.SOLARIS;



public class FilteringTest {

    MailServer mailServer=new MailServer();
    TemplateEngine templateEngine=new TemplateEngine();
    Messenger messenger=new Messenger(mailServer,templateEngine);
    File file = new File(
            Template.class.getClassLoader().getResource("1file.txt").getFile()
    );

    @Order(2)
    @Test
    @DisplayName("This is first test but with ORDER 2")
    @EnabledOnOs({ LINUX, SOLARIS }) // disabled on all but Linux, Solaris
    @DisabledOnJre(JRE.JAVA_8)           // disabled on Java 8
    void test() throws IOException {
        Client client = new Client();
        client.setAddresses("Minsk, prospect Nezavisimosti 5");
        Template template = new Template(file);
        messenger.sendMessage(client, template);
    }

    @Order(3)
    @Test
    @DisplayName("This is second test but with ORDER 3")
    void givenTestMethodWithTempDirectory(@TempDir Path tempDir)
            throws IOException {
        Path path = tempDir.resolve("numbers.txt");

        List<String> lines = Arrays.asList("message from 1 file", "!!!", "!");
        Files.write(path, lines);

        assertAll(
                () -> assertTrue(Files.exists(path), "File should exist"),
                () -> assertLinesMatch(lines, Files.readAllLines(path)));
    }


    @Test
    @Order(1)
    @DisplayName("This is third test but with ORDER 1")
    public final void testSendMessage() throws IOException {
        Client client=new Client();
        client.setAddresses("Brest, Moskovskaja 330");

        Template template=new Template(file);
        messenger.sendMessage(client,template);
    }

}




