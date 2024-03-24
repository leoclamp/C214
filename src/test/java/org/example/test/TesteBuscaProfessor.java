package org.example.test;

import org.example.BuscaProfessor;
import org.example.Professor;
import org.example.ProfessorService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TesteBuscaProfessor {

    ProfessorService service;
    BuscaProfessor buscaProfessor;

    @Before
    public void setup(){
        //Criando o contexo do meu teste com o Mock (serviço mock)
        service = new MockProfessorService();
        buscaProfessor = new BuscaProfessor(service);
    }

    @Test
    public void testeBuscaProfessorCris(){

        //Fiz a busca
        Professor cris = buscaProfessor.buscaProfessor(0);

        //Faz assertion
        assertEquals("Cris", cris.getNomeDoProfessor());
        assertEquals("segunda-feira - 15:30", cris.getHorarioDeAtendimento());
        assertEquals("Integral", cris.getPeriodo());
        assertEquals(2, cris.getSala());
        assertEquals(1, cris.getPredio()[0]);

    }

    @Test
    public void testeBuscaProfessoraDaniela(){

        //Fiz a busca
        Professor dani = buscaProfessor.buscaProfessor(1);

        //Faz assertion
        assertEquals("Daniela", dani.getNomeDoProfessor());
        assertEquals("terça-feira - 17:30", dani.getHorarioDeAtendimento());
        assertEquals("Integral", dani.getPeriodo());
        assertEquals(8, dani.getSala());
        assertEquals(2, dani.getPredio()[0]);

    }

    @Test
    public void testeBuscaProfessorRenan(){

        //Fiz a busca
        Professor renan = buscaProfessor.buscaProfessor(2);

        //Faz assertion
        assertEquals("Renan", renan.getNomeDoProfessor());
        assertEquals("quarta-feira - 19:30", renan.getHorarioDeAtendimento());
        assertEquals("Noturno", renan.getPeriodo());
        assertEquals(12, renan.getSala());
        assertEquals(3, renan.getPredio()[0]);

    }

    @Test
    public void testeBuscaProfessorLuiz(){

        //Fiz a busca
        Professor luiz = buscaProfessor.buscaProfessor(3);

        //Faz assertion
        assertEquals("Luiz", luiz.getNomeDoProfessor());
        assertEquals("quinta-feira - 13:30", luiz.getHorarioDeAtendimento());
        assertEquals("Integral", luiz.getPeriodo());
        assertEquals(16, luiz.getSala());
        assertEquals(4, luiz.getPredio()[0]);

    }
    @Test
    public void testeBuscaProfessorYnoguti(){

        //Fiz a busca
        Professor ynoguti = buscaProfessor.buscaProfessor(4);

        //Faz assertion
        assertEquals("Ynoguti", ynoguti.getNomeDoProfessor());
        assertEquals("segunda-feira - 10:00", ynoguti.getHorarioDeAtendimento());
        assertEquals("Integral", ynoguti.getPeriodo());
        assertEquals(4, ynoguti.getSala());
        assertEquals(1, ynoguti.getPredio()[0]);

    }

    @Test
    public void testeBuscaProfessorVitoria(){

        //Fiz a busca
        Professor vitoria = buscaProfessor.buscaProfessor(5);

        //Faz assertion
        assertEquals("Vitoria", vitoria.getNomeDoProfessor());
        assertEquals("terça-feira - 21:30", vitoria.getHorarioDeAtendimento());
        assertEquals("Integral", vitoria.getPeriodo());
        assertEquals(10, vitoria.getSala());
        assertEquals(2, vitoria.getPredio()[0]);

    }

    @Test
    public void testeBuscaProfessorSoned(){

        //Fiz a busca
        Professor soned = buscaProfessor.buscaProfessor(6);

        //Faz assertion
        assertEquals("Soned", soned.getNomeDoProfessor());
        assertEquals("quarta-feira - 19:30", soned.getHorarioDeAtendimento());
        assertEquals("Noturno", soned.getPeriodo());
        assertEquals(14, soned.getSala());
        assertEquals(3, soned.getPredio()[0]);

    }

    @Test
    public void testeBuscaProfessorRenzo(){

        //Fiz a busca
        Professor renzo = buscaProfessor.buscaProfessor(7);

        //Faz assertion
        assertEquals("Renzo", renzo.getNomeDoProfessor());
        assertEquals("sexta-feira - 13:30", renzo.getHorarioDeAtendimento());
        assertEquals("Noturno", renzo.getPeriodo());
        assertEquals(22, renzo.getSala());
        assertEquals(6, renzo.getPredio()[0]);

    }

    @Test
    public void testeBuscaProfessorValido(){

        //Faz a busca de um professor válido (id = 0 ao 7 ou ID positivo)
        boolean professorValido = buscaProfessor.verificaArrayListExistente(0);

        assertTrue(professorValido);
    }

    @Test
    public void testeBuscaProfessorInvalido(){

        //Faz a busca de um inimigo inválido (id negativo)
        boolean professorInvalido = buscaProfessor.verificaArrayListExistente(-1);

        assertFalse(professorInvalido);
    }

}

