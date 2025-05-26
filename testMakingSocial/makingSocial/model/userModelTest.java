package makingSocial.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userModelTest {
    private userModel user;

    @BeforeEach
    void setUp() {
        /*
         * Propósito: preparar un objeto "usuario completo" antes de cada test.
         * Qué hace: invoca el constructor de 7 parámetros (el más completo), asignando valores concretos a todos los atributos.
         * Así cada prueba parte de un estado conocido, sin repetir código.
         */
        user = new userModel(
                1,
                "juan123",
                "pass123",
                "pass123",
                "juan@example.com",
                25,
                "Juan Pérez"
        );
    }

    @Test
        /*
         * Propósito: verificar que el constructor al completo asigna correctamente todos los campos,
         * y que los getters devuelven esos valores.
         * Qué hace: llama a cada user.getXxx() o isXxx() y comprueba
         * (con assertEquals) que devuelven exactamente los datos con los que inicializamos en setUp().
         */
    void constructorCompleto_yGetters() {
        assertEquals(1, user.getID_User());
        assertEquals("juan123", user.getNickName());
        assertEquals("pass123", user.getPassword());
        assertEquals("pass123", user.getPassWordConfirm());
        assertEquals("juan@example.com", user.getE_Mail());
        assertEquals(25, user.getAge());
        assertEquals("Juan Pérez", user.getName());
    }

    @Test
        /*
         * Propósito: probar el constructor sin ID_User (para crear nuevo usuario).
         * Qué hace: usa el constructor de 6 parámetros (sin ID_User),
         * verifica que ID_User tiene valor por defecto 0 y el resto de atributos se asignan correctamente.
         */
    void constructorNuevoUsuario_yGetters() {
        userModel newUser = new userModel("ana99", "segura456", "segura456", "ana@email.com", 30, "Ana López");

        assertEquals(0, newUser.getID_User()); // ID no se pasa → debe ser 0
        assertEquals("ana99", newUser.getNickName());
        assertEquals("segura456", newUser.getPassword());
        assertEquals("segura456", newUser.getPassWordConfirm());
        assertEquals("ana@email.com", newUser.getE_Mail());
        assertEquals(30, newUser.getAge());
        assertEquals("Ana López", newUser.getName());
    }

    @Test
        /*
         * Propósito: probar el constructor que recibe solo ID_User, Age y Name (login con datos básicos).
         * Qué hace: crea un userModel e usando ese constructor, luego:
         * - Verifica que getID_User(), getAge() y getName() tienen los valores correctos.
         * - Confirma que otros campos son null o 0.
         */
    void constructorLoginConIDAgeName_yGetters() {
        userModel login = new userModel(2, 40, "Carlos Ruiz");

        assertEquals(2, login.getID_User());
        assertEquals(40, login.getAge());
        assertEquals("Carlos Ruiz", login.getName());

        assertNull(login.getNickName());
        assertNull(login.getPassword());
        assertNull(login.getPassWordConfirm());
        assertNull(login.getE_Mail());
    }

    @Test
        /*
         * Propósito: probar el constructor que recibe solo NickName y Password (login mínimo).
         * Qué hace: crea un userModel e con ese constructor, luego:
         * - Verifica getNickName() y getPassword() tengan los valores pasados.
         * - Confirma que otros campos sean null o 0.
         */
    void constructorLoginConNickPassword_yGetters() {
        userModel login = new userModel("admin", "1234");

        assertEquals("admin", login.getNickName());
        assertEquals("1234", login.getPassword());

        assertEquals(0, login.getID_User());
        assertNull(login.getPassWordConfirm());
        assertNull(login.getE_Mail());
        assertEquals(0, login.getAge());
        assertNull(login.getName());
    }

    @Test
        /*
         * Propósito: probar el constructor que solo recibe ID_User.
         * Qué hace: crea un userModel solo con ID_User y confirma que:
         * - getID_User() devuelve el valor esperado.
         * - Otros atributos están vacíos o en valores por defecto.
         */
    void constructorSoloIDUser_yGetters() {
        userModel byID = new userModel(99);

        assertEquals(99, byID.getID_User());

        assertNull(byID.getNickName());
        assertNull(byID.getPassword());
        assertNull(byID.getPassWordConfirm());
        assertNull(byID.getE_Mail());
        assertEquals(0, byID.getAge());
        assertNull(byID.getName());
    }

    @Test
        /*
         * Propósito: asegurar que cada setter modifica correctamente el estado interno y
         * que el correspondiente getter refleja ese cambio.
         * Qué hace: sobre el user de setUp() llama a cada setXxx(nuevoValor), y a continuación
         * comprueba getXxx() o isXxx() devuelve ese nuevoValor. Así cubres la lógica de todos los setters/getters.
         */
    void settersYGetters() {
        userModel u = new userModel("test", "123");

        u.setID_User(5);
        u.setNickName("newNick");
        u.setPassword("newPass");
        u.setPassWordConfirm("newPass");
        u.setE_Mail("new@email.com");
        u.setAge(22);
        u.setName("Nuevo Nombre");

        assertEquals(5, u.getID_User());
        assertEquals("newNick", u.getNickName());
        assertEquals("newPass", u.getPassword());
        assertEquals("newPass", u.getPassWordConfirm());
        assertEquals("new@email.com", u.getE_Mail());
        assertEquals(22, u.getAge());
        assertEquals("Nuevo Nombre", u.getName());
    }

    @Test
        /*
         * Propósito: comprobar que el toString() incluye toda la información relevante.
         * Qué hace: llama user.toString() y, usando assertTrue(s.contains("clave=valor")),
         * valida que aparecen en la salida los pares clave/valor como NickName, Name, Password, etc.
         */
    void toStringIncluyeCamposClave() {
        String s = user.toString();

        assertTrue(s.contains("NickName=juan123'"));
        assertTrue(s.contains("Name=Juan Pérez'"));
        assertTrue(s.contains("Password=pass123'"));
        assertTrue(s.contains("e_Mail=juan@example.com'"));
        assertTrue(s.contains("Age=25"));
    }
}