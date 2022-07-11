package com.comrades.app.application.services.alticci.queries;

import com.comrades.app.application.responses.SingleResultDto;
import com.comrades.app.application.services.alticci.IAlticciQuery;
import com.comrades.app.application.services.alticci.dtos.AlticciDto;
import com.comrades.app.core.alticci.usecases.UcAlticciCreate;
import com.comrades.app.core.bases.UseCaseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlticciQuery implements IAlticciQuery {

    private final UseCaseFacade facade;

    public SingleResultDto<AlticciDto> findById(Integer inputValue) {

        var uc = new UcAlticciCreate(inputValue);
        var teste = facade.execute(uc);
        return new SingleResultDto<>(teste);
    }
}
