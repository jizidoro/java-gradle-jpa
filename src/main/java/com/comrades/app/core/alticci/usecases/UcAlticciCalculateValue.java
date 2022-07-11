package com.comrades.app.core.alticci.usecases;

import com.comrades.app.core.bases.UseCase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UcAlticciCalculateValue extends UseCase<Integer> {

    private Integer initialValue;
    private Integer calculateValue = 0;

    public UcAlticciCalculateValue(Integer inputValue) {
        super();
        initialValue = inputValue;
    }
    
    @Override
    protected Integer execute() {
        //aqui vai ser o cache
        return teste(initialValue);
    }

    private Integer teste(Integer actualValue){
        if(actualValue == 0){
            return 0;
        }
        else if(actualValue == 1){
            return 1;
        }
        else if(actualValue == 2){
            return 1;
        }
        else{
            calculateValue += teste(actualValue - 3) + teste(actualValue - 2);
            return calculateValue;
        }
    }
}
