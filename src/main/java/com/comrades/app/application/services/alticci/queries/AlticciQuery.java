package com.comrades.app.application.services.alticci.queries;

import com.comrades.app.application.responses.SingleResultDto;
import com.comrades.app.application.services.alticci.IAlticciQuery;
import com.comrades.app.application.services.alticci.dtos.AlticciDto;
import com.comrades.app.core.alticci.usecases.UcAlticciCalculateValue;
import com.comrades.app.core.bases.UseCaseFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlticciQuery implements IAlticciQuery {

    private final UseCaseFacade facade;

    public SingleResultDto<AlticciDto> findById(Long inputValue) {

        var uc = new UcAlticciCalculateValue(inputValue);
        var response = facade.execute(uc);
        return new SingleResultDto<>(response);
    }
}
