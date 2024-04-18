package com.personal.expenses.domain.enu;

public enum TypeTitle {
    Receivable("Receivable"),
    Payable("Payable");

    private String valor;

    private TypeTitle(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return this.valor;
    }
}
