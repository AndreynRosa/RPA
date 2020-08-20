package com.api.rpa.model.Enum;

public enum MessageErrorEnum {
        
    CNPJ_CANT_BE_NULL("CNPJ não pode ser nula"),
    CNPJ_ALREADY_EXISTIS("CNPJ já existe"),
    ACTIVE_CANT_BE_FALSE("It is not possible to edit INACTIVE . Make  it active again to edit"),
    RAZAO_SOCIAL_CANT_BE_NULL("RAZAO SOCIAL não pode nula"),
    UNOKW_ERROR("Error inesperado"),
    COMPANY_NOT_FOUND("Empresa não encontrada"),
    COMPANY_CANT_BE_THE_SAME("EMPRESAS não podem ser as mesmas "),
    VALUE_CANT_BE_INVALID("VALOR não podes nulo ou meno que 0 "),
    NUMBER_CANT_BE_NULL("NUMERO não poder ser nulo"),
    DATE_CANT_BE_NULL("Data não pode ser nula");

    MessageErrorEnum(String errorMensage) {
    
    }
}
