package com.comrades.app.core.log;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UseCaseLogContext implements Serializable {
	
	private static final long serialVersionUID = 1L;

    private OperacaoLogEnum operacao;
    private FuncionalidadeLogEnum funcionalidadeLogEnum;

    public OperacaoLogEnum getOperacao() {
        return operacao;
    }

    public void setOperacao(OperacaoLogEnum operacao) {
        this.operacao = operacao;
    }

    public FuncionalidadeLogEnum getFuncionalidadeLogEnum() {
        return funcionalidadeLogEnum;
    }

    public void setFuncionalidadeLogEnum(FuncionalidadeLogEnum funcionalidadeLogEnum) {
        this.funcionalidadeLogEnum = funcionalidadeLogEnum;
    }
}
