package com.comrades.app.core.alticci.usecases;

import com.comrades.app.core.bases.UseCase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UcAlticciCalculateValue extends UseCase<Integer> {

    private Integer alticci;

    public UcAlticciCalculateValue(Integer alticciInput) {
        super();
        alticci = alticciInput;
    }
    
    @Override
    protected Integer execute() {
        return alticci;
    }
}
