package com.digital.epharmacy.entity.Catalogue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/*
Author: Nelson Mpyana, 217029620
Date: 03/07/2019
Class Entity: PrescriptionItem (this class will store information about the the prescription )
Version: 1.0

 */
/**Author: Nicole Hawthorne
 *Desc: Added the entity mapping and assigned the primary key also added no null values each entity
 and changed default constructor to protected
 * Date: 25/10/2020
 * */
@Entity
@Table(name = "prescriptions")
public class PrescriptionItem {
    //declaring the Variables
    @Id
    @GeneratedValue
    @Column(name = "id")
    private String prescription_number;
    @NotNull(message = "Prescription type is required")
    private String prescription_type;
    @NotNull(message = "Prescribing doctor number is required")
    private String prescribing_doctor;

    protected PrescriptionItem (){}

    public String getPrescription_number() {
        return prescription_number;
    }

    public String getPrescription_type() {
        return prescription_type;
    }

    public String getPrescribing_doctor() {
        return prescribing_doctor;
    }

    //To string method
    @Override
    public String toString() {
        return "Prescription Item{" +
                "prescription Id=" + prescription_number +
                "prescription Number=" + prescription_number +
                ", prescription Type='" + prescription_type + '\'' +
                ", prescribing Doctor='" + prescribing_doctor + '\'' +
                '}';
    }


    //Creating a builder static class. An immutable class
    public static class Builder {
        private String prescription_number;
        private String prescription_type, prescribing_doctor;

        public Builder setPrescription_number(String prescription_number) {
            this.prescription_number = prescription_number;
            return this;
        }

        public Builder setPrescription_type(String prescription_type) {
            this.prescription_type = prescription_type;
            return this;
        }

        public Builder setPrescribing_doctor(String prescribing_doctor) {
            this.prescribing_doctor = prescribing_doctor;
            return this;
        }

        // copy method
        public Builder copy(PrescriptionItem prescriptionItem) {
            this.prescription_number = prescriptionItem.prescription_number;
            this.prescription_type = prescriptionItem.prescription_type;
            this.prescribing_doctor = prescriptionItem.prescribing_doctor;
            return this;
        }
        public PrescriptionItem build() {
            return new PrescriptionItem(this);
        }
    }

    //A private constructor
    private PrescriptionItem(Builder builder) {
        this.prescription_number = builder.prescription_number;
        this.prescribing_doctor = builder.prescribing_doctor;
        this.prescription_type = builder.prescription_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionItem that = (PrescriptionItem) o;
        return prescription_number == that.prescription_number &&
                prescription_type.equals(that.prescription_type) &&
                prescribing_doctor.equals(that.prescribing_doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescription_number, prescription_type, prescribing_doctor);
    }
}
