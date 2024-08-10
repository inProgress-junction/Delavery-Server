alter table bank_account
    modify id char(36) not null;

alter table bank_account
    modify user_id char(36) not null;

alter table challenge
    modify id char(36) not null;

alter table challenge
    modify user_id char(36) not null;

alter table user
    modify id char(36) not null;

