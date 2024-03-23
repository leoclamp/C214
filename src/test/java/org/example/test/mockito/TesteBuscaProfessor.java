package org.example.test.mockito;

import org.example.BuscaProfessor;
import org.example.Professor;
import org.example.ProfessorService;
import org.example.test.ProfessorConst;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaProfessor {

        @Mock
        private ProfessorService service;
        private BuscaProfessor buscaProfessor;

        @Before
        public void setup(){
            buscaProfessor = new BuscaProfessor(service);
        }

        @Test
        public void testeBuscaProfessorCris(){
            Mockito.when(service.busca(0)).thenReturn(ProfessorConst.CRIS);

            Professor cris = buscaProfessor.buscaProfessor(0);
            //Faz assertion
            assertEquals("Cris", cris.getNomeDoProfessor());
            assertEquals("15:30", cris.getHorarioDeAtendimento());
            assertEquals("Integral", cris.getPeriodo());
            assertEquals(2, cris.getSala());
            assertEquals(1, cris.getPredio());

        }

        @Test
        public void testeBuscaProfessorInvalido(){
            Mockito.when(service.busca(56)).thenReturn(ProfessorConst.INEXISTENTE);

            Professor inexistente = buscaProfessor.buscaProfessor(56);
            //Faz assertion
            assertEquals("INEXISTENTE", inexistente.getNomeDoProfessor());
            assertEquals("INEXISTENTE", inexistente.getHorarioDeAtendimento());
            assertEquals("INEXISTENTE", inexistente.getPeriodo());
            assertEquals(0, inexistente.getSala());
            assertEquals(0, inexistente.getPredio());

        }

        @Test
        public void testeBuscaProfessorValido(){

            Mockito.when(service.professorExistente(0)).thenReturn(true);
            //Faz a busca de um professor válido
            boolean professorValido = service.professorExistente(0);

            assertTrue(professorValido);
        }

}

