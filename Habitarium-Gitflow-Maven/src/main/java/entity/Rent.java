package main.java.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "rent")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "rent")
    private Property property;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rent")
    private Lessor lessor;

    private float value;
    private Date entranceDate;
    private Date exitDate;
    private Date readjustmentDate;
    private int payDay;
    private int amountPaidMonth = 0;

    @ElementCollection
    private Map<Date, Float> datePaidAndValue;

    @ElementCollection
    private Map<Date, Boolean> monthToBePaid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "entrance_date")
    public Date getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(Date entranceDate) {
        this.entranceDate = entranceDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "exit_date")
    public Date getExitDate() {
        return exitDate;
    }

    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "readjustment_date")
    public Date getReadjustmentDate() {
        return readjustmentDate;
    }

    public void setReadjustmentDate(Date readjustmentDate) {
        this.readjustmentDate = readjustmentDate;
    }

    public int getPayDay() {
        return payDay;
    }

    public void setPayDay(int payDay) {
        this.payDay = payDay;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Lessor getLessor() {
        return lessor;
    }

    public void setLessor(Lessor lessor) {
        this.lessor = lessor;
    }

    public Map<Date, Float> getDatePaidAndValue() {
        return datePaidAndValue;
    }

    public void setDatePaidAndValue(Date date, Float value) {
        this.datePaidAndValue.put(date, value);
    }

    public int getAmountPaidMonth() {
        return amountPaidMonth;
    }

    public void setAmountPaidMonth(int amountPaidMonth) {
        this.amountPaidMonth = amountPaidMonth;
    }
    public Map<Date, Boolean> getMonthToBePaid() {
        return monthToBePaid;
    }

    public void setMonthToBePaid(Date date, Boolean paid) {
        this.monthToBePaid.put(date, paid);
    }
}
