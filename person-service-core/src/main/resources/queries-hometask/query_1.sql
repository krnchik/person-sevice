select * from person_db.medical.illness
                  inner join person_db.medical.medical_card mc on mc.id = illness.medical_card_id;