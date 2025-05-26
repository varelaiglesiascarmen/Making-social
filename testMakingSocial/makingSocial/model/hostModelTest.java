package makingSocial.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class hostModelTest {
    private hostModel host;

    @BeforeEach
    void setUp() {
        /*
         * Propósito: preparar un objeto fullHost “completo” antes de cada test.
         * Qué hace: invoca el constructor de hostModel con todos los parámetros,
         * incluyendo los heredados de userModel, asignando valores concretos a todos los atributos.
         * Así cada prueba parte de un estado conocido, sin repetir código.
         */
        host = new hostModel(
                100,           // ID_User
                "juan",        // NickName
                "pass123",     // Password
                "pass123",     // PassWordConfirm
                "juan@email.com", // E_Mail
                28,            // Age
                "Juan Pérez",  // Name
                1              // ID_Host
        );
    }

    @Test
        /*
         * Propósito: verificar que el constructor al completo asigna correctamente todos los campos,
         * incluidos los heredados de userModel, y que los getters devuelven esos valores.
         * Qué hace: llama a cada host.getXxx() o isXxx() y comprueba
         * (con assertEquals, assertTrue/assertFalse) que devuelven exactamente los datos con los que inicializamos en setUp().
         */
    void constructorCompleto_yGetters() {
        assertEquals(100, host.getID_User());
        assertEquals("juan", host.getNickName());
        assertEquals("pass123", host.getPassword());
        assertEquals("pass123", host.getPassWordConfirm());
        assertEquals("juan@email.com", host.getE_Mail());
        assertEquals(28, host.getAge());
        assertEquals("Juan Pérez", host.getName());
        assertEquals(1, host.getID_Host());
    }

    @Test
        /*
         * Propósito: probar el setter de ID_Host y asegurar que el getter refleja el cambio.
         * Qué hace: llama setID_Host(nuevoValor), luego verifica con getID_Host() que devuelve ese valor actualizado.
         */
    void settersYGetters_IDHost() {
        host.setID_Host(99);
        assertEquals(99, host.getID_Host());
    }

    @Test
        /*
         * Propósito: comprobar que el toString() incluye la información relevante de hostModel.
         * Qué hace: llama host.toString() y, usando una serie de assertTrue(s.contains("clave=valor")),
         */
    void toStringIncluyeTodosLosCampos() {
        String s = host.toString();

        assertTrue(s.contains("ID_Host=1'"));
        assertTrue(s.contains("ID_User=100"));
    }
}