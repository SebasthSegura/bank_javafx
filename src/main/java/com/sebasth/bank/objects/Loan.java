package com.sebasth.bank.objects;
import java.util.Objects;
import java.time.LocalDate;

public class Loan {
    private long loanId;
    private long borrowerId;
    private double principalAmount;
    private double interestRate;
    private Integer loanTermMonths;
    private double monthlyPayment;
    private double remainingBalance;
    private LocalDate startDate;
    private LocalDate endDate;
    private String loanType;
    private String status;

    /*agregamos los constructores (builders)*/
    public loan(){
        this.borrowerId = borrowerId;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.loanTermMonths = loanTermMonths;
        this.startDate = startDate;
        this.loanType = loanType;
        this.remainingBalance = principalAmount;
        this.monthlyPayment = calculateMonthlyPayment();
        this.endDate = calculateEndDate();
        this.status = "activo";
    }
    /*insertamos getters y setters*/

    public long getLoanId() {
        return loanId;
    }

    public void setLoanId(long loanId) {
        this.loanId = loanId;
    }

    public long getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(long borrowerId) {
        this.borrowerId = borrowerId;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getLoanTermMonths() {
        return loanTermMonths;
    }

    public void setLoanTermMonths(Integer loanTermMonths) {
        this.loanTermMonths = loanTermMonths;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //agregamos los metodos adicionales
    /*
    Calculamos el pago mensual del prestamo
    m = p [i(1 + i)^n] / [(1 + i)^n - 1]
    donde M  es el pago mensual, p  es igual a monto principal del prestamo
    i sera la tasa de interes mensual y n sera el numero total de pagos en meses.
     */

    private double calculateMonthlyPayment(){
        if (principalAmount == null || interestRate == null || loanTermMonths == null || loanTermMonths == 0){
            return 0.0;
        }
        double monthlyInterestRate = interestRate / 12.0;
        double denominator = Math.pow(1 + monthlyInterestRate, loanTermMonths) - 1;
        if (denominator == 0) {
            return principalAmount / loanTermMonths;
        }
        return (principalAmount * monthlyInterestRate * Math.pow(1 * monthlyInterestRate, loanTermMonths)) / denominator;
    }
    /*
    * calculamos la fecha de finalizacion del prestamo
    * */
    private LocalDate calculateEndDate(){
        if (startDate == null || loanTermMonths == null){
            return null;
        }
        return startDate.plusMonths(loanTermMonths);
    }
    /*
    * realiza un pago al prestamo
    * */
    public boolean makePayments(double paymentAmount){
        if (paymentAmount <= 0 || paymentAmount > remainingBalance){
            return false;
        }
        remainingBalance -= paymentAmount;
        if (remainingBalance == 0){
            status = "pagado";
            endDate = LocalDate.now(java.time.Clock.system(java.time.ZoneId.of("America/Bogota")));
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return  Objects.equals(loanId, loan.loanId);
    }

    @Override
    public int hashCode() {
        return  Objects.hash(loanId);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", borrowerId=" + borrowerId +
                ", principalAmount=" + principalAmount +
                ", interestRate=" + interestRate +
                ", loanTermMonths=" + loanTermMonths +
                ", monthlyPayment=" + monthlyPayment +
                ", remainingBalance=" + remainingBalance +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", loanType='" + loanType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}



