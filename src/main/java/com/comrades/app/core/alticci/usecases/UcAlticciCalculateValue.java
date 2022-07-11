package com.comrades.app.core.alticci.usecases;

import com.comrades.app.core.bases.UseCase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UcAlticciCalculateValue extends UseCase<Integer> {

    private Integer alticciInput;

    public UcAlticciCalculateValue(Integer alticciInput) {
        super();
        alticciInput = alticciInput;
    }
    
    @Override
    protected Integer execute() {
        if(alticciInput == 0){
            return 0;
        }
        else if(alticciInput == 1){
            return 1;
        }
        else if(alticciInput == 2){
            return 1;
        }
        else{
            return teste(alticciInput);
        }
    }

    private Integer teste(Integer inputValue){
        var value = teste(inputValue - 3);
        var oto = teste(inputValue - 2);
        return value + oto;
    }
}
