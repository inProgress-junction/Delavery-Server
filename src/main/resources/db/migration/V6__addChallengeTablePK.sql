alter table challenge
    change user_id id char(26) not null;

alter table challenge
    add user_id char(26) not null after id;