# Write your MySQL query statement below
select name,bonus
from employee e 
left join bonus b
on  e.empId=b.empId
WHERE b.bonus < 1000 OR b.bonus IS NULL;