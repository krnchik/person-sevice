select  *  from person_db.medical.illness
order by id
limit (select count(*) / 2 as c from person_db.medical.illness);