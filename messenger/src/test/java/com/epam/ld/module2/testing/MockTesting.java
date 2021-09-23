package com.epam.ld.module2.testing;

import com.epam.ld.module2.testing.template.Asker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockTesting {

//    @Rule
//    public ExpectedException thrown = ExpectedException.none();
//    @Mock
//    Template mockedTemplate;


    @Test
    @DisplayName("Mock reading from console")
    public void useMockImplementation() {
        Asker asker = mock(Asker.class);
        //when(asker.ask(anyString())).thenReturn("10file.txt").thenReturn("1file.txt");
         when(asker.ask(anyString())).thenReturn("1file.txt");
        String expected = "1file.txt";
        assertEquals(expected, asker.ask("Choose name of the file:\"+\"\\n\"+\"1file\"+\"\\n\"+\"2file\"+\"\\n\"+\"3file\""));
    }

    @Test
    @DisplayName("Mock Spy")
    public void useSpyMock() {

        Asker asker = spy(Asker.class);
        doReturn("1file.txt").when(asker).ask("Write your address");
        assertEquals("1file.txt", asker.ask("Write your address"));

    }


}
