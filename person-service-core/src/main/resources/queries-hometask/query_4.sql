DO
$do$
    BEGIN
        IF EXISTS (SELECT FROM pg_class WHERE relname = 'multi_view') THEN
            RAISE NOTICE 'View already exists';  -- optional
        ELSE
            Execute 'CREATE VIEW multi_view AS (SELECT i.type_id,i.recovery_dt, mc.client_status FROM person_db.medical.medical_card mc
                          INNER JOIN person_db.medical.illness i
                              on mc.id = i.medical_card_id);';
        END IF;
    END
$do$;