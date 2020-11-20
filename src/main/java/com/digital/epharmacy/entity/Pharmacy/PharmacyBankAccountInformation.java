package com.digital.epharmacy.entity.Pharmacy;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
;

/*
 * Author: Opatile Kelobang
 * Desc: PharmacyBankAccountInformation store pharmacy id using composition, bank name, account number, branch code and beneficiary reference
 * Date: 04 July 2020
 */
@Entity
@Table(name = "bank_details")
public class PharmacyBankAccountInformation {
    @Id
    @Column(name = "id")
    private String bank_account_id;
    @NotNull(message = "Bank name is required")
    private String bank_name;
    @NotNull(message = "Account number is required")
    @Range(min = 1, max = 2147483647, message = "Account number is required")
    private int account_number;
    @NotNull(message = "Branch code is required")
    @Range(min = 1, max = 2147483647, message = "Branch code is required")
    private int branch_code;
    @NotNull(message = "Beneficiary Reference is required")
    private String beneficiary_reference;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    protected PharmacyBankAccountInformation(){

    }

    // builder pattern method constructor
    private PharmacyBankAccountInformation(Builder builder)
    {
        this.bank_account_id = builder.bank_account_id;
        this.bank_name = builder.bank_name;
        this.account_number = builder.account_number;
        this.branch_code = builder.branch_code;
        this.beneficiary_reference = builder.beneficiary_reference;
        this.pharmacy = builder.pharmacy;

    }

    // getters for all attributes of entity PharmacyBankAccountInformation


    public String getBank_account_id() {
        return bank_account_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public int getAccount_number() {
        return account_number;
    }

    public int getBranch_code() {
        return branch_code;
    }

    public String getBeneficiary_reference() {
        return beneficiary_reference;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    @Override
    public String toString() {
        return "PharmacyBankAccountInformation{" +
                "bank_account_id='" + bank_account_id + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", account_number=" + account_number +
                ", branch_code=" + branch_code +
                ", beneficiary_reference='" + beneficiary_reference + '\'' +
                ", pharmacy=" + pharmacy +
                '}';
    }

    // add setters using building pattern
    public static class Builder
    {
        private String bank_account_id;
        private String bank_name;
        private int account_number;
        private int branch_code;
        private String beneficiary_reference;
        private Pharmacy pharmacy;

        public Builder setBank_account_id(String bank_account_id) {
            this.bank_account_id = bank_account_id;
            return this;
        }

        public Builder setBank_name(String bank_name) {
            this.bank_name = bank_name;
            return this;
        }

        public Builder setAccount_number(int account_number) {
            this.account_number = account_number;
            return this;
        }

        public Builder setBranch_code(int branch_code) {
            this.branch_code = branch_code;
            return this;
        }

        public Builder setBeneficiary_reference(String beneficiary_reference) {
            this.beneficiary_reference = beneficiary_reference;
            return this;
        }

        public Builder setPharmacy(Pharmacy pharmacy) {
            this.pharmacy = pharmacy;
            return this;
        }

        // Copy method for PharmacyBankAccountInformation entity
        public Builder copy (PharmacyBankAccountInformation pharmacyBankAccountInformation)
        {
            this.bank_account_id = pharmacyBankAccountInformation.bank_account_id;
            this.bank_name = pharmacyBankAccountInformation.bank_name;
            this.account_number = pharmacyBankAccountInformation.account_number;
            this.branch_code = pharmacyBankAccountInformation.branch_code;
            this.beneficiary_reference = pharmacyBankAccountInformation.beneficiary_reference;
            this.pharmacy = pharmacyBankAccountInformation.pharmacy;
            return this;
        }
        // Instance for Builder Pattern
        public PharmacyBankAccountInformation build()
        {
            return new PharmacyBankAccountInformation(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PharmacyBankAccountInformation that = (PharmacyBankAccountInformation) o;
        return account_number == that.account_number &&
                branch_code == that.branch_code &&
                bank_account_id.equals(that.bank_account_id) &&
                bank_name.equals(that.bank_name) &&
                Objects.equals(beneficiary_reference, that.beneficiary_reference) &&
                Objects.equals(pharmacy, that.pharmacy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bank_account_id, bank_name, account_number, branch_code, beneficiary_reference, pharmacy);
    }
}


