package makingSocial.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class sessionTest {

    private userModel testUser;
    private eventModel testEvent;
    private guestModel testGuest;

    @BeforeEach
    void setUp() {
        /*
         * Propósito: preparar objetos de prueba antes de cada método de test.
         * Qué hace: crea un userModel, eventModel y guestModel básicos para usarlos durante las pruebas.
         */
        testUser = new userModel("testUser", "pass123");
        testEvent = new eventModel(1, LocalDate.of(2025, 5, 26), LocalTime.of(18, 30),
                "Madrid", 28001, false, true, "Desc1", "Desc2", 21, false, 99);
        testGuest = new guestModel(1, "guestUser", "pass456", "pass456",
                "guest@email.com", 30, "Guest Name", "Soltero", "@guest_rrss",
                "Bio...", "Asistirá", 501);
    }

    @AfterEach
    void tearDown() {
        /*
         * Propósito: limpiar el estado estático después de cada prueba.
         * Qué hace: reinicia todos los campos estáticos de la clase session,
         * para evitar interferencia entre tests.
         */
        session.setCurrentUser((userModel) null);
        session.setcurrentEvent(null);
        session.setCurrentGuest(null);
    }

    @Test
        /*
         * Propósito: asegurar que setCurrentUser(userModel) y getCurrentUser()
         * funcionan correctamente.
         * Qué hace: establece un userModel como currentUser y luego lo recupera,
         * comprobando que devuelve exactamente el mismo objeto.
         */
    void setCurrentUser_y_getCurrentUser_retornaMismoUsuario() {
        session.setCurrentUser(testUser);
        userModel result = session.getCurrentUser();
        assertNotNull(result);
        assertSame(testUser, result); // Comprueba identidad (mismo objeto)
    }

    @Test
        /*
         * Propósito: asegurar que setCurrentUser(eventModel) y getcurrentEvent()
         * funcionan correctamente.
         * Qué hace: llama setCurrentUser(event) y luego verifica getcurrentEvent()
         * devuelve exactamente el mismo objeto.
         */
    void setCurrentUser_conEvento_y_getCurrentEvent_retornaMismoEvento() {
        session.setCurrentUser(testEvent);
        eventModel result = session.getcurrentEvent();
        assertNotNull(result);
        assertSame(testEvent, result);
    }

    @Test
        /*
         * Propósito: probar que setcurrentEvent(event) y getcurrentEvent()
         * funcionan correctamente.
         * Qué hace: establece un evento con setcurrentEvent(), luego lo recupera y
         * comprueba que devuelve el mismo objeto.
         */
    void setcurrentEvent_y_getcurrentEvent_retornaMismoEvento() {
        session.setcurrentEvent(testEvent);
        eventModel result = session.getcurrentEvent();
        assertNotNull(result);
        assertSame(testEvent, result);
    }

    @Test
        /*
         * Propósito: asegurar que setCurrentGuest(guest) y getCurrentGuest()
         * funcionan correctamente.
         * Qué hace: establece un guestModel como currentGuest y luego lo recupera,
         * comprobando que devuelve exactamente el mismo objeto.
         */
    void setCurrentGuest_y_getCurrentGuest_retornaMismoInvitado() {
        session.setCurrentGuest(testGuest);
        guestModel result = session.getCurrentGuest();
        assertNotNull(result);
        assertSame(testGuest, result);
    }

    @Test
        /*
         * Propósito: verificar que los distintos campos no interfieren entre sí.
         * Qué hace: establece currentUser, currentEvent y currentGuest con distintos valores,
         * y luego verifica que cada getter devuelve su valor correspondiente sin alteraciones.
         */
    void getters_devuelvenValoresIndependientes() {
        session.setCurrentUser(testUser);
        session.setcurrentEvent(testEvent);
        session.setCurrentGuest(testGuest);

        assertSame(testUser, session.getCurrentUser());
        assertSame(testEvent, session.getcurrentEvent());
        assertSame(testGuest, session.getCurrentGuest());
    }

    @Test
        /*
         * Propósito: asegurar que cuando no se ha asignado ningún valor, los getters devuelven null.
         * Qué hace: sin llamar a ningún setter, llama a getCurrentUser(), getcurrentEvent() y getCurrentGuest(),
         * y verifica que todos devuelven null.
         */
    void getters_devuelvenNull_siNoSeHaSeteado() {
        assertNull(session.getCurrentUser());
        assertNull(session.getcurrentEvent());
        assertNull(session.getCurrentGuest());
    }
}