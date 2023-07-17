package com.problem4;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Account {
    @Id
    private String accNo;
    private AccountType type;
    private String bankName;
    private String branchName;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Transaction", joinColumns = @JoinColumn(name = "account_id"))
    private Set<Integer> transactionIds = new HashSet<>();

    public Account() {
    }

    public Account(String accNo, AccountType type, String bankName, String branchName) {
        this.accNo = accNo;
        this.type = type;
        this.bankName = bankName;
        this.branchName = branchName;
    }

    public String getAccNo() {
        return accNo;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Set<Integer> getTransactionIds() {
        return transactionIds;
    }

    public void setTransactionIds(Set<Integer> transactionIds) {
        this.transactionIds = transactionIds;
    }
}