package makingSocial.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class guestModelTest {
    private guestModel guest;

    @BeforeEach
    void setUp() {
        /*
         * Propósito: preparar un objeto fullGuest "completo" antes de cada test.
         * Qué hace: invoca el constructor principal (de 10 parámetros) de guestModel, asignando valores concretos a todos los atributos.
         * Así cada prueba parte de un estado conocido, sin repetir código.
         */
        guest = new guestModel(
                100,                  // ID_User
                "juan",               // NickName
                "pass123",            // Password
                "pass123",            // PassWordConfirm
                "juan@email.com",     // E_Mail
                28,                   // Age
                "Juan Pérez",         // Name
                "Soltero",            // CivilStatus
                "@juan_rrss",         // RRSS
                "Soy amante de eventos sociales.", // BIO
                "Asistirá",           // Attendance
                501                   // ID_GuestModel
        );
    }

    @Test
        /*
         * Propósito: verificar que el constructor al completo asigna correctamente todos los campos,
         * y que los getters devuelven esos valores.
         * Qué hace: llama a cada guest.getXxx() o isXxx() y comprueba
         * (con assertEquals, assertTrue/assertFalse) que devuelven exactamente los datos con los que inicializamos en setUp().
         */
    void constructorCompleto_yGetters() {
        assertEquals(100, guest.getID_User());
        assertEquals("juan", guest.getNickName());
        assertEquals("pass123", guest.getPassword());
        assertEquals("pass123", guest.getPassWordConfirm());
        assertEquals("juan@email.com", guest.getE_Mail());
        assertEquals(28, guest.getAge());
        assertEquals("Juan Pérez", guest.getName());
        assertEquals("Soltero", guest.getCivilStatus());
        assertEquals("@juan_rrss", guest.getRRSS());
        assertEquals("Soy amante de eventos sociales.", guest.getBIO());
        assertEquals("Asistirá", guest.getAttendance());
        assertEquals(501, guest.getID_GuestModel());

        assertNull(guest.getPhoto()); // No se pasa foto en este constructor
    }

    @Test
        /*
         * Propósito: probar el constructor de 5 parámetros (ID_User, Age, Name, photo, datos adicionales).
         * Qué hace: usa el segundo constructor (con foto), luego verifica:
         * - getID_User(), getAge(), getName(), getPhoto()
         * - otros campos como CivilStatus, RRSS, etc., deben estar en null o valor por defecto.
         */
    void constructorConFoto_yGetters() {
        byte[] mockPhoto = "mockImageData".getBytes();
        guestModel g = new guestModel(
                200,                      // ID_User
                30,                       // Age
                "Ana López",              // Name
                mockPhoto,                // photo
                "Casada",                 // CivilStatus
                "@ana_rrss",              // RRSS
                "Me encanta socializar.", // BIO
                "No asistirá",            // Attendance
                502                       // ID_GuestModel
        );

        assertEquals(200, g.getID_User());
        assertEquals(30, g.getAge());
        assertEquals("Ana López", g.getName());
        assertNotNull(g.getPhoto());
        assertArrayEquals(mockPhoto, g.getPhoto());

        assertEquals("Casada", g.getCivilStatus());
        assertEquals("@ana_rrss", g.getRRSS());
        assertEquals("Me encanta socializar.", g.getBIO());
        assertEquals("No asistirá", g.getAttendance());
        assertEquals(502, g.getID_GuestModel());
    }

    @Test
        /*
         * Propósito: probar el constructor que recibe solo ID_User e ID_GuestModel.
         * Qué hace: crea un guestModel usando ese constructor, y confirma que:
         * - getID_User() y getID_GuestModel() tengan los valores esperados.
         * - Otros campos sean null o estén en valor por defecto.
         */
    void constructorSoloIDs_yGetters() {
        guestModel g = new guestModel(999, 789);

        assertEquals(999, g.getID_User());
        assertEquals(789, g.getID_GuestModel());

        assertNull(g.getName());
        assertNull(g.getNickName());
        assertNull(g.getPassword());
        assertNull(g.getPassWordConfirm());
        assertNull(g.getE_Mail());
        assertEquals(0, g.getAge());
        assertNull(g.getCivilStatus());
        assertNull(g.getRRSS());
        assertNull(g.getBIO());
        assertNull(g.getAttendance());
        assertNull(g.getPhoto());
    }

    @Test
        /*
         * Propósito: asegurar que cada setter modifica correctamente el estado interno y
         * que el correspondiente getter refleja ese cambio.
         * Qué hace: sobre el fullGuest de setUp() llama a cada setXxx(nuevoValor), y a continuación
         * comprueba getXxx() devuelve ese nuevoValor. Cubre todos los setters.
         */
    void settersYGetters() {
        guest.setCivilStatus("Divorciado");
        guest.setRRSS("@nuevorrss");
        guest.setBIO("Nueva descripción personal.");
        guest.setAttendance("Tal vez");
        guest.setID_GuestModel(600);
        guest.setPhoto("newImageBytes".getBytes());

        assertEquals("Divorciado", guest.getCivilStatus());
        assertEquals("@nuevorrss", guest.getRRSS());
        assertEquals("Nueva descripción personal.", guest.getBIO());
        assertEquals("Tal vez", guest.getAttendance());
        assertEquals(600, guest.getID_GuestModel());
        assertNotNull(guest.getPhoto());
        assertTrue(Arrays.equals("newImageBytes".getBytes(), guest.getPhoto()));
    }

    @Test
        /*
         * Propósito: comprobar que el toString() incluye toda la información relevante.
         * Qué hace: llama guest.toString() y, usando assertTrue(s.contains("clave=valor")),
         * valida que aparecen en la salida los pares clave/valor como CivilStatus='Soltero', etc.
         */
    void toStringIncluyeCamposClave() {
        String s = guest.toString();

        assertTrue(s.contains("CivilStatus=Soltero'"));
        assertTrue(s.contains("RRSS=@juan_rrss'"));
        assertTrue(s.contains("BIO=Soy amante de eventos sociales.'"));
        assertTrue(s.contains("Attendance=Asistirá'"));
        assertTrue(s.contains("ID_GuestModel=501"));
    }
}