# Write your MySQL query statement below
select name
from customer
where referee_id!=2
      OR referee_id IS NULL;