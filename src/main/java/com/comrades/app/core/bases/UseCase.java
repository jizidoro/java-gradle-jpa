/*
 * Este arquivo pertence a Petrobras e nao pode ser utilizado fora desta empresa
 * sem previa autorizacao.
 * ----------------------------------
 * Esta classe segue o padrao PE-2T0-00250
 */
package com.comrades.app.core.bases;



public abstract class UseCase<T> {

    protected abstract T execute() throws Exception;
}
