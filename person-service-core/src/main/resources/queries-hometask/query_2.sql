delete from person_db.medical.illness il1
where il1.id not in
      (
          select min(id) min
          from person_db.medical.illness il
          GROUP BY il.appearance_dttm, il.heaviness,
                   il.recovery_dt, il.type_id, il.medical_card_id
      );