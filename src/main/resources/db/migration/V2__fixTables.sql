alter table challenge
    add unlock_trial_count int default 0 not null after id;

alter table challenge
drop column user_id;

alter table challenge
drop column type;

alter table challenge
    add unlock_done_count int default 0 not null after unlock_trial_count;

drop table receiver_bank_account;

alter table sender_bank_account
    add type VARCHAR(20) not null after money;

rename table sender_bank_account to bank_account;

alter table challenge
    change ended_at updated_at timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP;