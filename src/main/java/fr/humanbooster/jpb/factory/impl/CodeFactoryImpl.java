package fr.humanbooster.jpb.factory.impl;

import fr.humanbooster.jpb.business.Code;
import fr.humanbooster.jpb.factory.CodeFactory;

public class CodeFactoryImpl implements CodeFactory {

    private static CodeFactory codeFactory;

    private int compteur = 0;

    //Constructeur privé
    private CodeFactoryImpl(){}

    public static CodeFactory getInstance(){
        if(codeFactory == null){
            synchronized(CodeFactoryImpl.class){
                if(codeFactory == null){
                    codeFactory = new CodeFactoryImpl();
                }
            }
        }
        return codeFactory;
    }
    @Override
    public Code fabriquerCode() {
        StringBuilder numero = new StringBuilder("STAGE");
        compteur++;
        if(compteur < 10){
            numero.append("0");
        }
        numero.append(compteur);
        return new Code(numero.toString());
    }
}
