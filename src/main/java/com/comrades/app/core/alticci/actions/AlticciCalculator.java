package com.comrades.app.core.alticci.actions;

public class AlticciCalculator {

    private static Long calculateValue = 0l;

    public static Long execute(Long actualValue){
        // aqui vai a parte de usar o cache para melhorar o calculo
        if(actualValue == 0){
            return 0l;
        }
        else if(actualValue == 1){
            return 1l;
        }
        else if(actualValue == 2){
            return 1l;
        }
        else{
            calculateValue += execute(actualValue - 3) + execute(actualValue - 2);
            return calculateValue;
        }
    }
}
