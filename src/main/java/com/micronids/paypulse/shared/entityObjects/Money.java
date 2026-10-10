package com.micronids.paypulse.shared.entityObjects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Money {
    private int amountUnits;
    private String currencyCode;

    private Money(int amountUnits,String currencyCode){
        this.amountUnits = amountUnits;
        this.currencyCode = currencyCode;
    }

    private Money inr(int amountUnits){
        return new Money(amountUnits,"INR");
    }

    public Money of(int amountUnits, String currencyCode){
        return new Money(amountUnits,currencyCode);
    }

    public Money add(Money other){
        if(!this.currencyCode.equals(other.currencyCode)){
            throw new IllegalArgumentException("Cannot add money with different currency code");
        }
        return new Money(this.amountUnits + other.amountUnits,this.currencyCode);
    }
}
