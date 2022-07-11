package com.comrades.app.core.alticci.usecases;

import com.comrades.app.core.bases.UseCase;
import com.comrades.app.domain.models.Alticci;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Date;


@Getter
@Setter
public class UcAlticciCreate extends UseCase<Integer> {

    private Alticci alticci;

    public UcAlticciCreate(Alticci alticciInput) {
        super();
        alticci = alticciInput;
    }
    
    @Override
    protected Integer execute() throws Exception {
        var date =Date.from(Instant.now());
        alticci.setRegisterDate(date);
        return 0;
    }
}
