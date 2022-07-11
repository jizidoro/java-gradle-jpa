package com.comrades.app.core.alticci.usecases;

import com.comrades.app.core.bases.UseCase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UcAlticciCreate extends UseCase<Integer> {

    private Integer alticci;

    public UcAlticciCreate(Integer alticciInput) {
        super();
        alticci = alticciInput;
    }
    
    @Override
    protected Integer execute() throws Exception {
        return alticci;
    }
}
