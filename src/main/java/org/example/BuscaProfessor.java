package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaProfessor {

        ProfessorService professorService;

        public BuscaProfessor(ProfessorService service){
            this.professorService = service;
        }

        public Professor buscaProfessor(int id){

            //ProfessorJson é uma string que retornou do serviço
            String professorJson = professorService.busca(id);

            //jsonObject é um objeto JSON feito a partir da string de retorno
            JsonObject jsonObject = JsonParser.parseString(professorJson).getAsJsonObject();

            // Obtém o nome do professor, horário de atendimento, período, sala e o predio
            String nomeDoProfessor = jsonObject.get("nomeDoProfessor").getAsString();
            String horarioDeAtendimento = jsonObject.get("horarioDeAtendimento").getAsString();
            String periodo = jsonObject.get("periodo").getAsString();
            int sala = jsonObject.get("sala").getAsInt();
            int predio = jsonObject.get("predio").getAsInt();

            // Retorna um novo objeto Professor com os valores obtidos
            return new Professor(nomeDoProfessor, horarioDeAtendimento, periodo, sala, predio);
        }

        public boolean verificaArrayListExistente(int id){
            boolean professorExistente = professorService.professorExistente(id);

            if (professorExistente){
                return true;
            }else{
                return false;
            }
        }

}

