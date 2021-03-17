package ch.heigvd.diary;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

public class DayTest {
    @Test
    void MakeValidAppointment() {

        Day day = new Day(23);
        Appointment appointment9 = new Appointment("Rdv 9h00", 1);
        Appointment appointment13 = new Appointment("Rdv 13h00", 1);
        Appointment appointment17 = new Appointment("Rdv 17h00", 1);


        boolean validateTest1 = day.makeAppointment(9, appointment9);
        boolean validateTest2 = day.makeAppointment(13, appointment13);
        boolean validateTest3 = day.makeAppointment(17, appointment17);

        assertTrue(validateTest1 && validateTest2 && validateTest3);
    }

    @Test
    void MakeInvalidAppointment() {
        Day day = new Day(23);

        Appointment appointment8 = new Appointment("Rdv 8h00", 1);
        Appointment appointment18 = new Appointment("Rdv 18h00", 1);

        boolean validateTest4 = day.makeAppointment(8, appointment8);
        boolean validateTest5 = day.makeAppointment(18, appointment18);

        assertFalse(validateTest4 || validateTest5);
    }

    @Test
    void FindValidSpace() {
        Day day = new Day(23);

        Appointment appointment9 = new Appointment("Rdv 9h00", 1);
        try {
            int timeValidSpace = day.findSpace(appointment9);
        }
        catch (NoSpaceException e){
            assertFalse(true);
        }
    }

    @Test
    void FindValidSpaceError() {
        Day day = new Day(23);

        Appointment appointment9 = new Appointment("Rdv 9h00", 9);

        boolean validateTest4 = day.makeAppointment(9, appointment9);
        assertTrue(validateTest4);

        Appointment appointment10 = new Appointment("Rdv 10h00", 1);

        assertThrows(NoSpaceException.class, () -> day.findSpace(appointment10));
    }

    @Test
    void DairyFailureTest(){
        Day day = new Day(23);
        Appointment appointment9 = new Appointment("Rdv 9h00", 2);
        int validatedTime = 0;

        do{
            try{
                validatedTime = day.findSpace(appointment9);
                day.makeAppointment(validatedTime, appointment9);
                day.showAppointments();
            }catch(NoSpaceException e){
                assertTrue(false);
            }catch (ArrayIndexOutOfBoundsException e){
                assertTrue(false);
                validatedTime = -1;
                System.out.println(e);
            }
        }while (validatedTime != -1);
    }

    @Test
    void BadBehaviorTest() {
        Day day = new Day(23);
        Appointment appointment9 = new Appointment("Rdv 9h00", 2);

        day.makeAppointment(17, appointment9);
    }
}
