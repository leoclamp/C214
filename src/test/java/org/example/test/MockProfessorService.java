package org.example.test;

import org.example.ProfessorService;
import java.util.ArrayList;

public class MockProfessorService implements ProfessorService{

    @Override
    public String busca(int id) {

        if (id == 0){
            return ProfessorConst.CRIS;
        }else if (id == 1){
            return ProfessorConst.DANIELA;
        }else if (id == 2){
            return ProfessorConst.RENAN;
        }else if (id == 3){
            return ProfessorConst.LUIZ;
        }else if (id == 4){
            return ProfessorConst.YNOGUTI;
        }else if (id == 5){
            return ProfessorConst.VITORIA;
        }else if (id == 6){
            return ProfessorConst.SONED;
        }else if(id == 7){
            return ProfessorConst.RENZO;
        }else{
            return ProfessorConst.INEXISTENTE;
        }
    }

    @Override
    public boolean professorExistente(int id) {
        //Aceitando somente IDs 0 - 7
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        for (int i=0; i < list.size(); i++){
            if (list.get(i).equals(id) || list.get(i).equals(id)){
                return true;
            }else{
                return false;
            }
        }

        return false;
    }

}
