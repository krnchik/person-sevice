select mc.med_status, per.first_name, per.last_name,
       pd.first_name first_name_parent, pd.last_name last_name_parent
from person_db.medical.medical_card mc INNER JOIN
     person_db.medical.person_data per on mc.id = per.medical_card_id LEFT JOIN
     person_db.medical.person_data pd on per.id = pd.parent_id
where mc.med_status is null;