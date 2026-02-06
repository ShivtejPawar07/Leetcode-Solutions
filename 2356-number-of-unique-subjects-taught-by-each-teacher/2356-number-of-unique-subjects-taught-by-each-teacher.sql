# Write your MySQL query statement below
select teacher_id,count(DISTINCT subject_id) as cnt
from teacher
group by teacher_id;