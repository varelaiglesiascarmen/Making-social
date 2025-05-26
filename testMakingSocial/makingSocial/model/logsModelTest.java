package makingSocial.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class logsModelTest {
    private logsModel log;

    @BeforeEach
    void setUp() {
        /*
         * Propósito: preparar un objeto fullLog "completo" antes de cada test.
         * Qué hace: invoca el constructor principal (de 2 parámetros) de logsModel, asignando valores concretos a todos los atributos.
         * Así cada prueba parte de un estado conocido, sin repetir esta inicialización en cada @Test.
         */
        log = new logsModel(501, 1001);
    }

    @Test
        /*
         * Propósito: verificar que el constructor asigna correctamente ambos campos,
         * y que los getters devuelven esos valores.
         * Qué hace: llama a getID_GuestModel() y getID_Event(), y comprueba que devuelven exactamente los datos con los que inicializamos en setUp().
         */
    void constructorCompleto_yGetters() {
        assertEquals(501, log.getID_GuestModel());
        assertEquals(1001, log.getID_Event());
    }

    @Test
        /*
         * Propósito: probar el constructor con otros valores y asegurar que no hay efectos colaterales.
         * Qué hace: crea un nuevo logsModel con ID_GuestModel=999 y ID_Event=888, luego verifica que los getters devuelvan esos valores.
         */
    void constructorConValoresDiferentes_yGetters() {
        logsModel log2 = new logsModel(999, 888);

        assertEquals(999, log2.getID_GuestModel());
        assertEquals(888, log2.getID_Event());
    }

    @Test
        /*
         * Propósito: asegurar que los setters modifican correctamente el estado interno y
         * que los correspondientes getters reflejan ese cambio.
         * Qué hace: sobre el fullLog de setUp() llama a setID_GuestModel(nuevoValor) y setID_Event(nuevoValor), y a continuación
         * comprueba que getXxx() devuelve esos nuevos valores. Cubre la lógica de ambos setters/getters.
         */
    void settersYGetters() {
        log.setID_GuestModel(600);
        log.setID_Event(1100);

        assertEquals(600, log.getID_GuestModel());
        assertEquals(1100, log.getID_Event());
    }

    @Test
        /*
         * Propósito: comprobar que el toString() incluye toda la información relevante.
         * Qué hace: llama log.toString() y, usando assertTrue(s.contains("clave=valor")),
         * valida que aparecen en la salida los pares clave/valor como ID_GuestModel='501', ID_Event=1001.
         */
    void toStringIncluyeCamposClave() {
        String s = log.toString();

        assertTrue(s.contains("ID_GuestModel=501'"));
        assertTrue(s.contains("ID_Event=1001"));
    }
}