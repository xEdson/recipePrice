package br.unicamp.ft.e196208_g173381.recipeprice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public enum UnidadeMedida {
    gr("gr"), ml("ml"), xicara("xicara"), kg("kg"), l("l"), un("un");

    private String unidade;

     UnidadeMedida(String unidade) {
        this.unidade=unidade;
    }

    public static List<String> getList(){
        List<String> values = new ArrayList<>();
        for (UnidadeMedida x : values()) {
            values.add(x.unidade);
        }
        return values;
    }
}
