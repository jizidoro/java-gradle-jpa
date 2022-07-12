package com.comrades.app.application.services.alticci;

import com.comrades.app.application.responses.SingleResultDto;
import com.comrades.app.application.services.alticci.dtos.AlticciDto;

public interface IAlticciQuery {
    SingleResultDto<AlticciDto> findById(Long value);
}
