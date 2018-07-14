use toeiconline;
alter table user add column roleid bigint;
alter table user add constraint fk_user_role foreign key(roleid) references role(roleid);


#comment to user (n - 1)
alter table comment add constraint fk_user_comment foreign key(userid) references user(userid);
#comment to listenguideline (n - 1)
alter table comment add constraint fk_listenguideline_comment foreign key(listenguidelineid) references listenguideline(listenguidelineid);