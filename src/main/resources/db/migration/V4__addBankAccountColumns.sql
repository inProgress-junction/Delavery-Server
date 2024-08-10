alter table bank_account
    add account_number int not null after money;

alter table bank_account
    add bank_type VARCHAR(20) not null after account_number;