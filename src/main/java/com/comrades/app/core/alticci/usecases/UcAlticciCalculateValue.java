package com.comrades.app.core.alticci.usecases;

import com.comrades.app.core.bases.UseCase;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;


@Getter
@Setter
public class UcAlticciCalculateValue extends UseCase<BigInteger> {

    private Long initialValue;
    private BigInteger calculatedValue = new BigInteger("0");

    public UcAlticciCalculateValue(Long value) {
        super();
        initialValue = value;
    }
    
    @Override
    protected BigInteger execute() {
        //aqui vai ser o cache
        return alticciCalculator(initialValue);
    }

    private BigInteger alticciCalculator(Long actualValue){
        // aqui vai a parte de usar o cache para melhorar o calculo
        if(actualValue == 0){
            return new BigInteger("0");
        }
        else if(actualValue == 1){
            return new BigInteger("1");
        }
        else if(actualValue == 2){
            return new BigInteger("1");
        }
        else{
            calculatedValue = calculatedValue.add(alticciCalculator(actualValue - 3)).add(alticciCalculator(actualValue - 2));
            return calculatedValue;
        }
    }

}
