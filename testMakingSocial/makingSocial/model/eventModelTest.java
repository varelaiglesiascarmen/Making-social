package makingSocial.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class eventModelTest {

    private eventModel event;

    @BeforeEach
    void setUp() {
    /*
    * Propósito: preparar un objeto fullEvent “completo” antes de cada test.
    * Qué hace: invoca el constructor de 12 parámetros de eventModel, asignando valores concretos a todos los atributos.
    * Así cada prueba parte de un objeto en el mismo estado conocido, y no tienes que repetir esta inicialización en cada @Test.
    * */

        eventModel event = new eventModel(
                1,
                LocalDate.of(2025, 5, 26),
                LocalTime.of(18, 30),
                "Madrid",
                28001,
                false,
                true,
                "Desc1",
                "Desc2",
                21,
                false,
                99
        );
    }

    @Test
    /*
    * Propósito: verificar que el constructor al completo asigna correctamente todos los campos,
    *  y que los getters devuelven esos valores.
    * Qué hace: llama a cada event.getXxx() o isXxx() y comprueba
    * (con assertEquals, assertTrue/assertFalse) que devuelven exactamente los datos con los que inicializamos en setUp().
    * */
    void constructorCompleto_yGetters() {
        assertEquals(1, event.getID_Event());
        assertEquals(LocalDate.of(2025, 5, 26), event.getDate());
        assertEquals(LocalTime.of(18, 30), event.getSchedule());
        assertEquals("Madrid", event.getLocation());
        assertEquals(28001, event.getPostalCode());
        assertFalse(event.isDressCode());
        assertTrue(event.isTheme());
        assertEquals("Desc1", event.getDescription1());
        assertEquals("Desc2", event.getDescription2());
        assertEquals(21, event.getAllowedAge());
        assertFalse(event.isAccess());
        assertEquals(99, event.getID_Host());
    }

    @Test
    /*
    * Propósito: probar el constructor de 10 parámetros (sin ID_Event ni ID_Host),
    * y asegurarse de que esos dos campos quedan en sus valores por defecto (0).
    *       - Qué hace: crea un eventModel e usando el constructor de 10 args, luego:
    *       - Comprueba e.getID_Event() y e.getID_Host() son 0.
    *       - Verifica que el resto de getters devuelve exactamente lo pasado.
    * */
    void constructorSinIDHost_yDefaults() {
        // Usa el constructor de 10 parámetros (no incluye ID_Host ni ID_Event)
        LocalDate date = LocalDate.of(2024, 1, 1);
        LocalTime time = LocalTime.of(12, 0);
        eventModel e = new eventModel(
                date, time, "BCN", 8002,
                true, false, "D1", "D2", 18, true
        );

        // ID_Event e ID_Host no se setean → quedan en 0
        assertEquals(0, e.getID_Event());
        assertEquals(0, e.getID_Host());

        assertEquals(date, e.getDate());
        assertEquals(time, e.getSchedule());
        assertEquals("BCN", e.getLocation());
        assertEquals(8002, e.getPostalCode());
        assertTrue(e.isDressCode());
        assertFalse(e.isTheme());
        assertEquals("D1", e.getDescription1());
        assertEquals("D2", e.getDescription2());
        assertEquals(18, e.getAllowedAge());
        assertTrue(e.isAccess());
    }

    @Test
    /*
    * Propósito: verificar el constructor que recibe sólo postalCode e ID_Event.
    *Qué hace: crea e = new eventModel(12345, 77), luego:
    *    Comprueba que e.getPostalCode() es 12345 y e.getID_Event() es 77.
    *    Se asegura de que todos los demás campos (fecha, hora, texto)
    *    quedan en null o en sus valores por defecto (booleanos true, enteros 0, ID_Host = 0).
    * */
    void constructorPostalCodeEIDEvent() {
        eventModel e = new eventModel(12345, 77);
        assertEquals(12345, e.getPostalCode());
        assertEquals(77, e.getID_Event());
        // resto de campos en default/null
        assertNull(e.getDate());
        assertNull(e.getSchedule());
        assertNull(e.getLocation());
        assertTrue(e.isDressCode());   // valores inicializados en la definición
        assertTrue(e.isTheme());
        assertNull(e.getDescription1());
        assertNull(e.getDescription2());
        assertEquals(0, e.getAllowedAge());
        assertTrue(e.isAccess());
        assertEquals(0, e.getID_Host());
    }

    @Test
    /*Propósito: probar el constructor que recibe sólo postalCode.
    * Qué hace: crea e = new eventModel(55555), luego:
    *    Verifica que getPostalCode() devuelve 55555.
    *    Comprueba que todos los demás campos (incluido ID_Event) están en 0 o null o,
    *    en el caso de los booleanos, en el valor inicial (true).
    */
    void constructorSoloPostalCode() {
        eventModel e = new eventModel(55555);
        assertEquals(55555, e.getPostalCode());
        // ID_Event a 0, resto igual que arriba
        assertEquals(0, e.getID_Event());
        assertNull(e.getDate());
        assertNull(e.getSchedule());
        assertNull(e.getLocation());
        assertTrue(e.isDressCode());
        assertTrue(e.isTheme());
        assertNull(e.getDescription1());
        assertNull(e.getDescription2());
        assertEquals(0, e.getAllowedAge());
        assertTrue(e.isAccess());
        assertEquals(0, e.getID_Host());
    }

    @Test
    /*Propósito: asegurar que cada setter modifica correctamente el estado interno y
    * que el correspondiente getter refleja ese cambio.
    * Qué hace: sobre el fullEvent de setUp() llama a cada setXxx(nuevoValor), y a continuación
    * comprueba getXxx() o isXxx() devuelve ese nuevoValor. Así cubres la lógica de todos los setters/getters.*/
    void settersYGetters() {
        // Ponemos valores distintos y comprobamos
        event.setID_Event(2);
        assertEquals(2, event.getID_Event());

        LocalDate newDate = LocalDate.of(2023, 12, 31);
        event.setDate(newDate);
        assertEquals(newDate, event.getDate());

        LocalTime newTime = LocalTime.of(9, 15);
        event.setSchedule(newTime);
        assertEquals(newTime, event.getSchedule());

        event.setLocation("Valencia");
        assertEquals("Valencia", event.getLocation());

        event.setPostalCode(46001);
        assertEquals(46001, event.getPostalCode());

        event.setDressCode(true);
        assertTrue(event.isDressCode());

        event.setTheme(false);
        assertFalse(event.isTheme());

        event.setDescription1("Otra1");
        assertEquals("Otra1", event.getDescription1());

        event.setDescription2("Otra2");
        assertEquals("Otra2", event.getDescription2());

        event.setAllowedAge(30);
        assertEquals(30, event.getAllowedAge());

        event.setAccess(true);
        assertTrue(event.isAccess());

        event.setID_Host(123);
        assertEquals(123, event.getID_Host());
    }

    @Test
    /*Propósito: comprobar que el toString() incluye toda la información relevante, sin necesidad de casar
    * exactamente toda la cadena (que podría romperse si el formato cambia levemente).
    * Qué hace: llama fullEvent.toString() y, usando una serie de assertTrue(s.contains("clave=valor")),
    * valida que aparecen en la salida todos los pares ID_Event=1, Date=2025-05-26, Schedule=18:30, etc., hasta ID_Host=99.*/
    void toStringIncluyeTodosLosCampos() {
        String s = event.toString();
        // Debe contener cada par clave=valor
        assertTrue(s.contains("ID_Event=1"));
        assertTrue(s.contains("Date=2025-05-26"));
        assertTrue(s.contains("Schedule=18:30"));
        assertTrue(s.contains("Location='Madrid'"));
        assertTrue(s.contains("PostalCode=28001"));
        assertTrue(s.contains("DressCode=false"));
        assertTrue(s.contains("Theme=true"));
        assertTrue(s.contains("Description1='Desc1'"));
        assertTrue(s.contains("Description2='Desc2'"));
        assertTrue(s.contains("AllowedAge=21"));
        assertTrue(s.contains("Access=false"));
        assertTrue(s.contains("ID_Host=99"));
    }
}