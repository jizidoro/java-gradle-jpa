package com.comrades.app.core.alticci.usecases;

import com.comrades.app.core.alticci.actions.AlticciCalculator;
import com.comrades.app.core.bases.UseCase;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UcAlticciCalculateValue extends UseCase<Long> {

    private Long initialValue;

    public UcAlticciCalculateValue(Long inputValue) {
        super();
        initialValue = inputValue;
    }
    
    @Override
    protected Long execute() {
        //aqui vai ser o cache
        return AlticciCalculator.execute(initialValue);
    }


}
