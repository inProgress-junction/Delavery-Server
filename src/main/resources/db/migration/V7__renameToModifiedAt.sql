alter table bank_account
    change updated_at modified_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP;

alter table challenge
    change updated_at modified_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP;

alter table user
    change updated_at modified_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP;